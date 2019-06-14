package task7_4;

import java.util.Arrays;
import java.util.List;

public class CashUni {
	
	List<Kurs> kurse;
	List<Student> studenten;

	public CashUni(Kurs[] pKurse, Student[] pStudent){
		kurse.addAll(Arrays.asList(pKurse));
		studenten.addAll(Arrays.asList(pStudent));
	}

	public int sumKurse(){
		return kurse.stream().filter(kurs -> kurs.gebuehr > 0).map(kurs -> kurs.gebuehr).reduce(0, Integer::sum);
	}

	public int sumStudenten() {
		return studenten.stream().filter(student -> student.istBerufstaetig()).map(student -> student.getKurse()).flatMap(k -> k.stream()).map(k -> k.gebuehr).reduce(0, Integer::sum);
	}

	public double avg() {
		return (kurse.stream().filter(kurs -> kurs.getECTS() > 5).mapToDouble(kurs -> kurs.gebuehr).average()).getAsDouble();
	}
	
	public static void main(String[] args) {
		Kurs k1 = new Kurs(true, 6, 100);
		Kurs k2 = new Kurs(true, 6, 100);
		Kurs k3 = new Kurs(true, 6, 100);
		Kurs k4 = new Kurs(false, 6, 100);
		Kurs k5 = new Kurs(false, 6, 100);
		Kurs k6 = new Kurs(true, 6, 100);
		Kurs k7 = new Kurs(true, 6, 100);
		Kurs k8 = new Kurs(true, 6, 100);
		
		Kurs[] k = {k1, k2, k3, k4};
		Kurs[] t =  {k5, k6 ,k7 , k8};
		Kurs[] a =  {k1, k2, k3, k4, k5, k6 ,k7 , k8};
		Student s = new Student(true, k);
		Student s2 = new Student(false, k);
		Student s3 = new Student(true, t);
		Student s4 = new Student(false, t);
		Student s5 = new Student(true, a);
		Student s6 = new Student(false, a);
		Student[] students =  {s, s2, s3, s4, s5, s6};
		CashUni c = new CashUni(a, students);
		
		System.out.println("KursSumme: " + c.sumKurse());
		System.out.println("StudentenSumme: " + c.sumStudenten());
		System.out.println("Avg: " + c.avg());
	}
}
