package task10_4;

public class PKW implements VehicleIF{
	
	private static final PKW instance = new PKW();
	
	private PKW() {
	}
	
	public static PKW getInstance() {
		return instance;
	}

	@Override
	public double getPrice() {
		return 10;
	}

	@Override
	public double getArea() {
		return 8;
	}

}
