package task7_3;

public class Kunde {

	public boolean istFirma;
	private String name;
	
	public Kunde() {
			
	}
	
	public Kunde(boolean istFirma, String name) {
		this.istFirma = istFirma;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
