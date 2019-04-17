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
		sequenceFalse = new String[] {"B", "A", "C", "D"};
		
 		check = new SequenceCheck();
		check.setDependencies(dependencies);
		
	}
	
	
	@Test
	public void testIsWellSorted()
	{
		assertTrue(check.isWellSorted(sequenceTrue));
		assertFalse(check.isWellSorted(sequenceFalse));
	}

}
