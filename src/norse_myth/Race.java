package norse_myth;

public class Race extends Thing implements First {
	
	private World home;
	
	public Race(String aName, World aHome)
	{
		super(aName);
		home = aHome;
	}
	
	public World getWorld()
	{
		return home;
	}
	
	public int isFirst(Object otherObject)
	{
		Race other = (Race) otherObject;
		return (other.getWorld().getLevel()-home.getLevel());
	}

}
