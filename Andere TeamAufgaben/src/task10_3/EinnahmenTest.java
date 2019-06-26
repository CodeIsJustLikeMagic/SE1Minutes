package task10_3;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

class EinnahmenTest {
	Statistics stats;
	Einnahmen e;
	Date start, end;

	@BeforeEach
	void setUp() throws Exception {
		 SimpleDateFormat dateformat2 = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		 
	        String strdate2 = "02-04-2019 11:35:42";
	        try {
	            start = dateformat2.parse(strdate2);
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	        strdate2 = "02-04-2019 13:45:11";
	        try {
	            end = dateformat2.parse(strdate2);
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
		ParkedCar[] p = new ParkedCar[] {new ParkedCar("Red", start, end, 10d)};
		stats = new Statistics(p);
		e = new Einnahmenberechner(stats);
	}

	@Test
	void getRevenue_1Car1Day_returns10() {
		assertEquals(10d, e.getRevenue(start, end));
	}

}
