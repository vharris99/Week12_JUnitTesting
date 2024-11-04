package com.promineotech;

import java.util.Random;

public class TestDemo {
	
	// Method to check if two integers are positive numbers
	// If so, returns the sum of the two integers
	public int addPositive(int a, int b) {
		int sum = a + b;
		if(a > 0 && b > 0) {
		
		} else {
		    throw new IllegalArgumentException("Both parameters must be positive! (+)");
		}
		return sum;
	}
	
	// Method to check if two integers are negative numbers
	// If so, returns the sum of the two integers
	public int addNegative(int a, int b) {
		int sum = a + b;
		if(a < 0 && b < 0) {
			
		} else {
			throw new IllegalArgumentException("Both parameters must be negative! (-)");
		}
		return sum;
	}
	
	public int randomNumberSquared() {
		int square = getRandomInt() * getRandomInt();
		return square;
	}

	int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}
	
}
