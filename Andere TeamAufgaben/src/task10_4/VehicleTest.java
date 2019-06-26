package task10_4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VehicleTest {
	
	ParkhausMultiton p;

	@BeforeEach
	void setUp() throws Exception {
		p = ParkhausMultiton.getInstance();
	}

	
	@Test
	void getInstanceSUV_SUVInList_returnsInstance() {
		assertNotNull(p.getVehicle(SUV.class));
	}
	
	@Test
	void getInstanceTesla_TeslaNotInList_returnsNull() {
		assertNull(p.getVehicle(Tesla.class));
	}

}
