package parkhaus;

import parkhaus_Interfaces.ParkausweisIF;

public class Parkausweis extends Ticket implements ParkausweisIF{
	
	String expirationDate;
	double dailyCost;
	
	public Parkausweis(double dailyCost) {
		super();
		setBezahlt(true);
		this.dailyCost = dailyCost;
	}

	@Override
	public void extendExpirationDate(double amount) {
		expirationDate = Statistik.convertTime(expirationDate) + CalcSubscriptionTime(amount) + "";
	}

	@Override
	public boolean checkForExpiration() {
		if(Statistik.convertTime(Statistik.getCurrentTime()) > Statistik.convertTime(expirationDate)) {
			expire();
			return true;
		}
		return false;
	}

	@Override
	public void expire() {
		super.setBezahlt(false);
		
	}
	
	private int CalcSubscriptionTime(double amount) {
		return  (int) (amount / dailyCost);
	}

}
