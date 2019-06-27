package parkhaus;

import parkhaus_Interfaces.AusfahrtsschrankeIF;

public class Ausfahrtsschranke implements AusfahrtsschrankeIF{
	
	private Parkhaus parkhaus;
	
	public boolean autoRauslassen(Ticket ticket) {
		if(ticket.isBezahlt()) {
			parkhaus.setSchrankeoeffnet(true);
			return true;
		}
		return false;
	}
	
	public Ausfahrtsschranke(Parkhaus parkhaus) {
		this.parkhaus = parkhaus;
	}

}
