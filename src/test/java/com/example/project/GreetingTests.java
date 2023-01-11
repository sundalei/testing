package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class GreetingTests {
	
	@Test
	public void testMockSayHello() {
		NameGenerator generator = Mockito.mock(NameGenerator.class);
		Mockito.when(generator.generateName()).thenReturn("leo");

		Greeting greeting = new Greeting();
		greeting.setGenerator(generator);
		assertEquals("Hello leo. Welcome!", greeting.sayHello());
	}

	@Test
	public void testSayHello() {

		Greeting greeting = new Greeting();
		boolean matched = greeting.sayHello().matches("Hello [a-zA-Z]+. Welcome!");
		assertTrue(matched);
	}
}
