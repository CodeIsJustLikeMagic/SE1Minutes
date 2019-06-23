package task7_4;

public class Kurs {
	
	private boolean hatZertifikat;
	private int ECTS;
	
	public int gebuehr;
	
	public Kurs(boolean pHatZertifikat, int pECTS, int pGebuehr) {
		hatZertifikat = pHatZertifikat;
		ECTS = pECTS;
		gebuehr = pGebuehr;
	}
	
	public boolean getHatZertifikat() {
		return hatZertifikat;
	}
	
	public int getECTS() {
		return ECTS;
	}
	
	public int getGebuehr() {
		return gebuehr;
	}

}
