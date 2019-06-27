package task9_5;

public class Editor {
	
	private ClassAdapter service;
	private Punkt position;
	private StaticAdapter staticAdapter;
	private DynamicAdapter dynamicAdapter;
	
	public Linie saveLinie(Farbe farbe, int zentimeter) {
		return service.convertLinie(farbe, zentimeter);
	}
	
	public Editor() {
		
	}
	
	public Linie saveLinieStaticAdapter(Farbe farbe, int zentimeter) {
		return staticAdapter.apply(farbe, zentimeter);
	}
	
	public Linie saveLinieDynamicAdapter(Farbe farbe, int zentimeter) {
		return dynamicAdapter.apply(farbe, zentimeter);
	}
	
	public Editor(StaticAdapter staticAdapter) {
		this.staticAdapter = staticAdapter;
	}
	
	public Editor(Object object) {
		// TODO Auto-generated constructor stub
	}


	public void setAdapter(DynamicAdapter dynamicAdapter) {
		this.dynamicAdapter = dynamicAdapter;
	}
}
