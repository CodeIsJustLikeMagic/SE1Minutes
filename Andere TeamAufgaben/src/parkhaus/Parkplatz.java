package parkhaus;

import parkhaus_Interfaces.ParkplatzIF;

public class Parkplatz implements ParkplatzIF{
	
	private boolean belegt;
	
	public Parkplatz() {
		setBelegt(false);
	}

	public boolean isBelegt() {
		return belegt;
	}

	public void setBelegt(boolean belegt) {
		this.belegt = belegt;
	}

}
