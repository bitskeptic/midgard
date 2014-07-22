package norse_myth;

public class Event extends Thing {
	
	private World location;
	
	public Event(String aName, World aLocation)
	{
		super(aName);
		location = aLocation;
	}
	
	public Event(String aName)
	{
		super(aName);
	}
	
	public World getLocation()
	{
		return location;
	}

}
