package task9_5;

public class Altsystem implements AltsystemIF{
	
	private Punkt position;
	
	public Linie saveLinie(Farbe farbe, int milimeter) {
		Linie l = new Linie();
		l.milimeter = milimeter;
		l.farbe = farbe;
		return l;
	}

}
