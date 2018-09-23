package org.twinnation.superassert;

import org.junit.Test;

import static org.junit.Assert.*;


public class HasLengthTest {

	@Test
	public void hasLength() {
		assertTrue("String has a valid length", SuperAssert.hasLength("abc", 2, 4, "This should not throw an exception"));
		assertTrue("String has a valid length", SuperAssert.hasLength("abc", 3, 3, "This should not throw an exception"));
		assertTrue("String has a valid length", SuperAssert.hasLength("abc", 0, 9, "This should not throw an exception"));
		assertTrue("String has a valid length", SuperAssert.hasLength("abc", 3, 9, "This should not throw an exception"));
		assertTrue("String has a valid length", SuperAssert.hasLength("abc", 0, 3, "This should not throw an exception"));
		assertTrue("String has a valid length", SuperAssert.hasLength("abc", 0, "This should not throw an exception"));
		assertTrue("String has a valid length", SuperAssert.hasLength("abcd", 4, "This should not throw an exception"));
		assertTrue("String has a valid length", SuperAssert.hasLength("abcde", 4, "This should not throw an exception"));
	}


	@Test(expected = IllegalArgumentException.class)
	public void hasLength_withNullString() {
		SuperAssert.hasLength(null, 0, "EXCEPTION_MESSAGE");
	}


	@Test(expected = IllegalArgumentException.class)
	public void hasLength_withLengthTooShort() {
		SuperAssert.hasLength("abc", 6, 14, "EXCEPTION_MESSAGE");
	}


	@Test(expected = IllegalArgumentException.class)
	public void hasLength_withLengthTooShortAndNoMaximum() {
		SuperAssert.hasLength("abc", 6, "EXCEPTION_MESSAGE");
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void hasLength_withLengthTooLong() {
		SuperAssert.hasLength("abcde", 2, 4, "EXCEPTION_MESSAGE");
	}


	@Test(expected = AssertionError.class)
	public void hasLength_withInvalidLengthParameters() {
		SuperAssert.hasLength("abc", 6, 5, "EXCEPTION_MESSAGE"); // min has to be higher than max
	}


	@Test(expected = AssertionError.class)
	public void hasLength_withInvalidLengthParametersAgain() {
		SuperAssert.hasLength("abc", 6, -2, "EXCEPTION_MESSAGE"); // max has to be higher than min, unless it's -1 (no max)
	}


	@Test(expected = AssertionError.class)
	public void hasLength_withNegativeMinLengthParameter() {
		SuperAssert.hasLength("abc", -1, "EXCEPTION_MESSAGE"); // min cannot be negative
	}

}