package parkhaus_test;

import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import parkhaus.Parkausweis;
import parkhaus.Parkhaus;
import parkhaus.Ticket;
import parkhaus_Interfaces.ParkhausIF;

class ParkhausTest {
	
	ParkhausIF parkhaus;

	@BeforeEach
	void setUp() throws Exception {
		parkhaus = new Parkhaus("Hallo", 1, 2, 10, 20, 5, 12);
	}

	@Test
	void calcBelegtePlaetze_12Belegt_returns12() {
		parkhaus.calcBelegtePlaetze();
		assertSame(12, ((Parkhaus) parkhaus).getBelegtePlaetze());
	}
	
	@Test
	void createParkausweis_returnsNotNull() {
		assertNotNull(parkhaus.createParkausweis());
	}
	
	@Test
	void createTicket_returnsNotNull() {
		assertNotNull(parkhaus.createTicket());
	}

}
