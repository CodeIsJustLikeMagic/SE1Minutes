package task10_4;

public class Zweirad implements VehicleIF{
	private static final Zweirad instance = new Zweirad();
	
	private Zweirad() {
	}
	
	public static Zweirad getInstance() {
		return instance;
	}

	@Override
	public double getPrice() {
		return 1;
	}

	@Override
	public double getArea() {
		return 1;
	}

}
