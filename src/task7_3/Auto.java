package task7_3;

public class Auto {

	public boolean turbo;
	public Kunde kunde;
	public int parkdauer;
	
	public Auto() {
		
	}
	
	public Auto(boolean hasTurbo, Kunde kunde, int parkdauer) {
		turbo = hasTurbo;
		this.kunde = kunde;
		this.parkdauer = parkdauer;
	}
	
	public int parkdauer() {
		return parkdauer;
	}
}
