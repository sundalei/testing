package com.example.project;

public class Greeting {

	private NameGenerator generator;

	public Greeting() {
		this.generator = new NameGenerator();
	}
	
	public String sayHello() {

		String name = this.generator.generateName();
		
		return String.format("Hello %s. Welcome!", name);
	}

	public NameGenerator getGenerator() {
		return generator;
	}

	public void setGenerator(NameGenerator generator) {
		this.generator = generator;
	}

}
