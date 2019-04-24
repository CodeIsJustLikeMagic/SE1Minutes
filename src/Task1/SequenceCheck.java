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
			//copy the depenencies so we can change then as we go.
			String[][] depCopy = copyDependencies();
			
			//for each Task i
			for (int i = 0; i < sequence.length; i++)
			{
				//go through all the dependencies
				for (int y=0; y < dependencies.length; y++)
				{
					//dependencies where the current Task i is a prerequisite for a different task get removed
					//from now on the dependent Task is allowed to get executed
					if (depCopy[y][0].equals(sequence[i]) || depCopy[y][0].equals("")) {
						depCopy[y][0] = "";//a dependency is considered to be removed when when the prerequisite is empty
					}
					//if the Task is second in a dependency there is another task that has to be completed first but hasn't been completed yet.
					//if the task had been completed the dependency would have already been remove and we wouldn't be in this if case.
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
