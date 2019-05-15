package task6_3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PersonTest {
	
	private Person testPerson;
	private Person pCorrect;
	private Person pIncorrect;
	private Person empty;

	@Before
	public void setUp() throws Exception {
		
		empty = new Person("");
		String correctString = "Frau Dr. Prof. Eva Müller, Hochschule Bonn-Rhein-Sieg, Fachbereich Informatik, Grantham-Allee 20, 53757 Sankt Augustin";
		pCorrect = new Person("Frau", "Dr. Prof.", "Eva", "Müller", " Hochschule Bonn-Rhein-Sieg", " Fachbereich Informatik", " Grantham-Allee", "20", "53757", "Sankt Augustin");
		pIncorrect = new Person("Frau", "Dr.", "Eva", "Müller", " Hochschule Bonn-Rhein-Sieg", "  Fachbereich Informatik", "Grantham-Allee", "20", "53757", "Sankt Augustin");
		testPerson = new Person(correctString);
	}
	
	//Checks getPropertiesAsStringMethod
	@Test
	public void getPropertiesAsString_CorrectInput_ReturnsEquals() {
		assertEquals(testPerson.getPropertiesAsString(), "Frau Dr. Prof. Eva Müller Hochschule Bonn-Rhein-Sieg Fachbereich Informatik Grantham-Allee 20 53757 Sankt Augustin");		
	}
	
	@Test
	public void getPropertiesAsString_CorrectInput_ReturnsNotEquals() {
		assertNotEquals(testPerson.getPropertiesAsString(), "Frau Dr. Eva Müller Hochschule Bonn-Rhein-Sieg Fachbereich Informatik Grantham-Allee 20 53757 Sankt Augustin");		
	}
	
	@Test
	public void checkEquality_CorrectInput_ReturnsTrue() {
		assertTrue(checkIfPersonsEqual(testPerson, pCorrect));
	}
	
	@Test
	public void checkEquality_IncorrectInput_ReturnsFalse() {
		assertFalse(checkIfPersonsEqual(testPerson, pIncorrect));
	}
	
	@Test
	public void transformString2Object_EmptyString_ReturnsNull() {
		assertNull(empty.transformString2Object(""));
	}
	
	@Test
	public void transformString2Object_ShortString_ReturnsNull() {
		assertNull(empty.transformString2Object("a, b, c"));
	}

	
	private boolean checkIfPersonsEqual(Person p1, Person p2) {
		if(p1.getPropertiesAsString().equals(p2.getPropertiesAsString())) {
			return true;
		}
		return false;
	}
	
	

}
