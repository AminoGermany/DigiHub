package de.amino.digihub.exception;

import org.jetbrains.annotations.NotNull;

/**
 * Exception used for HTTP response code validation.
 *
 * @author Alexander Hinze
 */
public class StatusCodeException extends RuntimeException {

	public final int code;

	public StatusCodeException(int code, @NotNull String message) {
		super(String.format("%d: %s", code, message));
		this.code = code;
	}

}
