package org.twinnation.superassert;

import java.util.List;


public class SuperAssert {
	
	public static <T extends Exception> boolean notNull(Object object, T customException) throws T {
		if (object == null) {
			throw customException;
		}
		return true;
	}
	
	
	public static boolean notNull(Object object, String message) {
		return notNull(object, new IllegalArgumentException(message));
	}
	
	
	public static <T extends Exception> boolean isNull(Object object, T customException) throws T {
		if (object != null) {
			throw customException;
		}
		return true;
	}
	
	
	public static boolean isNull(Object object, String message) {
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
	
	
	public static <T extends Exception> boolean notEmpty(List<?> list, T customException) throws T {
		if (list.isEmpty()) {
			throw customException;
		}
		return true;
	}
	
	
	public static boolean notEmpty(List<?> list, String message) {
		return notEmpty(list, new IllegalArgumentException(message));
	}
	
	
	public static <T extends Exception> boolean notEmptyOrNull(List<?> list, T customException) throws T {
		return notNull(list, customException) && notEmpty(list, customException);
	}
	
	
	public static boolean notEmptyOrNull(List<?> list, String message) {
		return notNull(list, message) && notEmpty(list, message);
	}
	
	
	public static <T extends Exception> boolean isAscii(char c, T customException) throws T {
		return isTrue((int)c > 31 && (int)c < 127, customException);
	}
	
	
	public static boolean isAscii(char c, String message) {
		return isAscii(c, new IllegalArgumentException(message));
	}
	
	
	public static <T extends Exception> boolean isAscii(String str, T customException) throws T {
		for (char c : str.toCharArray()) {
			isAscii(c, customException);
		}
		return true;
	}
	
	
	public static boolean isAscii(String str, String message) {
		return isAscii(str, new IllegalArgumentException(message));
	}
	
	
	public static <T extends Exception> boolean isAlphanumeric(char c, T customException) throws T {
		return isTrue(Character.isLetterOrDigit(c), customException);
	}
	
	
	public static boolean isAlphanumeric(char c, String message) {
		return isAlphanumeric(c, new IllegalArgumentException(message));
	}
	
	
	public static <T extends Exception> boolean isAlphanumeric(String str, T customException) throws T {
		for (char c : str.toCharArray()) {
			isAlphanumeric(c, customException);
		}
		return true;
	}
	
	
	public static boolean isAlphanumeric(String str, String message) {
		return isAlphanumeric(str, new IllegalArgumentException(message));
	}

}
