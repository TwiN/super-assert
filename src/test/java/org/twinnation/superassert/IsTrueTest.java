package org.twinnation.superassert;

import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class IsTrueTest {

	@Test
	public void isTrue() {
		assertTrue("Condition passed is true", SuperAssert.isTrue(true, "This should not throw an exception"));
	}


	@Test(expected = IllegalArgumentException.class)
	public void isTrue_withFalseCondition() {
		SuperAssert.isTrue(false, "EXCEPTION_MESSAGE");
	}


	@Test
	public void isTrue_withCustomException() throws Exception {
		assertTrue("Condition passed is true",
			SuperAssert.isTrue(true, new CustomException("This should not throw an exception")));
	}


	@Test(expected = CustomException.class)
	public void isTrue_withCustomExceptionAndFalseCondition() throws Exception {
		SuperAssert.isTrue(false, new CustomException("CUSTOM_EXCEPTION_MESSAGE"));
	}

}