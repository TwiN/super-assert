package org.twinnation.superassert;

import org.junit.Test;

import static org.junit.Assert.*;


public class SuperAssertTest {
	
	@Test
	public void notNull() {
		assertTrue("Object passed is not null, no exception should have been thrown",
			SuperAssert.notNull(new Integer(1), "EXCEPTION_MESSAGE"));
	}
	
	
	@Test(expected = Exception.class)
	public void notNull_withNullObject() {
		SuperAssert.notNull(null, "EXCEPTION_MESSAGE");
	}
	
	
	@Test
	public void notNull_withCustomException() throws Exception {
		assertTrue("Object passed is not null, no exception should have been thrown",
			SuperAssert.notNull(new Integer(1), new CustomException("CUSTOM_EXCEPTION_MESSAGE")));
	}
	
	
	@Test(expected = CustomException.class)
	public void notNull_withCustomExceptionAndNullObject() throws Exception {
		SuperAssert.notNull(null, new CustomException("CUSTOM_EXCEPTION_MESSAGE"));
	}
	
	
	@Test
	public void isTrue() {
		assertTrue("Condition passed is true", SuperAssert.isTrue(true, "This should not throw an exception"));
	}
	
	
	@Test(expected = Exception.class)
	public void isTrue_withFalseCondition() {
		assertTrue("Condition passed is false, an exception should have been thrown",
			SuperAssert.isTrue(false, "EXCEPTION_MESSAGE"));
	}
	
	
	@Test
	public void isTrue_withCustomException() throws Exception {
		assertTrue("Condition passed is true, no exception should be thrown",
			SuperAssert.isTrue(true, new CustomException("CUSTOM_EXCEPTION_MESSAGE")));
	}
	
	
	@Test(expected = CustomException.class)
	public void isTrue_withCustomExceptionAndFalseCondition() throws Exception {
		SuperAssert.isTrue(false, new CustomException("CUSTOM_EXCEPTION_MESSAGE"));
	}
	
	
	static class CustomException extends Exception {
		public CustomException(String message) {
			super(message);
		}
	}
	
}