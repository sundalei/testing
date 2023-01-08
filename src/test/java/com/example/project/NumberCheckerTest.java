package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class NumberCheckerTest {

	private NumberChecker checker;

	@BeforeEach
	void setup() {
		this.checker = new NumberChecker();
	}

	@Test
	@DisplayName("45 is an odd number")
	public void testOddOrEven_45() {

		assertEquals("45 is an odd number", checker.oddOrEven(45));
	}
	
	@Test
	@DisplayName("42 is an even number")
	public void testOddOrEven_42() {
		
		assertEquals("42 is an even number", checker.oddOrEven(42));
	}
	
	@Test
	@DisplayName("0 is an even number")
	public void testOddOrEven_0() {
		
		assertEquals("0 is an even number", checker.oddOrEven(0));
	}
	
	@Test
	@DisplayName("-45 is an odd number")
	public void testOddOrEven_Negative_45() {
		
		assertEquals("-45 is an odd number", checker.oddOrEven(-45));
	}

	@ParameterizedTest
	@CsvSource({
		"45,45 is an odd number",
		"42,42 is an even number",
		"0,0 is an even number",
		"-45,-45 is an odd number"
	})
	public void testOddOrEven_parameterized(int number, String expectedMessage) {
		assertEquals(expectedMessage, checker.oddOrEven(number));
	}
}
