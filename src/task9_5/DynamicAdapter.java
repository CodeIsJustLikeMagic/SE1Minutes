package task9_5;

public class DynamicAdapter implements StaticIF<Farbe, Integer, Linie>{
	
	public Altsystem system;
	
	public DynamicAdapter(Altsystem a) {
		system = a;
	}

	@Override
	public Linie apply(Farbe t, Integer g) {
		return system.saveLinie(t, g * 10);
	}

}
