package norse_myth;

public class World extends Thing implements First {

	private int level;
	
	public World(String aName, int aLevel)
	{
		super(aName);
		level = aLevel;
	}
	
	public int getLevel()
	{
		return level;
	}
	
	public int isFirst(Object otherObject)
	{
		World other = (World) otherObject;
		return (other.getLevel()-level);
	}

}
