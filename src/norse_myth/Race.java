package norse_myth;

public class Race {
	
	private String name;
	private World home;
	
	public Race(String aName, World aHome)
	{
		name = aName;
		home = aHome;
	}
	
	public String getName()
	{
		return name;
	}
	
	public World getWorld()
	{
		return home;
	}

}
