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
		return isTrue(!b, message);
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

}
