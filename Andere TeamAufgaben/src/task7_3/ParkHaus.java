package task7_3;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParkHaus {
	
	private int gebuehr;
	private List<Auto> autos;

	
	
	public ParkHaus() {
		
	}
	
	public ParkHaus(Auto[] autoArray, int parkgebuehr) {
		gebuehr = parkgebuehr;
		autos = Arrays.asList(autoArray);
	}
	
	public static void main(String[] args) {
		Auto[] autoArray = new Auto[10];
		autoArray[0] = new Auto(true, new Kunde(true, "ABC"), 100); //
		autoArray[1] = new Auto(false, new Kunde(false, "Hans Mueller"), 5000);
		autoArray[2] = new Auto(false, new Kunde(true, "Kaufhof"), 100);
		autoArray[3] = new Auto(true, new Kunde(true, "Rewe"), 425); //
		autoArray[4] = new Auto(true, new Kunde(true, "Edeka"), 4000);
		autoArray[5] = new Auto(true, new Kunde(true, "Basic"), 4600); //
		autoArray[6] = new Auto(false, new Kunde(false, "Marie Meier"), 746);
		autoArray[7] = new Auto(true, new Kunde(false, "Thomas Franz"), 1217);
		autoArray[8] = new Auto(false, new Kunde(true, "Hanser Verlag"), 9020);
		autoArray[9] = new Auto(true, new Kunde(false, "Martin Mueller"), 350);
		
		ParkHaus parkhaus = new ParkHaus(autoArray, 10);
		//List<Auto> autos = Arrays.asList(autoArray); //Nur für Lösung relevant
		int gesamtgebuehr = parkhaus.autos.stream().filter(auto -> auto.turbo && auto.kunde.istFirma).map(auto -> auto.parkdauer * parkhaus.gebuehr).reduce(0, Integer::sum);
		System.out.println(gesamtgebuehr);
		
		Optional<String> parking = (parkhaus.autos.stream().filter(auto -> auto.parkdauer() > 3600 && auto.kunde.istFirma).map(auto -> auto.kunde.getName()).reduce((n1, n2) -> n1 + "\n" + n2));
		List<Kunde> parking2 = parkhaus.autos.stream().filter(auto -> auto.parkdauer() > 3600 && auto.kunde.istFirma).map(auto -> auto.kunde).collect(Collectors.toList());
		parking.ifPresent(System.out::println);
		//parking.ifPresent(k -> System.out.println("la" + k));
		parking2.forEach(k -> System.out.println(k.getName()));
	}

}
