package Task1;

public class SequenceCheck implements SequenceCheckInterface{
	
	String[][] dependencies;

	@Override
	public void setDependencies(String[][] dependencies) {
		this.dependencies = dependencies;
	}

	@Override
	public String[][] getDependencies() {
		return this.dependencies;
	}

	@Override
	public boolean isWellSorted(String[] sequence) {
		if(sequence != null) {
			//String[][] depCopy = copyDependencies();
			for (int i = 0; i < sequence.length; i++) {
				for (int y=0; y < dependencies.length; y++) {
					if (dependencies[y][0].equals(sequence[i]) /* || dependencies[y][0].equals("") */) {
						//depCopy[i][0] = "";
						//}
						//else if(depCopy[i][1].equals(s))
						//{
							//return false;
						//}
						//der teil würde dann wegfallen
						if (behind(dependencies[y][0],dependencies[y][1],sequence) == true) break;
						else return false;
					}
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
	
	/*
	private String[][] copyDependencies()
	{

		String[][] copy = new String[dependencies.length][];
		for(int i = 0; i < dependencies.length; i++)
		{
			copy[i] = new String[dependencies[i].length];
			System.arraycopy(dependencies[i], 0, copy[i], 0, dependencies[i].length);
		}
		
		return copy;
	} */

}
