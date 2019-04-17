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
	public boolean isWellSorted(String[] sequence)
	{
		if(sequence != null) {
			
			String[][] depCopy = copyDependencies();
			
			for (int i = 0; i < sequence.length; i++)
			{
				for (int y=0; y < dependencies.length; y++)
				{
					if (depCopy[y][0].equals(sequence[i]) || depCopy[y][0].equals("")) {
						depCopy[y][0] = "";
					}
					else if(depCopy[y][1].equals(sequence[i]))
					{
						return false;
					}	
				}
			}			
		}
		return true;
		
	}
	
	private String[][] copyDependencies()
	{

		String[][] copy = new String[dependencies.length][];
		for(int i = 0; i < dependencies.length; i++)
		{
			copy[i] = new String[dependencies[i].length];
			System.arraycopy(dependencies[i], 0, copy[i], 0, dependencies[i].length);
		}
		
		return copy;
	} 

}
