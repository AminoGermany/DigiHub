package de.amino.digihub.util;

import org.jetbrains.annotations.Nullable;

import java.io.Closeable;

/**
 * Utilities for working with the file system and data streams.
 *
 * @author Alexander Hinze
 */
public class IOUtils {

	/**
	 * Closes the given instance of {@link java.io.Closeable} without
	 * throwing exceptions.
	 * The given object may be null.
	 *
	 * @param closeable The closeable.
	 */
	public static void closeQuietly(@Nullable Closeable closeable) {
		if(closeable == null) {
			return;
		}

		try {
			closeable.close();
		}
		catch(Exception e) {
		}
	}

}
