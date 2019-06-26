package parkhaus;

public class Parkplatz {
	
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
