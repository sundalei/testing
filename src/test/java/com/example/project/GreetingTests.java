package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;

import com.example.project.extension.LoggingExtension;

@ExtendWith(LoggingExtension.class)
public class GreetingTests {

	private Logger logger;

	public void setLogger(Logger logger) {
		System.out.println("GreetingTests setLogger is called.");
		this.logger = logger;
	}
	
	@Test
	public void testMockSayHello() {
		NameGenerator generator = Mockito.mock(NameGenerator.class);
		Mockito.when(generator.generateName()).thenReturn("leo");

		Greeting greeting = new Greeting();
		greeting.setGenerator(generator);
		assertEquals("Hello leo. Welcome!", greeting.sayHello());
		logger.info("testMockSayHello is called");
	}

	@Test
	public void testSayHello() {

		Greeting greeting = new Greeting();
		boolean matched = greeting.sayHello().matches("Hello [a-zA-Z]+. Welcome!");
		assertTrue(matched);
	}
}
