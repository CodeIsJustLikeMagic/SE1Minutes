package parkhaus_Interfaces;

public interface ParkausweisIF {
	
	public void extendExpirationDate(double amount);
	
	public boolean checkForExpiration();
	
	public void expire();

}
