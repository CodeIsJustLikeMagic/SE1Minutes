package parkhaus;

import parkhaus_Interfaces.ParkausweisIF;

public class Parkausweis extends Ticket implements ParkausweisIF{
	
	String expirationDate;
	double dailyCost;
	
	public Parkausweis(double dailyCost, String expirationDate) {
		super();
		this.expirationDate = expirationDate;
		setBezahlt(true);
		this.dailyCost = dailyCost;
	}
	
	public Parkausweis(double dailyCost) {
		super();
		this.expirationDate = Statistik.getCurrentTime();
		setBezahlt(true);
		this.dailyCost = dailyCost;
	}

	@Override
	public void extendExpirationDate(double amount) {
		expirationDate = Statistik.convertTime(expirationDate) + CalcSubscriptionTime(amount) + "";
		this.setBezahlt(true);
	}

	@Override
	public boolean checkForExpiration() {
		if(this.isBezahlt()) {
			if(Statistik.convertTime(Statistik.getCurrentTime()) > Statistik.convertTime(expirationDate)) {
				expire();
				return true;
			}
			return false;
		}
		return true;
		
		
	}

	@Override
	public void expire() {
		super.setBezahlt(false);
		
	}
	
	private int CalcSubscriptionTime(double amount) {
		return  (int) (amount / dailyCost);
	}

}
