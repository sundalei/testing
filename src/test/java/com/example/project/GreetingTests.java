package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GreetingTests {
	
	@Test
	public void testSayHello() {
		
		Greeting greeting = new Greeting();
		assertEquals("Hello leo. Welcome!", greeting.sayHello("leo"));
	}
}
