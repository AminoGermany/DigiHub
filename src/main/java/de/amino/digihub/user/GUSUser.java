package de.amino.digihub.user;

import de.amino.digihub.util.Base64Utils;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;

public class GUSUser implements IGUSUser {

	private final String userID;
	private final String password;
	private String token;
	private String encodedToken;
	private String userName;
	private Locale locale;

	public GUSUser(@NotNull String userID, @NotNull String password) {
		this.userID = userID;
		this.password = password;
	}

	@NotNull
	@Override
	public String getUserID() {
		return userID;
	}

	@NotNull
	@Override
	public String getPassword() {
		return password;
	}

	@NotNull
	@Override
	public String getClientToken() {
		return token;
	}

	@Override
	public void setClientToken(@NotNull String clientToken) {
		token = clientToken;
		encodedToken = Base64Utils.encode(clientToken);
	}

	@NotNull
	@Override
	public String getEncodedClientToken() {
		return encodedToken;
	}

	@NotNull
	@Override
	public String getUserName() {
		return userName;
	}

	@Override
	public void setUserName(@NotNull String userName) {
		this.userName = userName;
	}

	@NotNull
	@Override
	public Locale getClientLocale() {
		return locale;
	}

	@Override
	public void setClientLocale(@NotNull Locale locale) {
		this.locale = locale;
	}

}
