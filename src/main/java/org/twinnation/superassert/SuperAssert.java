package org.twinnation.superassert;

import org.twinnation.superassert.annotation.NotNull;
import org.twinnation.superassert.annotation.Nullable;

import java.util.List;


public class SuperAssert {
	
	private static final int NO_MAX_LENGTH = -1;
	
	
	public static <T extends Exception> boolean notNull(@Nullable Object object, T customException) throws T {
		if (object == null) {
			throw customException;
		}
		return true;
	}
	
	
	public static boolean notNull(@Nullable Object object, String message) {
		return notNull(object, new IllegalArgumentException(message));
	}
	
	
	public static <T extends Exception> boolean isNull(@Nullable Object object, T customException) throws T {
		if (object != null) {
			throw customException;
		}
		return true;
	}
	
	
	public static boolean isNull(@Nullable Object object, String message) {
		return isNull(object, new IllegalArgumentException(message));
	}
	
	
	public static <T extends Exception> boolean isTrue(boolean b, T customException) throws T {
		if (!b) {
			throw customException;
		}
		return true;
	}
	
	
	public static boolean isTrue(boolean b, String message) {
		return isTrue(b, new IllegalArgumentException(message));
	}
	
	
	public static <T extends Exception> boolean isFalse(boolean b, T customException) throws T {
		return isTrue(!b, customException);
	}

	
	public static boolean isFalse(boolean b, String message) {
		return isFalse(b, new IllegalArgumentException(message));
	}
	
	
	public static <T extends Exception> boolean notEmpty(@NotNull List<?> list, T customException) throws T {
		if (list.isEmpty()) {
			throw customException;
		}
		return true;
	}
	
	
	public static boolean notEmpty(@NotNull List<?> list, String message) {
		return notEmpty(list, new IllegalArgumentException(message));
	}
	
	
	public static <T extends Exception> boolean notEmptyOrNull(@Nullable List<?> list, T customException) throws T {
		return notNull(list, customException) && notEmpty(list, customException);
	}
	
	
	public static boolean notEmptyOrNull(@Nullable List<?> list, String message) {
		return notNull(list, message) && notEmpty(list, message);
	}
	
	
	public static <T extends Exception> boolean isAscii(char c, T customException) throws T {
		return isTrue((int)c > 31 && (int)c < 127, customException);
	}
	
	
	public static boolean isAscii(char c, String message) {
		return isAscii(c, new IllegalArgumentException(message));
	}
	
	
	public static <T extends Exception> boolean isAscii(@NotNull String str, T customException) throws T {
		notNull(str, "Type checked against must not be null");
		for (char c : str.toCharArray()) {
			isAscii(c, customException);
		}
		return true;
	}
	
	
	public static boolean isAscii(@NotNull String str, String message) {
		return isAscii(str, new IllegalArgumentException(message));
	}
	
	
	public static <T extends Exception> boolean isAlphanumeric(char c, T customException) throws T {
		return isTrue(Character.isLetterOrDigit(c), customException);
	}
	
	
	public static boolean isAlphanumeric(char c, String message) {
		return isAlphanumeric(c, new IllegalArgumentException(message));
	}
	
	
	public static <T extends Exception> boolean isAlphanumeric(@NotNull String str, T customException) throws T {
		notNull(str, "Type checked against must not be null");
		for (char c : str.toCharArray()) {
			isAlphanumeric(c, customException);
		}
		return true;
	}
	
	
	public static boolean isAlphanumeric(@NotNull String str, String message) {
		return isAlphanumeric(str, new IllegalArgumentException(message));
	}
	
	
	public static <T extends Exception> boolean hasLength(@NotNull String str, int minLength, int maxLength, T customException) throws T {
		assert minLength >= 0; // minLength has to be at least 0
		assert maxLength == NO_MAX_LENGTH || maxLength >= minLength; // if there's a max, it must be higher than the min
		notNull(str, "Type checked against must not be null");
		// Check for maxLength only if the value of maxLength is not NO_MAX_LENGTH
		return isTrue(str.length() >= minLength && (maxLength == NO_MAX_LENGTH || (str.length() <= maxLength)),
			customException);
	}
	
	
	public static boolean hasLength(@NotNull String str, int minLength, int maxLength, String message) {
		return hasLength(str, minLength, maxLength, new IllegalArgumentException(message));
	}
	
	
	public static <T extends Exception> boolean hasLength(@NotNull String str, int minLength, T customException) throws T {
		return hasLength(str, minLength, NO_MAX_LENGTH, customException);
	}
	
	
	public static boolean hasLength(@NotNull String str, int minLength, String message) {
		return hasLength(str, minLength, NO_MAX_LENGTH, new IllegalArgumentException(message));
	}

}
