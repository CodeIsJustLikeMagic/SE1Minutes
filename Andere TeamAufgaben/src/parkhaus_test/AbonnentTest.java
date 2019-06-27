package parkhaus_test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import parkhaus.Abonnent;
import parkhaus.Parkausweis;
import parkhaus.User;
import parkhaus_Interfaces.AbonnentIF;

class AbonnentTest {
	
	AbonnentIF abonnent;

	@BeforeEach
	void setUp() throws Exception {
		abonnent = new Abonnent(1, new Parkausweis(100, "1000"));
	}

	@Test
	void paySubscription_expired_returns_false() {
		((Parkausweis) ((User) abonnent).getTicket()).expire();
		abonnent.paySubscription(1000);
		assertFalse(((Parkausweis) ((User) abonnent).getTicket()).checkForExpiration());
	}

}
