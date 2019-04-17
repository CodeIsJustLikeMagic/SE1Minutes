package Task1;

public class SequenceCheck implements SequenceCheckInterface{
	
	String[][] depends;
	
	@Override
	public void setDependencies(String[][] dependencies) {
		this.depends = dependencies;
	}

	@Override
	public String[][] getDependencies() {
		// TODO Auto-generated method stub
		return this.depends;
	}

	@Override
	public boolean isWellSorted(String[] sequence) {
		for (int i = 0; i < sequence.length; i++) {
			for (int y=0; y < depends.length; i++) {
				if (depends[y][0].equals(sequence[i])) {
					if (behind(depends[y][0],depends[y][1],sequence) == true) break;
					else return false;
				}
			}
		}
		return true;
	}
	
	private boolean behind(String a, String b, String[] arr) {
		int posa=-1;
		int posb=-1;
		for (int i=0; i < arr.length; i++) {
			if (arr[i].equals(a)) posa=i;
			if (arr[i].equals(b)) posb=i;
		}
		if (posa<posb) return true;
		else return false;
	}

}
