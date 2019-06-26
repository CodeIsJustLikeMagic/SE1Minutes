package parkhaus;

import parkhaus_Interfaces.ManagerIF;

public class Manager implements ManagerIF{

	Parkhaus parkhaus;
	
	
	public Manager(Parkhaus parkhaus) {
		this.parkhaus = parkhaus;
	}
}
