package org.twinnation.superassert;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertTrue;


public class NotEmptyOrNullTest {

	@Test
	public void notEmptyOrNull() {
		assertTrue("List passed is not empty or null",
			SuperAssert.notEmpty(Arrays.asList(1, 2, 3), "This should not throw an exception"));
	}


	@Test(expected = IllegalArgumentException.class)
	public void notEmptyOrNull_withEmptyList() {
		SuperAssert.notEmpty(Collections.emptyList(), "EXCEPTION_MESSAGE");
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void notEmptyOrNull_withEmptySet() {
		SuperAssert.notEmpty(Collections.emptySet(), "EXCEPTION_MESSAGE");
	}


	@Test(expected = IllegalArgumentException.class)
	public void notEmptyOrNull_withNullCollection() {
		SuperAssert.notEmptyOrNull(null, "EXCEPTION_MESSAGE");
	}


	@Test
	public void notEmptyOrNull_withCustomException() throws Exception {
		assertTrue("List passed is not empty or null",
			SuperAssert.notEmptyOrNull(Arrays.asList(1, 2, 3), new CustomException("This should not throw an exception")));
	}


	@Test(expected = CustomException.class)
	public void notEmptyOrNull_withCustomExceptionAndEmptyList() throws Exception {
		SuperAssert.notEmptyOrNull(Collections.emptyList(), new CustomException("CUSTOM_EXCEPTION_MESSAGE"));
	}


	@Test(expected = CustomException.class)
	public void notEmptyOrNull_withCustomExceptionAndNullCollection() throws Exception {
		SuperAssert.notEmptyOrNull(null, new CustomException("CUSTOM_EXCEPTION_MESSAGE"));
	}

}