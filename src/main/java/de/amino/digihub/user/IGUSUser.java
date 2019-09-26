package de.amino.digihub.user;

import org.jetbrains.annotations.NotNull;

import java.util.Locale;

/**
 * Holds information about a user as well as authentication data.
 *
 * @author Alexander Hinze
 */
public interface IGUSUser {

	/**
	 * @return The user ID.
	 */
	@NotNull String getUserID();

	/**
	 * @return The password.
	 */
	@NotNull String getPassword();

	/**
	 * @return The client authentication token.
	 */
	@NotNull String getClientToken();

	/**
	 * Sets the client authentication token of this user instance.
	 *
	 * @param clientToken The authentication token.
	 */
	void setClientToken(@NotNull String clientToken);

	/**
	 * @return The base64 encoded client authentication token.
	 */
	@NotNull String getEncodedClientToken();

	/**
	 * @return The display user name.
	 */
	@NotNull String getUserName();

	/**
	 * Sets the user name of this user instance.
	 *
	 * @param userName The user name.
	 */
	void setUserName(@NotNull String userName);

	/**
	 * @return The client's locale.
	 */
	@NotNull Locale getClientLocale();

	/**
	 * Sets the locale of this user instance.
	 *
	 * @param locale The locale.
	 */
	void setClientLocale(@NotNull Locale locale);

}
