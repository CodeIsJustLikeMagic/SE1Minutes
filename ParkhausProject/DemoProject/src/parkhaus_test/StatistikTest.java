package parkhaus_test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import parkhaus.Eintrag;
import parkhaus.Eintrag.Wochentag;
import parkhaus.Statistik;
import parkhaus_Interfaces.StatistikIF;

class StatistikTest {
	
	StatistikIF stat;

	@BeforeEach
	void setUp() throws Exception {
		stat = new Statistik();
		Eintrag e = new Eintrag(2, 20, Wochentag.DI, "120");
		((Statistik)stat).addEintrag(e);
	}

	@Test
	void durchschnittlicheParkdauer_2_returns2() {
		assertEquals(2.0,stat.durchschnittlicheParkdauer());
	}
	
	@Test
	void einnahmen_20_returns20() {
		assertEquals(20.0,stat.einnahmen(100, 200));
	}

}
