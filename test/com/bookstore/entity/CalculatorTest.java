package com.bookstore.entity;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testAdd() {
		Calculator calculator=new Calculator();
		int a=40;
		int b=50;
		int res=calculator.add(a, b);
		assertEquals(res, 90);
}

}
