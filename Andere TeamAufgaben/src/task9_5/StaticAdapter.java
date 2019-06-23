package task9_5;

public class StaticAdapter{
	
	public StaticIF<Farbe, Linie> staticFunction;
	
	public StaticAdapter(StaticIF<Farbe, Linie> function) {
		 staticFunction = function;
	}


}
