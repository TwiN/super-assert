package org.twinnation.superassert;

import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class NotNullTest {

	@Test
	public void notNull() {
		assertTrue("Object passed is not null", SuperAssert.notNull(new Object(), "This should not throw an exception"));
	}


	@Test(expected = IllegalArgumentException.class)
	public void notNull_withNullObject() {
		SuperAssert.notNull(null, "EXCEPTION_MESSAGE");
	}


	@Test
	public void notNull_withCustomException() throws Exception {
		assertTrue("Object passed is not null",
			SuperAssert.notNull(new Object(), new CustomException("This should not throw an exception")));
	}


	@Test(expected = CustomException.class)
	public void notNull_withCustomExceptionAndNullObject() throws Exception {
		SuperAssert.notNull(null, new CustomException("CUSTOM_EXCEPTION_MESSAGE"));
	}

}