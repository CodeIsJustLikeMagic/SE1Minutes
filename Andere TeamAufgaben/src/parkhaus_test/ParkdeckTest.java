package parkhaus_test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import parkhaus.Parkdeck;
import parkhaus_Interfaces.ParkdeckIF;

class ParkdeckTest {
	
	ParkdeckIF park;

	@BeforeEach
	void setUp() throws Exception {
		park = new Parkdeck(2);
	}

	@Test
	void parkeAuto_nochPlatz_returnsTrue() {
		park.parkeAuto();
		assertSame(1, ((Parkdeck) park).getBelegtePlaetze());
	}
	
	@Test
	void parkeAuto_keinPlatz_returnsFalse() {
		park.parkeAuto();
		park.parkeAuto();
		park.parkeAuto();
		assertNotSame(3, ((Parkdeck) park).getBelegtePlaetze());
	}

}
