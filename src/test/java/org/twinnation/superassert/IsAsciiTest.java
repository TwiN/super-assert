package org.twinnation.superassert;

import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class IsAsciiTest {

	@Test
	public void isAscii() {
		assertTrue("String only has ASCII characters",
			SuperAssert.isAscii("!\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHI", "This should not throw an exception"));
		assertTrue("String only has ASCII characters",
			SuperAssert.isAscii("JKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqr", "This should not throw an exception"));
		assertTrue("String only has ASCII characters",
			SuperAssert.isAscii("stuvwxyz{|}~ ", "This should not throw an exception"));
		assertTrue("String only has ASCII characters",
			SuperAssert.isAscii("", "This should not throw an exception"));
		assertTrue("Character is ASCII", SuperAssert.isAscii('a', "This should not throw an exception"));
		assertTrue("Character is ASCII", SuperAssert.isAscii('A', "This should not throw an exception"));
		assertTrue("Character is ASCII", SuperAssert.isAscii('@', "This should not throw an exception"));
		assertTrue("Character is ASCII", SuperAssert.isAscii(' ', "This should not throw an exception"));
	}


	@Test(expected = IllegalArgumentException.class)
	public void isAscii_withNullString() {
		SuperAssert.isAscii(null, "EXCEPTION_MESSAGE");
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void isAscii_withNonAsciiString() {
		SuperAssert.isAscii("abc\ndef", "EXCEPTION_MESSAGE");
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void isAscii_withNonAsciiCharacter() {
		SuperAssert.isAscii((char)127, "EXCEPTION_MESSAGE");
	}


	@Test
	public void isAscii_withCustomException() throws Exception {
		assertTrue("The character passed is a valid printable ASCII character and should not throw an exception",
			SuperAssert.isAscii('A', new CustomException("This should not throw an exception")));
	}


	@Test(expected = CustomException.class)
	public void isAscii_withCustomExceptionAndNonAsciiCharacter() throws Exception {
		SuperAssert.isAscii('\n', new CustomException("CUSTOM_EXCEPTION_MESSAGE"));
	}

}