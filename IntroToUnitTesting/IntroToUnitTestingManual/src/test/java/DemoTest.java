package test.java;

import main.java.Demo;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.*;

/**
 * The class containing your tests for the {@link Demo} class.  Make sure you
 * test all methods in this class (including both 
 * {@link Demo#main(String[])} and 
 * {@link Demo#isTriangle(double, double, double)}).
 */
public class DemoTest {
	
	@Test
	public void test01_345() {
		assertTrue(Demo.isTriangle(3, 4, 5));
	}
	
	@Test
	public void test02_354() {
		assertTrue(Demo.isTriangle(3, 5, 4));
	}
	
	@Test
	public void test03_534() {
		assertTrue(Demo.isTriangle(5, 3, 4));
	}
	
	@Test
	public void test04_781() {
		assertFalse(Demo.isTriangle(8, 9, 1));
	}
	
	@Test
	public void test05_718() {
		assertFalse(Demo.isTriangle(7, 1, 8));
	}
	
	@Test
	public void test06_178() {
		assertFalse(Demo.isTriangle(1, 7, 8));
	}
	
	@Test
	public void test07_a45() {
		assertFalse(Demo.isTriangle('a', 4, 5));
	}
	
	@Test
	public void test08_3b5() {
		assertFalse(Demo.isTriangle(3, 'b', 5));
	}
	
	@Test
	public void test09_34c() {
		assertFalse(Demo.isTriangle(3, 4, 'c'));
	}
	
	@Test
	public void test10_neg() {
		assertFalse(Demo.isTriangle(-3, 5, 4));
	}
	
	@Test
	public void test11_neg() {
		assertFalse(Demo.isTriangle(3, -5, 4));
	}
	
	@Test
	public void test12_neg() {
		assertFalse(Demo.isTriangle(3, 5, -4));
	}
	
	@Test
	public void test13_zero() {
		assertFalse(Demo.isTriangle(0, 5, 4));
	}
	
	@Test
	public void test14_zero() {
		assertFalse(Demo.isTriangle(3, 0, 4));
	}
	
	@Test
	public void test15_zero() {
		assertFalse(Demo.isTriangle(3, 5, 0));
	}
	
	@Test
	public void test16_345() {
		assertTrue(Demo.isTriangle(3.589, 4.589, 5.589));
	}
	
	@Test
	public void test17_345() {
		assertTrue(Demo.isTriangle(3.589, 4.589, 5.589));
	}
	
	@Test
	public void test18_345() {
		assertTrue(Demo.isTriangle(3.589, 4.589, 5.589));
	}
	
	@Test
	public void test_mainInputPositive() {
		ByteArrayInputStream in = new ByteArrayInputStream("3\n4\n5\n".getBytes());
		System.setIn(in);
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		String[] args = {};
		Demo.main(args);

		String consoleOutput = "Enter side 1: " + System.getProperty("line.separator");
		consoleOutput += "Enter side 2: " + System.getProperty("line.separator");
		consoleOutput += "Enter side 3: " + System.getProperty("line.separator");
		consoleOutput += "This is a triangle." + System.getProperty("line.separator");
		
		assertEquals(consoleOutput, out.toString());
	}
	
	@Test
	public void test_mainInputNegative() {
		ByteArrayInputStream in = new ByteArrayInputStream("8\n9\n1\n".getBytes());
		System.setIn(in);
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		String[] args = {};
		Demo.main(args);

		String consoleOutput = "Enter side 1: " + System.getProperty("line.separator");
		consoleOutput += "Enter side 2: " + System.getProperty("line.separator");
		consoleOutput += "Enter side 3: " + System.getProperty("line.separator");
		consoleOutput += "This is not a triangle." + System.getProperty("line.separator");
		
		assertEquals(consoleOutput, out.toString());
	}

}
