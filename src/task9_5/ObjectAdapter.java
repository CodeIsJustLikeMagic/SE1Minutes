package task9_5;

public class ObjectAdapter implements AdapterIF{
	
	AltsystemIF altsystem;
	
	public ObjectAdapter(AltsystemIF alt) {
		altsystem = alt;
	}

	@Override
	public Linie convertLinie(Farbe farbe, int zentimeter) {
		return altsystem.saveLinie(farbe, zentimeter * 10);
	}

}
