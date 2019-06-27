package task10_4;

public class Trike implements VehicleIF{
	private static final Trike instance = new Trike();
	
	private Trike() {
	}
	
	public static Trike getInstance() {
		return instance;
	}
	
	@Override
	public double getPrice() {
		return 2;
	}

	@Override
	public double getArea() {
		return 1.25;
	}
	

}


