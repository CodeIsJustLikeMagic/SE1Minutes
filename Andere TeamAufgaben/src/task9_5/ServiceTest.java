package task9_5;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ServiceTest {
	
	Farbe f;
	ClassAdapter classAdapter;
	ObjectAdapter objectAdapter;
	DynamicAdapter d;
	Editor e, e2;
	//StaticAdapter staticAdapter;
	//DynamicAdapter dynamicAdapter;

	@Before
	public void setUp() throws Exception {
		Altsystem a = new Altsystem();
		classAdapter = new ClassAdapter();
		objectAdapter = new ObjectAdapter(a);
		d = new DynamicAdapter(a);
		f = new Farbe("blau");
		e = new Editor();
		e2 = new Editor(new StaticAdapter(a));
	}

	@Test
	public void convertLinieClassAdapter_LengthInZentimeter_ReturnsLengthInMilimeter() {
		assertSame(100, classAdapter.convertLinie(f,10).milimeter);
	}
	
	@Test
	public void convertLinieObjectAdapter_LengthInZentimeter_ReturnsLengthInMilimeter() {
		assertSame(100, objectAdapter.convertLinie(f, 10).milimeter);
	}
	
	@Test
	public void convertLinieStaticAdapter_LengthInZentimeter_ReturnsLengthInMilimeter() {
		assertSame(100, e2.saveLinieStaticAdapter(f, 10).milimeter);
	}
	
	@Test
	public void convertLinieDynamicAdapter_LengthInZentimeter_ReturnsLengthInMilimeter() {
		e.setAdapter(d);
		assertSame(100, e.saveLinieDynamicAdapter(f, 10).milimeter);
	}

}
