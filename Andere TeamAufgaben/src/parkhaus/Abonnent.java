package parkhaus;

import parkhaus_Interfaces.AbonnentIF;

public class Abonnent extends User implements AbonnentIF{

	public Abonnent(int number, Parkausweis parkausweis) {
		super(number, parkausweis);
	}

	@Override
	public void paySubscription(double amount) {
		// TODO Auto-generated method stub
		
	}

}
