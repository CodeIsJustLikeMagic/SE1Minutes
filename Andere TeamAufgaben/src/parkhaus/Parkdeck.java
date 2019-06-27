package parkhaus;

import parkhaus_Interfaces.ParkdeckIF;

public class Parkdeck implements ParkdeckIF{
	
	private int belegtePlaetze;
	private Parkplatz[] parkplaetze;
	private Parkhaus p;
	
	public Parkdeck(int anzahlParkplaetze) {
		parkplaetze = new Parkplatz[anzahlParkplaetze];
	}
	
	public Parkdeck(int anzahlParkplaetze, int belegtePlaetze, Parkhaus p) {
		this.p = p;
		parkplaetze = new Parkplatz[anzahlParkplaetze];
		for(int i = 0; i < belegtePlaetze; i++) {
			if(parkplaetze[i] == null) {
				parkplaetze[i] = new Parkplatz();
			}
			parkplaetze[i].setBelegt(true);
		}
	}

	public int getBelegtePlaetze() {
		return belegtePlaetze;
	}

	public void parkeAuto() {
		if(belegtePlaetze < parkplaetze.length) {	
			if(parkplaetze[belegtePlaetze] == null) {
				parkplaetze[belegtePlaetze] = new Parkplatz();
			}
			parkplaetze[belegtePlaetze].setBelegt(true);
			belegtePlaetze ++;
			p.calcBelegtePlaetze();
		}
		else {
			System.out.println("Parkhaus voll");
		}
	}
	
	public void parkeAutoAus() {
		if(belegtePlaetze > 0) {
			belegtePlaetze --;
		}
		p.calcBelegtePlaetze();
	}
	
	
	

}
