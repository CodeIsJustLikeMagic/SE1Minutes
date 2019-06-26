package parkhaus;

import parkhaus_Interfaces.TicketautomatIF;

public class Ticketautomat implements TicketautomatIF{
	
	double parkgebuehr;

	public Ticketautomat(double parkgebuehr) {
		this.parkgebuehr = parkgebuehr;
	}
	
	public double berechneParkGebuehr(Ticket ticket) {
		if(ticket.isBezahlt()) {
			return 0;
		}
		int time = (Statistik.convertTime(Statistik.getCurrentTime()) - Statistik.convertTime(ticket.getEinfahrtzeit())) /3600;
		return time * parkgebuehr;
	}
	
}
