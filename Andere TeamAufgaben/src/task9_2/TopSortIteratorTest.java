package task9_2;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public class TopSortIteratorTest {
	
	public TopSortIterator t, t2;

	@Before
	public void setUp() throws Exception {
		PartialOrdering p = PartialOrdering.studentLife();
		t = (TopSortIterator) p.iterator();
		PartialOrdering p2 = PartialOrdering.incorrectStudentLife();
		t2 = (TopSortIterator) p2.iterator();

	}

	@Test
	public void testHasNext_NextItemExists_ReturnsTrue() {
		assertTrue(t.hasNext());
	}
	
	@Test
	public void testHasNext_NoNextItem_ReturnsFalse() {
		assertFalse(t2.hasNext());
	}
	
	@Test
	public void testNext_NextItemExists_ReturnsTrue() {
		assertNotNull(t.next());
	}
	
	@Test(expected= NoSuchElementException.class)
	public void next_NoNextItem_ReturnsTrue() {
		t2.next();
	}

}
