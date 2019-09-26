package de.amino.digihub.util;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.stream.JsonReader;
import org.jetbrains.annotations.Nullable;

import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Utilities for working with JSON objects.
 *
 * @author Alexander Hinze
 */
public class JsonUtils {

	public static final Gson gson = new Gson();

	/**
	 * Reads a JSON element from the given input stream based on the given type.
	 * Returns null if the given stream or type are null or if the data could not be read.
	 *
	 * @param stream The input stream to read from.
	 * @param type   The type of the JSON element.
	 * @param <E>    The element's generic type.
	 * @return The element.
	 */
	@Nullable
	public static <E extends JsonElement> E read(@Nullable InputStream stream, @Nullable Class<E> type) {
		if(stream == null || type == null) {
			return null;
		}
		JsonReader reader = null;

		try {
			reader = new JsonReader(new InputStreamReader(stream));
			return gson.fromJson(reader, type);
		}
		catch(Exception e) {
			return null;
		}
		finally {
			IOUtils.closeQuietly(reader);
		}
	}

}
