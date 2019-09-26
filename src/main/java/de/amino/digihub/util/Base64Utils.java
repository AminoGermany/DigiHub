package de.amino.digihub.util;

import org.jetbrains.annotations.Nullable;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

/**
 * Utilities for working with base64 data.
 *
 * @author Alexander Hinze
 */
public class Base64Utils {

	private static final Encoder encoder = Base64.getEncoder();
	private static final Decoder decoder = Base64.getDecoder();

	/**
	 * Encodes the given string as a base64 string.
	 *
	 * @param s The decoded string.
	 * @return The string encoded as base64.
	 */
	@Nullable
	public static String encode(@Nullable String s) {
		if(s == null) {
			return null;
		}
		return encoder.encodeToString(s.getBytes());
	}

	/**
	 * Decodes the given base64 string as a string.
	 *
	 * @param s The base64 encoded string.
	 * @return The decoded string.
	 */
	@Nullable
	public static String decode(@Nullable String s) {
		if(s == null) {
			return null;
		}
		return new String(decoder.decode(s.getBytes()));
	}

}
