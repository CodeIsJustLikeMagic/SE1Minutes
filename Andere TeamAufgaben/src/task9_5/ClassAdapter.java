package task9_5;

public class ClassAdapter extends Altsystem implements AdapterIF {

	@Override
	public Linie convertLinie(Farbe farbe, int zentimeter) {
		return saveLinie(farbe, zentimeter * 10);
	}

}
