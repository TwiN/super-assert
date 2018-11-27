package org.twinnation.superassert;

/**
 * This class is used only for testing purposes, hence its encapsulation
 */
class CustomException extends RuntimeException {

	CustomException(String message) {
		super(message);
	}
	
	
	CustomException() {
		super("CUSTOM_EXCEPTION_MESSAGE");
	}

}