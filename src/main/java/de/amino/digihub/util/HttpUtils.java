package de.amino.digihub.util;

import de.amino.digihub.exception.StatusCodeException;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.jetbrains.annotations.Nullable;

/**
 * Utilities for working with HTTP objects/entities.
 *
 * @author Alexander Hinze
 */
public class HttpUtils {

	/**
	 * Validates the given HTTP response and handles possible error codes.
	 *
	 * @param response The HTTP response.
	 */
	public static void validateResponse(@Nullable HttpResponse response) {
		if(response == null) {
			return;
		}

		final StatusLine statusLine = response.getStatusLine();
		final int code = statusLine.getStatusCode();

		switch(code) {
			//@formatter:off
			case StatusCodes.NOT_AUTHORIZED:        throw new StatusCodeException(code, "Not authorized");
			case StatusCodes.NOT_FOUND:             throw new StatusCodeException(code, "Not found");
			case StatusCodes.FORBIDDEN:             throw new StatusCodeException(code, "Forbidden");
			case StatusCodes.MALFORMED_REQUEST:     throw new StatusCodeException(code, "Malformed request");
			case StatusCodes.METHOD_NOT_ALLOWED:    throw new StatusCodeException(code, "Method not allowed");
			case StatusCodes.INTERNAL_SERVER_ERROR: throw new StatusCodeException(code, "Internal server error");
			//@formatter:on
		}
	}

}
