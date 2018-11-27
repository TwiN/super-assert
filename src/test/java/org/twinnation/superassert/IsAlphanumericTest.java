package org.twinnation.superassert;

import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class IsAlphanumericTest {

	@Test
	public void isAlphanumeric() {
		assertTrue("String is alphanumeric", SuperAssert.isAscii("abcdefgxyz", "This should not throw an exception"));
		assertTrue("String is alphanumeric", SuperAssert.isAscii("ABCDEFGXYZ", "This should not throw an exception"));
		assertTrue("String is alphanumeric", SuperAssert.isAscii("0123456789", "This should not throw an exception"));
		assertTrue("Character is alphanumeric", SuperAssert.isAscii('a', "This should not throw an exception"));
		assertTrue("Character is alphanumeric", SuperAssert.isAscii('A', "This should not throw an exception"));
		assertTrue("Character is alphanumeric", SuperAssert.isAscii('0', "This should not throw an exception"));
		assertTrue("Character is alphanumeric", SuperAssert.isAscii('9', "This should not throw an exception"));
	}


	@Test(expected = IllegalArgumentException.class)
	public void isAlphanumeric_withNullString() {
		SuperAssert.isAlphanumeric(null, "EXCEPTION_MESSAGE");
	}


	@Test(expected = IllegalArgumentException.class)
	public void isAlphanumeric_withNonAlphanumericString() {
		SuperAssert.isAlphanumeric("hello, world!", "EXCEPTION_MESSAGE");
	}


	@Test(expected = IllegalArgumentException.class)
	public void isAlphanumeric_withNonAlphanumericCharacter() {
		SuperAssert.isAlphanumeric(' ', "EXCEPTION_MESSAGE");
	}
	
	
	@Test(expected = CustomException.class)
	public void isAlphanumeric_withCustomException() {
		SuperAssert.isAlphanumeric("hello, world!", new CustomException());
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void isAlphanumeric_withNullStringAndCustomException() {
		// Because this the str parameter is annotated with @NotNull, you shouldn't expect to have CustomException
		// here, but instead, IllegalArgumentException
		SuperAssert.isAlphanumeric(null, new CustomException());
	}

}