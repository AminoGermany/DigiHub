package de.amino.digihub.exception;

import org.jetbrains.annotations.Nullable;

/**
 * @author Alexander Hinze
 */
public class AuthenticationException extends RuntimeException {

	public AuthenticationException(@Nullable Throwable t) {
		super(t != null ? t : new Throwable("null"));
	}

	public AuthenticationException(@Nullable String message, Object... params) {
		super(message != null ? String.format(message, params) : "null");
	}

}
