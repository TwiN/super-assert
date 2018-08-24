package org.twinnation.superassert;


public class SuperAssert {
	
	public static boolean notNull(Object object, String message) {
		if (object == null) {
			throw new IllegalArgumentException(message);
		}
		return true;
	}
	
	
	public static <T extends Exception> boolean notNull(Object object, T customException) throws T {
		if (object == null) {
			throw customException;
		}
		return true;
	}
	
	
	public static boolean isTrue(boolean b, String message) {
		if (!b) {
			throw new IllegalArgumentException(message);
		}
		return true;
	}
	
	
	public static <T extends Exception> boolean isTrue(boolean b, T customException) throws T {
		if (!b) {
			throw customException;
		}
		return true;
	}
	
	
	public static boolean isFalse(boolean b, String message) {
		return isTrue(!b, message);
	}
	
	
	public static <T extends Exception> boolean isFalse(boolean b, T customException) throws T {
		return isTrue(!b, customException);
	}

}
