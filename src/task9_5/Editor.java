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
	
	public Editor(StaticAdapter staticAdapter) {
		this.staticAdapter = staticAdapter;
	}
	
	public void setAdapter(DynamicAdapter dynamicAdapter) {
		this.dynamicAdapter = dynamicAdapter;
	}
}
