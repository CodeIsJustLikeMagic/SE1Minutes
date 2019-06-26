package task7_4;

import java.util.Arrays;
import java.util.List;

public class Student {
	
	private boolean istBerufstaetig;
	private List<Kurs> kurse;
	
	public Student(boolean pIstBerufstaetig, Kurs[] pKurse) {
		istBerufstaetig = pIstBerufstaetig;
		kurse.addAll(Arrays.asList(pKurse));
	}
	
	public boolean istBerufstaetig() {
		return istBerufstaetig;
	}

	public List<Kurs> getKurse() {
		return kurse;
	}

	public void AddKurs(Kurs kurs) {
		kurse.add(kurs);
	}
	
	

}
