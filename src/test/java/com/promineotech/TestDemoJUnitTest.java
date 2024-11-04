package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.params.provider.Arguments.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoJUnitTest {
	
	private TestDemo testDemo;

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")

	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if(!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy( () -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
	}
	
	static Stream<Arguments> argumentsForAddPositive() {
	  // @formatter:off
		return Stream.of(
			arguments(2, 2, 4, false),
			arguments(20, 20, 40, false),	
			arguments(2, 0, 2, true),
			arguments(2, -1, 1, true),
			arguments(0, 2, 2, true),
			arguments(-1, 2, 1, true),
			arguments(-2, -1, -3, true)		
		);
	  // @formatter:on
	}

	@Test
	private void assertThatPairsOfPositiveNumbersAreAddedCorrectly() { 
		assertThat(testDemo.addPositive(4,5)).isEqualTo(9);
		assertThat(testDemo.addPositive(40,50)).isEqualTo(90);
		assertThat(testDemo.addPositive(2,-1)).isEqualTo(1);
		assertThat(testDemo.addPositive(-2,-1)).isEqualTo(-3);
		assertThat(testDemo.addPositive(-20,-10)).isEqualTo(-30);
		assertThat(testDemo.addPositive(40,-50)).isEqualTo(-10);
		assertThat(testDemo.addPositive(-40,50)).isEqualTo(10);
	}

	@Test
	private void assertThatPairsOfNegativeNumbersAreAddedCorrectly() {
		assertThat(testDemo.addPositive(-2,-1)).isEqualTo(-3);
		assertThat(testDemo.addPositive(-20,-10)).isEqualTo(-30);
		assertThat(testDemo.addPositive(2,-1)).isEqualTo(1);
		assertThat(testDemo.addPositive(-2,1)).isEqualTo(-1);
		assertThat(testDemo.addPositive(20,-10)).isEqualTo(10);
		assertThat(testDemo.addPositive(-20,10)).isEqualTo(-10);
	}

	
	@Test
	private void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		
		doReturn(5).when(mockDemo).getRandomInt();
		
		int fiveSquared = mockDemo.randomNumberSquared();
		
		assertThat(fiveSquared).isEqualTo(25);
	}
}
