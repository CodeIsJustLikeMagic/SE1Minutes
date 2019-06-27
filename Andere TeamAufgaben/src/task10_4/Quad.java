package task10_4;

public class Quad implements VehicleIF{
	private static final Quad instance = new Quad();
	
	private Quad() {
	}
	
	public static Quad getInstance() {
		return instance;
	}

	@Override
	public double getPrice() {
		return 3;
	}

	@Override
	public double getArea() {
		return 1.5;
	}

}
