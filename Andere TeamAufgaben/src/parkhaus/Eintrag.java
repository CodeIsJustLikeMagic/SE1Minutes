package parkhaus;

public class Eintrag {
	
	enum Wochentag{
		MO,
		DI,
		MI,
		DO,
		FR,
		SA,
		SO;
	}
	
	private int parkdauer;
	private double parkgebuehr;
	private Wochentag wochentag;
	private String einfahrtszeit;
	
	public Eintrag(int parkdauer, double parkgebuehr, Wochentag wochentag, String einfahrtszeit) {
		this.setParkdauer(parkdauer);
		this.setParkgebuehr(parkgebuehr);
		this.setWochentag(wochentag);
		this.setEinfahrtszeit(einfahrtszeit);
	}

	public String getEinfahrtszeit() {
		return einfahrtszeit;
	}

	public void setEinfahrtszeit(String einfahrtszeit) {
		this.einfahrtszeit = einfahrtszeit;
	}

	public Wochentag getWochentag() {
		return wochentag;
	}

	public void setWochentag(Wochentag wochentag) {
		this.wochentag = wochentag;
	}

	public double getParkgebuehr() {
		return parkgebuehr;
	}

	public void setParkgebuehr(double parkgebuehr) {
		this.parkgebuehr = parkgebuehr;
	}

	public int getParkdauer() {
		return parkdauer;
	}

	public void setParkdauer(int parkdauer) {
		this.parkdauer = parkdauer;
	}

}
