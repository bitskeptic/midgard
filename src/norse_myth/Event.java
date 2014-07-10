package norse_myth;

public class Event {
	
	private String name;
	private World location;
	
	public Event(String aName, World aLocation)
	{
		name = aName;
		location = aLocation;
	}
	
	public Event(String aName)
	{
		name = aName;
	}
	
	public String getName()
	{
		return name;
	}
	
	public World getLocation()
	{
		return location;
	}

}
