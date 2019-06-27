package parkhaus_test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import parkhaus.Ausfahrtsschranke;
import parkhaus.Parkhaus;
import parkhaus.Ticket;
import parkhaus_Interfaces.AusfahrtsschrankeIF;

class AusfahrtsschrankeTest {
	
	AusfahrtsschrankeIF schranke;
	Ticket t;

	@BeforeEach
	void setUp() throws Exception {
		schranke = new Ausfahrtsschranke(new Parkhaus());
		t = new Ticket();
		t.setBezahlt(true);
	}

	@Test
	void autoRauslassen_bezahltesTicket_returnsTrue() {
		assertTrue(schranke.autoRauslassen(t));
	}
	
	@Test
	void autoRauslassen_nichtBezahltesTicket_returnsFalse() {
		t.setBezahlt(false);
		assertFalse(schranke.autoRauslassen(t));
	}

}
