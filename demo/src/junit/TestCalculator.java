package junit;



import org.junit.Test;

import junit.framework.TestCase;

public class TestCalculator extends TestCase{
	
	public void testFail(){
		fail("this is a intended exception ");
	}
	@Test
	public void testAdd(){
		Calculator calculator = new Calculator();
		double add = calculator.add(10, 20);
		assertEquals(30, add , 0);
	}
	
	public static void main(String[] args) {
		TestCalculator t = new TestCalculator();
		t.testFail();
	}

}
