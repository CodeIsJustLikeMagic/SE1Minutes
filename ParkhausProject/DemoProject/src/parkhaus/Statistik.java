package parkhaus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.OptionalDouble;

import parkhaus_Interfaces.StatistikIF;

public class Statistik implements StatistikIF{
	
	ArrayList<Eintrag> stats;
	
	public static String time = "200";
	
	public Statistik() {
		stats = new ArrayList<Eintrag>();
	}
	
	public double durchschnittlicheParkdauer() {
		return stats.stream().mapToDouble(e -> e.getParkdauer()).average().getAsDouble();
	}
	
	public String meistbesuchteZeit() {
		return "";
	}
	
	public String wenigstbesuchteZeit() {
		return "";
	}
	
	public double einnahmen(int anfang, int ende) {
		return stats.stream().filter(e -> (convertTime(e.getEinfahrtszeit()) >= anfang) &&
				((convertTime(e.getEinfahrtszeit()) + e.getParkdauer()) <= ende)).mapToDouble(e -> e.getParkgebuehr()).reduce(0, Double::sum);
	}
	
	public static String getCurrentTime() {
		return time;
	}
	public static int convertTime(String time) {
		return Integer.parseInt(time);
	}
	
	public void addEintrag(Eintrag e) {
		stats.add(e);
	}
	
	public boolean removeEintrag(Eintrag e) {
		return stats.remove(e);
	}

	


}
