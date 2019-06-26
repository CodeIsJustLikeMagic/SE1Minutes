package task9_2;

import java.util.Iterator;

class PartialOrdering implements Iterable<String> {

	  private String[][] order;

	  public PartialOrdering(String[][] order){
	     this.order = order;
	  }

	  public Iterator<String> iterator(){
	    return new TopSortIterator( this.order );
	  }

	  public static PartialOrdering studentLife(){
	    return new PartialOrdering(new String[][]{
	        {"Aufstehen", "Frühstücken"},
	        {"Aufstehen", "KaffeeTrinken"},
	        {"Frühstücken", "Lernen"},
	        {"KaffeeTrinken", "Lernen"}
	    });
	  }
	  
	  public static PartialOrdering incorrectStudentLife(){
		    return new PartialOrdering(new String[][]{
		        {"Aufstehen", "Frühstücken"},
		        {"Aufstehen", "KaffeeTrinken"},
		        {"Lernen", "Aufstehen"},
		        {"KaffeeTrinken", "Lernen"}
		    });
		  }

	  public static void main(String[] args) {
	    for ( String step : studentLife() ) {
	      System.out.println( step );
	    }
	  }
	}