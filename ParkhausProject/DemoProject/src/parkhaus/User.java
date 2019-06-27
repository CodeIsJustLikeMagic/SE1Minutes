package parkhaus;

import parkhaus_Interfaces.UserIF;

public class User implements UserIF{
	
	private int number;
	private Ticket ticket;
	
	public User(int number, Ticket ticket) {
		this.number = number;
		this.setTicket(ticket);
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	
	
	

}
