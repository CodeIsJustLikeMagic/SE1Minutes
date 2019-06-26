package task10_4;

public class SUV implements VehicleIF{
	
	private static final SUV instance = new SUV();
	
	private SUV() {
	}
	
	public static SUV getInstance() {
		return instance;
	}

	@Override
	public double getPrice() {
		return 15;
	}

	@Override
	public double getArea() {
		return 10;
	}

}
