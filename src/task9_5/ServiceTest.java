package task9_5;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ServiceTest {
	
	Farbe f;
	ClassAdapter classAdapter;
	ObjectAdapter objectAdapter;
	//StaticAdapter staticAdapter;
	//DynamicAdapter dynamicAdapter;

	@Before
	public void setUp() throws Exception {
		Altsystem a = new Altsystem();
		classAdapter = new ClassAdapter();
		objectAdapter = new ObjectAdapter(a);
		f = new Farbe("blau");
		Editor e = new Editor();
//		Editor e2 = new Editor(new StaticAdapter((f, l) -> a.saveLinie(f,l)));
	}

	@Test
	public void convertLinieClassAdapter_LengthInZentimeter_ReturnsLengthInMilimeter() {
		assertSame(100, classAdapter.convertLinie(f,10).milimeter);
	}
	
	@Test
	public void convertLinieObjectAdapter_LengthInZentimeter_ReturnsLengthInMilimeter() {
		assertSame(100, objectAdapter.convertLinie(f, 10).milimeter);
	}

}
