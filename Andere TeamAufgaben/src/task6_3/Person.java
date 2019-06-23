package task6_3;

import java.util.regex.Pattern;

public class Person implements PersonInterface{
	
	public String anrede;
	public String titel;
	public String vorname;
	public String name;
	public String organisation;
	public String abteilung;
	public String strasse;
	public String hausnummer;
	public String postleitszahl;
	public String stadt;
	
	public Person(String input)
	{
		if(transformString2Object(input) == null) {
			anrede = "";
			titel = "";
			vorname = "";
			name = "";
			organisation = "";
			abteilung = "";
			strasse = "";
			hausnummer = "";
			postleitszahl = "";
			stadt = "";
		}
	}
	
	public Person(String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9, String s10) {
		anrede = s1;
		titel = s2;
		vorname = s3;
		name = s4;
		organisation = s5;
		abteilung = s6;
		strasse = s7;
		hausnummer = s8;
		postleitszahl = s9;
		stadt = s10;
	}


	@Override
	public Person transformString2Object(String text) {
		//Each string in parts represents one of Person's properties
		String[] parts = new String[10];
		//I'm working with += later, to make sure that no string is equals null, fill each with an empty string
		for(int i = 0; i < parts.length; i++) {
			parts[i] = "";
		}
		//checks if string is empy
		if(text.equals("")) {
			return null;
		}
		else {
			//to further split the string
			String[] splitParts;
			//base parts (Anrede, title, vorname, name), (Organisation), (Abteilung), (Strasse, hausnummer) (PLZ, Stadt)
			String[] baseParts = text.split(",");
			if(baseParts.length != 5){
				return null;
			}
			// Anrede, Titel, Vorname, Nachname"
			String anTiVoNa = baseParts[0];
			splitParts = anTiVoNa.split(" ");
			if(splitParts.length < 3) {
				return null;
			}
			parts[0] = splitParts[0];
			String spaceT = "";
			String spaceV = "";
			for(int i = 1; i < splitParts.length - 1; i++) {
				//Titel has to contain a . for separation from vorname, fügt zwischen den titeln einen space ein
				//(wird wiederholt genutzt um spaces wiederherzustellen
				if(splitParts[i].contains(".")) {
					parts[1] += spaceT + splitParts[i];
					spaceT = " ";
				}
				//vorname
				else
				{

					parts[2] = spaceV + splitParts[i];
					spaceV = " ";
				}
			}
			//Name
			parts[3] = splitParts[splitParts.length-1];
			
			//Organisation
			parts[4] = baseParts[1];
			//Abteilung
			parts[5] = baseParts[2];
			
			//strasse
			splitParts = baseParts[3].split(" ");
			String strasse = splitParts[0];
			//strasse ist alles bis auf letztes element
			for(int i = 1; i < splitParts.length - 1; i++) {
				strasse += " " + splitParts[i];
			}
			
			//Strasse
			parts[6] = strasse;
			//hausnr
			parts[7] = splitParts[splitParts.length - 1];
			
			//ort und postleitszahl
			splitParts = baseParts[4].split(" ");		
			boolean plzSet = false;
			String spaceO = "";
			for(int i = 0; i < splitParts.length; i++) {
				if(splitParts[i].equals("")) {
					continue;
				}
				else if(plzSet) {
					parts[9] += spaceO + splitParts[i];
					spaceO = " ";
				}
				else {
					plzSet = true;
					parts[8] = splitParts[i];
				}
				
			}
		}
			anrede = parts[0];
			titel = parts[1];
			vorname = parts[2];
			name = parts[3];
			organisation = parts[4];
			abteilung = parts[5];
			strasse = parts[6];
			hausnummer = parts[7];
			postleitszahl = parts[8];
			stadt = parts[9];

			return this;
			
			
		
	}
	
	public String getPropertiesAsString() {
		String res = anrede + " " + titel + " " + vorname + " " + name + organisation + abteilung + strasse + " " + hausnummer + " " + postleitszahl + " " + stadt;
		return res;
	}

}
