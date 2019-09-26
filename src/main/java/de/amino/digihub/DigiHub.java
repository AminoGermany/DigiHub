package de.amino.digihub;

import com.google.gson.JsonObject;
import de.amino.digihub.exception.AuthenticationException;
import de.amino.digihub.user.IGUSUser;
import de.amino.digihub.util.HttpUtils;
import de.amino.digihub.util.JsonUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Locale;

/**
 * Main class used for authentication and processing server requests.
 * Should be instantiated once for each client instance.
 *
 * @author Alexander Hinze
 */
public class DigiHub {

	private static final HttpClient client = HttpClientBuilder.create().build();
	private final String serverAddress;

	/**
	 * @param serverAddress The GUS-OS server address.
	 */
	public DigiHub(@NotNull String serverAddress) {
		this.serverAddress = serverAddress;
	}

	/**
	 * Authenticates the given user instance against the server.
	 * This fills in {@link de.amino.digihub.user.IGUSUser#getClientToken()} and {@link de.amino.digihub.user.IGUSUser#getUserName()}.
	 *
	 * @param user The user.
	 * @return The authenticated user.
	 * @throws de.amino.digihub.exception.AuthenticationException If the authentication failed.
	 */
	@Nullable
	public IGUSUser authenticate(@Nullable IGUSUser user) throws AuthenticationException {
		if(user == null) {
			return null;
		}

		try {
			final JsonObject requestObject = new JsonObject();
			requestObject.addProperty("company", 999); //TODO: Figure out what this does!
			requestObject.addProperty("userid", user.getUserID());
			requestObject.addProperty("password", user.getPassword());
			final String requestUrl = String.format("%s/os/api/v1/auth", serverAddress);
			HttpPost request = new HttpPost(requestUrl);
			request.setEntity(new StringEntity(requestObject.toString()));
			HttpResponse response = client.execute(request);
			HttpUtils.validateResponse(response);
			JsonObject responseObject = JsonUtils.read(request.getEntity().getContent(), JsonObject.class);
			user.setClientLocale(Locale.forLanguageTag(responseObject.get("locale").getAsString()));
			user.setClientToken(responseObject.get("token").getAsString());
			user.setUserName(responseObject.get("username").getAsString());
			return user;
		}
		catch(Exception e) {
			throw new AuthenticationException(e);
		}
	}

}
