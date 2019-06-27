package task10_4;

public class Tesla implements VehicleIF{
	private static final Tesla instance = new Tesla();
	
	private Tesla() {
	}
	
	public static Tesla getInstance() {
		return instance;
	}
	
	@Override
	public double getPrice() {
		return 0.5;
	}

	@Override
	public double getArea() {
		return 7;
	}
}