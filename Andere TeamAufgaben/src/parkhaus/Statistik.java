package parkhaus;

import java.util.ArrayList;

public class Statistik {
	
	ArrayList<Eintrag> stats;
	
	public static String time;
	
	public Statistik() {
		stats = new ArrayList<Eintrag>();
	}
	
	public int durchschnittlicheParkdauer() {
		return 0;
	}
	
	public String meistbesuchteZeit() {
		return "";
	}
	
	public String wenigstbesuchteZeit() {
		return "";
	}
	
	public double einnahmen(String anfang, String ende) {
		return 0;
	}
	
	public static String getCurrentTime() {
		return time;
	}
	
	public static int convertTime(String time) {
		return Integer.parseInt(time);
	}

}
