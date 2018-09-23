package org.twinnation.superassert;

import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class IsNullTest {

	@Test
	public void isNull() {
		assertTrue("Object passed is null", SuperAssert.isNull(null, "This should not throw an exception"));
	}


	@Test(expected = IllegalArgumentException.class)
	public void isNull_withNotNullObject() {
		SuperAssert.isNull(new Object(), "EXCEPTION_MESSAGE");
	}


	@Test
	public void isNull_withCustomException() throws Exception {
		assertTrue("Object passed is null", SuperAssert.isNull(null, new CustomException("This should not throw an exception")));
	}


	@Test(expected = CustomException.class)
	public void isNull_withCustomExceptionAndNotNullObject() throws Exception {
		SuperAssert.isNull(new Object(), new CustomException("CUSTOM_EXCEPTION_MESSAGE"));
	}

}