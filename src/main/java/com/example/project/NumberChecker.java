package com.example.project;

public class NumberChecker {
	
	public String oddOrEven(int number) {
		
		if (number % 2 == 1 || number % 2 == -1) {
			return String.format("%s is an odd number", number);
		} else {
			return String.format("%s is an even number", number);
		}
	}
}
