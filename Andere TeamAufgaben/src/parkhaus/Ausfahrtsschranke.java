package parkhaus;

public class Ausfahrtsschranke {
	
	private Parkhaus parkhaus;
	
	public void autoRauslassen(Ticket ticket) {
		if(ticket.isBezahlt()) {
			parkhaus.setSchrankeoeffnet(true);
		}
	}
	
	public Ausfahrtsschranke(Parkhaus parkhaus) {
		this.parkhaus = parkhaus;
	}

}
