package org.twinnation.superassert;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertTrue;


public class NotEmptyTest {

	@Test
	public void notEmpty() {
		assertTrue("List passed is not empty",
			SuperAssert.notEmpty(Arrays.asList(1, 2, 3), "This should not throw an exception"));
	}


	@Test(expected = IllegalArgumentException.class)
	public void notEmpty_withEmptyList() {
		SuperAssert.notEmpty(Collections.emptyList(), "EXCEPTION_MESSAGE");
	}


	@Test
	public void notEmpty_withCustomException() throws Exception {
		assertTrue("List passed is not empty",
			SuperAssert.notEmpty(Arrays.asList(1, 2, 3), new CustomException("This should not throw an exception")));
	}


	@Test(expected = CustomException.class)
	public void notEmpty_withCustomExceptionAndEmptyList() throws Exception {
		SuperAssert.notEmpty(Collections.emptyList(), new CustomException("CUSTOM_EXCEPTION_MESSAGE"));
	}

}