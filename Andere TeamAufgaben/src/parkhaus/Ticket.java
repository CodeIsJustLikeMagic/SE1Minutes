package parkhaus;

public class Ticket {
	
	private String einfahrtzeit;
	private boolean bezahlt;
	private double parkgebuehr;
	private String bezahlZeit;
	
	
	public Ticket() {
		this.einfahrtzeit = Statistik.getCurrentTime();
	}
	
	
	public String getEinfahrtzeit() {
		return einfahrtzeit;
	}
	public void setEinfahrtszeit(String einfahrtszeit) {
		this.einfahrtzeit = einfahrtszeit;
	}
	public boolean isBezahlt() {
		return bezahlt;
	}
	public void setBezahlt(boolean bezahlt) {
		this.bezahlt = bezahlt;
	}
	public double getParkgebuehr() {
		return parkgebuehr;
	}
	public void setParkgebuehr(double parkgebuehr) {
		this.parkgebuehr = parkgebuehr;
	}
	public String getBezahlZeit() {
		return bezahlZeit;
	}
	public void setBezahlZeit(String bezahlZeit) {
		this.bezahlZeit = bezahlZeit;
	}

}
