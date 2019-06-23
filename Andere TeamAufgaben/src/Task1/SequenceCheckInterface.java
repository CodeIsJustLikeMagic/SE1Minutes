package Task1;

public interface SequenceCheckInterface {
	
	void setDependencies(String[][] dependencies);
	
	String[][] getDependencies();
	
	boolean isWellSorted(String[] sequence);
}
