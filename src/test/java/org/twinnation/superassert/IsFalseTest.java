package org.twinnation.superassert;

import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class IsFalseTest {

	@Test
	public void isFalse() {
		assertTrue("Condition passed is false", SuperAssert.isFalse(false, "This should not throw an exception"));
	}


	@Test(expected = IllegalArgumentException.class)
	public void isFalse_withTrueCondition() {
		SuperAssert.isFalse(true, "EXCEPTION_MESSAGE");
	}

}