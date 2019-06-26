package parkhaus;

import parkhaus_Interfaces.AusfahrtsschrankeIF;

public class Ausfahrtsschranke implements AusfahrtsschrankeIF{
	
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
