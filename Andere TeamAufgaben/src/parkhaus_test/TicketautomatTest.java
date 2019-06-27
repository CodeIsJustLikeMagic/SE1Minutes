package parkhaus_test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import parkhaus.Ticket;
import parkhaus.Ticketautomat;
import parkhaus_Interfaces.TicketautomatIF;

class TicketautomatTest {
	
	TicketautomatIF tic;
	Ticket t;

	@BeforeEach
	void setUp() throws Exception {
		tic = new Ticketautomat(15);
		t = new Ticket();
		t.setEinfahrtszeit("100");
	}

	@Test
	void berechneParkGebuehr_1500_Returns1500() {
		assertEquals(1500, tic.berechneParkGebuehr(t));
	}

}
