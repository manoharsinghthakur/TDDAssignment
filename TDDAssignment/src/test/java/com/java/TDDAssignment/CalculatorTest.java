package com.java.TDDAssignment;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import java.util.logging.Logger;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Any;
@RunWith(MockitoJUnitRunner.class)
public class CalculatorTest {
	
	@InjectMocks
	Calculator calculator;
	
	
	@Mock
	Logger logger;

	@Test
	public void shouldReturnZeroWhenInputIsEmpty() {
		Calculator calculator = new Calculator();
		Assert.assertEquals(0, calculator.add(""));

	}

	@Test
	public void shouldReturnSameWhenInpuntIsOnlyOne() {
		Calculator calculator = new Calculator();
		Assert.assertEquals(123, calculator.add("123"));
	}

	@Test
	public void shouldReturnAdditionWhenInputIsTwo() {
		Calculator calculator = new Calculator();
		Assert.assertEquals(5, calculator.add("2,3"));
	}

	@Test
	public void shouldReturnAdditionWhenStringHasMultipleNumbersWithComma() {
		Calculator calculator = new Calculator();
		Assert.assertEquals(9, calculator.add("2,3,4"));
	}

	@Test
	public void shouldReturnAdditionWhenStringHasMultipleNumbersWithNewLineAndComma() {
		Calculator calculator = new Calculator();
		Assert.assertEquals(9, calculator.add("2\n3,4"));
	}

	@Test
	public void shouldReturnAdditionWhenStringHasMultipleNumbersWhereDelimeterVary() {
		Calculator calculator = new Calculator();
		Assert.assertEquals(5, calculator.add("//;\n2;3"));
	}
	
	@Test
	public void shouldIgnoreNumberIfItIsGreaterThan1000() {
		Calculator calculator = new Calculator();
		Assert.assertEquals(7, calculator.add("2,5,1001"));
	}
		
	@Test
	public void shouldPerformLogger() {
		
		Mockito.doNothing().when(logger).info(Mockito.any(String.class));
		calculator.add("//;\n1;2");
		Mockito.verify(logger).info(Mockito.any(String.class));
		
		
	}
}
