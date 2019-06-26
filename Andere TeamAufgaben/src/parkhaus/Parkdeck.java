package parkhaus;

public class Parkdeck {
	
	private int belegtePlaetze;
	private Parkplatz[] parkplaetze;
	
	public Parkdeck(int anzahlParkplaetze) {
		parkplaetze = new Parkplatz[anzahlParkplaetze];
		parkeAuto();
	}
	
	public Parkdeck(int anzahlParkplaetze, int belegtePlaetze) {
		parkplaetze = new Parkplatz[anzahlParkplaetze];
		for(int i = 0; i < belegtePlaetze; i++) {
			parkplaetze[i].setBelegt(true);
		}
	}

	public int getBelegtePlaetze() {
		return belegtePlaetze;
	}

	public void parkeAuto() {
		if(belegtePlaetze < parkplaetze.length) {			
			parkplaetze[belegtePlaetze].setBelegt(true);
			belegtePlaetze ++;
		}
	}
	
	
	

}
