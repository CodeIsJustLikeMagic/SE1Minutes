package task9_5;

public class StaticAdapter implements StaticIF<Farbe, Integer, Linie>{
	
	public Altsystem system;
	
	public StaticAdapter(Altsystem a) {
		 system = a;
	}

	@Override
	public Linie apply(Farbe t, Integer g) {
		return system.saveLinie(t, g * 10);
	}


}
