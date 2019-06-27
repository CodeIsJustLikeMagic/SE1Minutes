package parkhaus_test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import parkhaus.Parkausweis;
import parkhaus.Statistik;
import parkhaus_Interfaces.ParkausweisIF;

class ParkausweisTest {
	
	ParkausweisIF parkausweis;

	@BeforeEach
	void setUp() throws Exception {
		parkausweis = new Parkausweis(100, "1000");
		Statistik.time = "800";
		
	}

	@Test
	void checkForExpiration_NotExpired_ShouldReturnFalse() {
		assertFalse(parkausweis.checkForExpiration());
	}
	
	@Test
	void checkForExpiration_Expired_ShouldReturnTrue() {
		parkausweis.expire();
		assertTrue(parkausweis.checkForExpiration());
	}
	
	@Test
	void extendExpirationDate_Expired_ShouldReturnFalse() {
		parkausweis.expire();
		parkausweis.extendExpirationDate(1000);
		assertFalse(parkausweis.checkForExpiration());
	}

}
