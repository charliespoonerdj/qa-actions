package com.qaa.module3.unit_testing_exercises.excercise1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.qaa.module3.unit_testing_exercises.exercise1.Calculator;

public class CalculatorTest {
    private Calculator calculator;

	@BeforeEach
	void setUp() throws Exception {
		calculator = new Calculator();
	}

	@AfterEach
	void tearDown() throws Exception {
		calculator = null;
	}

	@Test
	void addSmallNumbersTest() {
		// Arrange
		double num1 = 10, num2 = 20;
		double expected = 30;
		
		// Act
		double actual = calculator.add(num1, num2);
		
		// Assert
		Assertions.assertEquals(expected, actual);
	}

    @Test
	void addLargeNumbersTest() {
		// Arrange
		double num1 = 100000000, num2 = 300000000;
		double expected = 400000000;
		
		// Act
		double actual = calculator.add(num1, num2);
		
		// Assert
		Assertions.assertEquals(expected, actual);
	}

    @Test
	void NegativeNumbersTest() {
		// Arrange
		double num1 = -1000, num2 = -3000;
		double expected = -4000;
		
		// Act
		double actual = calculator.add(num1, num2);
		
		// Assert
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	void subtractSmallNumbersTest() {
		// Arrange
		double num1 = 10, num2 = 20;
		double expected = -10;
		
		// Act
		double actual = calculator.subtract(num1, num2);
		
		// Assert
		Assertions.assertEquals(expected, actual);
	}

    @Test
	void subtractNegativeNumbersTest() {
		// Arrange
		double num1 = -100, num2 = -300;
		double expected = 200;
		
		// Act
		double actual = calculator.subtract(num1, num2);
		
		// Assert
		Assertions.assertEquals(expected, actual);
	}

    @Test
	void subtractLargeNumbersTest() {
		// Arrange
		double num1 = -100, num2 = 330000000;
		double expected = -330000100;
		
		// Act
		double actual = calculator.subtract(num1, num2);
		
		// Assert
		Assertions.assertEquals(expected, actual);
	}

	@Test
	void multiplySmallNumbersTest() {
		// Arrange
		double num1 = 10, num2 = 20;
		double expected = 200;
		
		// Act
		double actual = calculator.multiply(num1, num2);
		
		// Assert
		Assertions.assertEquals(expected, actual);
	}

    @Test
	void multiplyNegativeNumbersTest() {
		// Arrange
		double num1 = -10, num2 = -30;
		double expected = 300;
		
		// Act
		double actual = calculator.multiply(num1, num2);
		
		// Assert
		Assertions.assertEquals(expected, actual);
	}

    @Test
	void multiplyDecimalNumbersTest() {
		// Arrange
		double num1 = 10, num2 = 0.5;
		double expected = 5;
		
		// Act
		double actual = calculator.multiply(num1, num2);
		
		// Assert
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	void divideSmallNumbersTest() {
		// Arrange
		double num1 = 10, num2 = 20;
		double expected = 0.5;
		
		// Act
		double actual = calculator.divide(num1, num2);
		
		// Assert
		Assertions.assertEquals(expected, actual);
	}

    @Test
	void divideNegativeNumbersTest() {
		// Arrange
		double num1 = 100, num2 = -5;
		double expected = -20;
		
		// Act
		double actual = calculator.divide(num1, num2);
		
		// Assert
		Assertions.assertEquals(expected, actual);
	}

    @Test
	void divideDecimalNumbersTest() {
		// Arrange
		double num1 = 100, num2 = 0.25;
		double expected = 400;
		
		// Act
		double actual = calculator.divide(num1, num2);
		
		// Assert
		Assertions.assertEquals(expected, actual);
	}
}
