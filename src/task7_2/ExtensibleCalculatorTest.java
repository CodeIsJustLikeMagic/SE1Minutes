package task7_2;

import static org.junit.Assert.*;

import java.util.function.BiFunction;

import org.junit.Before;
import org.junit.Test;

public class ExtensibleCalculatorTest {
	
	private ExtensibleCalculator calc;
	private BiFunction<Integer, Integer, Integer> add, sub, mul, div;

	@Before
	public void setUp() throws Exception {
		
		calc = new ExtensibleCalculator();
		add = (x, y) -> {return x + y;};
		sub = (x, y) -> {return x - y;};
		mul = (x, y) -> {return x * y;};
		div = (x, y) -> {return x / y;};
	}

	@Test
	public void addAndCheckForOperation_Subtraction_ReturnsTrue() {
		calc.addOperation("+", add);
		assertArrayEquals(calc.operations(), new String[] {"+"});
	}	
	
	@Test
	public void addAndCheckForOperation_Addition_ReturnsTrue() {
		calc.addOperation("-", sub);
		assertArrayEquals(calc.operations(), new String[] {"-"});
	}
	
	@Test
	public void addAndCheckForOperation_Multiplication_ReturnsTrue() {
		calc.addOperation("*", mul);
		assertArrayEquals(calc.operations(), new String[] {"*"});
	}
	
	@Test
	public void addAndCheckForOperation_Division_ReturnsTrue() {
		calc.addOperation("/", div);
		assertArrayEquals(calc.operations(), new String[] {"/"});
	}	
	
	@Test
	public void calc_Subtraction_ReturnsResult() {
		int x = 7, y = 5;
		calc.addOperation("-", sub);
		assertEquals(calc.calc("-", x, y), x - y);
	}
	
	@Test
	public void calc_Addition_ReturnsResult() {
		int x = 7, y = 5;
		calc.addOperation("+", add);
		assertEquals(calc.calc("+", x, y), x + y);
	}
	
	@Test
	public void calc_Mulitplication_ReturnsResult() {
		int x = 7, y = 5;
		calc.addOperation("*", mul);
		assertEquals(calc.calc("*", x, y), x * y);
	}
	
	@Test
	public void calc_Division_ReturnsResult() {
		int x = 7, y = 5;
		calc.addOperation("/", div);
		assertEquals(calc.calc("/", x, y), x / y);
	}

}
