package parkhaus;

import java.util.Arrays;

import parkhaus_Interfaces.ParkhausIF;

public class Parkhaus implements ParkhausIF{
	
	private String name;
	private int nr;
	private int belegtePlaetze;
	private boolean schrankeoeffnet;
	private Statistik stats;
	private Parkdeck[] parkdecks;
	private Ausfahrtsschranke schranke;
	private Ticketautomat ticketautomat;
	private double parkgebuehr;
	private double subscriptionCost;
	
	public int durchschnittParkdauer() {
		return 0;
	}
	
	public String meistbesuchteZeit() {
		return "";
	}
	
	public String wenigstbesuchteZeit() {
		return "";
	}
	
	public double einnahmen(String anfang, String ende) {
		return 0d;
	}
	
	public Parkhaus(String name, int nr, Parkdeck[] parkdecks, double parkgebuehr, double subscriptionCost) {
		this.setName(name);
		this.setNr(nr);
		this.setParkdecks(parkdecks);
		belegtePlaetze = 0;
		this.increaseBelegtePlaetze(Arrays.asList(parkdecks).stream().filter(p -> p.getBelegtePlaetze() > 0).map(p -> p.getBelegtePlaetze()).reduce(0,  Integer::sum));
		this.setSchrankeoeffnet(false);
		setStats(new Statistik());
		setSchranke(new Ausfahrtsschranke(this));
		this.setParkgebuehr(parkgebuehr);
		this.subscriptionCost = subscriptionCost;
		setTicketautomat(new Ticketautomat(parkgebuehr));
	}

	public int getBelegtePlaetze() {
		return belegtePlaetze;
	}

	public void increaseBelegtePlaetze(int belegtePlaetze) {
		this.belegtePlaetze += belegtePlaetze;
	}
	
	public void decreaseBelegtePlaetze(int belegtePlaetze) {
		this.belegtePlaetze -= belegtePlaetze;
	}

	public boolean isSchrankeoeffnet() {
		return schrankeoeffnet;
	}

	public void setSchrankeoeffnet(boolean schrankeoeffnet) {
		this.schrankeoeffnet = schrankeoeffnet;
	}

	public Statistik getStats() {
		return stats;
	}

	public void setStats(Statistik stats) {
		this.stats = stats;
	}

	public Parkdeck[] getParkdecks() {
		return parkdecks;
	}

	public void setParkdecks(Parkdeck[] parkdecks) {
		this.parkdecks = parkdecks;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}
	
	public Parkausweis createParkausweis() {
		return new Parkausweis(subscriptionCost);
	}
	
	public Ticket createTicket() {
		return new Ticket();
	}

	public double getParkgebuehr() {
		return parkgebuehr;
	}

	public void setParkgebuehr(double parkgebuehr) {
		this.parkgebuehr = parkgebuehr;
	}

	public Ticketautomat getTicketautomat() {
		return ticketautomat;
	}

	public void setTicketautomat(Ticketautomat ticketautomat) {
		this.ticketautomat = ticketautomat;
	}

	public Ausfahrtsschranke getSchranke() {
		return schranke;
	}

	public void setSchranke(Ausfahrtsschranke schranke) {
		this.schranke = schranke;
	}

}
