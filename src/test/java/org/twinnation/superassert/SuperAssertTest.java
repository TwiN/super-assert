package org.twinnation.superassert;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;


public class SuperAssertTest {
	
	/////////////
	// notNull //
	/////////////
	
	
	@Test
	public void notNull() {
		assertTrue("Object passed is not null", SuperAssert.notNull(new Object(), "This should not throw an exception"));
	}
	
	
	@Test(expected = Exception.class)
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
	
	
	/////////////
	// isNull //
	/////////////
	
	
	@Test
	public void isNull() {
		assertTrue("Object passed is null", SuperAssert.isNull(null, "This should not throw an exception"));
	}
	
	
	@Test(expected = Exception.class)
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
	
	
	@Test(expected = Exception.class)
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
	
	
	////////////
	// isFalse //
	////////////
	
	
	@Test
	public void isFalse() {
		assertTrue("Condition passed is false", SuperAssert.isFalse(false, "This should not throw an exception"));
	}
	
	
	@Test(expected = Exception.class)
	public void isFalse_withTrueCondition() {
		SuperAssert.isFalse(true, "This should throw an exception");
	}
	
	
	//////////////
	// notEmpty //
	//////////////
	
	
	@Test
	public void notEmpty() {
		assertTrue("List passed is not empty, no exception should have been thrown",
			SuperAssert.notEmpty(Arrays.asList(1, 2, 3), "EXCEPTION_MESSAGE"));
	}
	
	
	@Test(expected = Exception.class)
	public void notEmpty_withEmptyList() {
		SuperAssert.notEmpty(Collections.emptyList(), "EXCEPTION_MESSAGE");
	}
	
	
	@Test
	public void notEmpty_withCustomException() throws Exception {
		assertTrue("List passed is not empty, no exception should have been thrown",
			SuperAssert.notEmpty(Arrays.asList(1, 2, 3), new CustomException("CUSTOM_EXCEPTION_MESSAGE")));
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
		assertTrue("List passed is not empty or null, no exception should have been thrown",
			SuperAssert.notEmpty(Arrays.asList(1, 2, 3), "EXCEPTION_MESSAGE"));
	}
	
	
	@Test(expected = Exception.class)
	public void notEmptyOrNull_withEmptyList() {
		SuperAssert.notEmpty(Collections.emptyList(), "EXCEPTION_MESSAGE");
	}
	
	
	@Test(expected = Exception.class)
	public void notEmptyOrNull_withNullList() {
		SuperAssert.notEmptyOrNull(null, "EXCEPTION_MESSAGE");
	}
	
	
	@Test
	public void notEmptyOrNull_withCustomException() throws Exception {
		assertTrue("List passed is not empty or null, no exception should have been thrown",
			SuperAssert.notEmptyOrNull(Arrays.asList(1, 2, 3), new CustomException("CUSTOM_EXCEPTION_MESSAGE")));
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
	
	
	@Test(expected = Exception.class)
	public void isAscii_withNonAsciiString() {
		SuperAssert.isAscii("abc\ndef", "EXCEPTION_MESSAGE");
	}
	
	
	@Test(expected = Exception.class)
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
	
	
	@Test(expected = Exception.class)
	public void isAlphanumeric_withNonAlphanumericString() {
		SuperAssert.isAlphanumeric("hello, world!", "EXCEPTION_MESSAGE");
	}
	
	
	@Test(expected = Exception.class)
	public void isAlphanumeric_withNonAlphanumericCharacter() {
		SuperAssert.isAlphanumeric(' ', "EXCEPTION_MESSAGE");
	}
	
	
	///////////
	// OTHER //
	///////////
	
	
	static class CustomException extends Exception {
		public CustomException(String message) {
			super(message);
		}
	}
	
}