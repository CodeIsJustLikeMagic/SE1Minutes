package task10_4;

public class Pickup implements VehicleIF{

	private static final Pickup instance = new Pickup();
	
	private Pickup() {
	}
	
	public static Pickup getInstance() {
		return instance;
	}

	@Override
	public double getPrice() {
		return 16;
	}

	@Override
	public double getArea() {
		return 12;
	}

}
