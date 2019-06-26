package parkhaus_Interfaces;

import parkhaus.Parkausweis;
import parkhaus.Ticket;

public interface ParkhausIF {
	
	public Ticket createTicket();
	public Parkausweis createParkausweis();
}
