package org.twinnation.superassert;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;


public class SuperAssertTest {

	////////////
	// isNull //
	////////////
	
	
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
	
	
	////////////
	// isTrue //
	////////////
	
	
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
	
	
	/////////////
	// isFalse //
	/////////////
	
	
	@Test
	public void isFalse() {
		assertTrue("Condition passed is false", SuperAssert.isFalse(false, "This should not throw an exception"));
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void isFalse_withTrueCondition() {
		SuperAssert.isFalse(true, "EXCEPTION_MESSAGE");
	}
	
	
	//////////////
	// notEmpty //
	//////////////
	
	
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
	
	
	////////////////////
	// notEmptyOrNull //
	////////////////////
	
	
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
	public void notEmptyOrNull_withNullList() {
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
	public void notEmptyOrNull_withCustomExceptionAndNullList() throws Exception {
		SuperAssert.notEmptyOrNull(null, new CustomException("CUSTOM_EXCEPTION_MESSAGE"));
	}
	
	
	/////////////
	// isAscii //
	/////////////
	
	
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
	
	
	////////////////////
	// isAlphanumeric //
	////////////////////
	
	
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
	
	
	///////////////
	// hasLength //
	///////////////
	
	
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