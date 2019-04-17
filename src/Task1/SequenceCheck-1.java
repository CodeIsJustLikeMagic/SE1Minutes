
public class SequenceCheck implements SequenceCheckInterface{

    private String[][] dependencies;

    public SequenceCheck()
    {
        dependencies = new String[0][0];
    }

    public SequenceCheck(String[][] dependencies)
    {
        this.dependencies = dependencies;
    }

    @Override
    public void setDependencies(String[][] dependencies)
    {
        this.dependencies = dependencies;

    }

    @Override
    public String[][] getDependencies()
    {
        return this.dependencies;
    }

    @Override
    public boolean isWellSorted(String[] sequence) {

        String[][] depCopy = copyDependencies();
        if(sequence != null) {
        	
            for(String s : sequence)
            {
                for(int i = 0; i < depCopy.length; i++)
                {
                    //Delete Rule
                    if(depCopy[i][0].equals(s)|| depCopy[i][0].contentEquals(""))
                    {
                        depCopy[i][0] = "";
                    }
                    else if(depCopy[i][1].equals(s))
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