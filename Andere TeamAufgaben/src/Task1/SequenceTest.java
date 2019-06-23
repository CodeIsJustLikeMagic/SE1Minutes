package Task1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SequenceTest {

	SequenceCheck check;
	String[] sequenceTrue, sequenceFalse;

	
	
	@Before
	public  void setUp() throws Exception
	{
		String[][] dependencies = new String[][] {{"A", "B"}, {"B", "C"}, {"D", "B"}};
		sequenceTrue = new String[] {"A", "D", "B", "C"};
		sequenceFalse = new String[] {"C", "A", "B", "D"};
		
 		check = new SequenceCheck();
		check.setDependencies(dependencies);
		
	}
	
	
	@Test
	public void isWellSorted_CorrectInput_ReturnsTrue()
	{
		assertTrue(check.isWellSorted(sequenceTrue));
	}
	
	
	@Test
	public void isWellSorted_IncorrectInput_ReturnsFalse()
	{
		assertFalse(check.isWellSorted(sequenceFalse));
	}
	
	
	
	@Test
	public void isWellSorted_EmptyArray_ReturnTrue()
	{
		String[] s = new String[0];
		assertTrue(check.isWellSorted(s));
	}
	
	@Test
	public void isWellSorted_NullInput_ReturnTrue()
	{
		assertTrue(check.isWellSorted(null));
	}
	
	@Test
	public void isWellSorted_SameInputTwice_ReturnTrue()
	{
		String[] sequence = new String[] {"A", "A", "D", "B", "D", "C" };
		assertTrue(check.isWellSorted(sequence));
	}

}
