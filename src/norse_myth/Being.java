package norse_myth;


public class Being extends Thing implements First, Cloneable {
	
	private int id;
	private Gender gender;
	private Race race;
	private Being father;
	private Being mother;
	private Being[] child_list = new Being[10];
	private int num_children = 0;
	private World home;
	private int generation;
	
	private static int nextId = 0;
	
	public Being(String aName, Gender aGender, Race aRace, Being aMother, Being aFather)
	{
		super(aName);
		id = nextId++;
		gender = aGender;
		race = aRace;
		mother = aMother;
		father = aFather;
		generation = 0;
		if (aMother != null)
		{
			aMother.addChild(this);
			generation = aMother.getGeneration()+1;
		}
		if (aFather != null)
		{
			aFather.addChild(this);
			if (aFather.getGeneration() > aMother.getGeneration())
				generation = aFather.getGeneration()+1;
		}
		if (generation == 0)
			generation = 1;
	}
	
	public int getId()
	{
		return id;
	}
	
	public static int getNextId()
	{
		return nextId;
	}
	
	public Gender getGender()
	{
		return gender;
	}
	
	public Race getRace()
	{
		return race;
	}

	public World getHome()
	{
		return home;
	}
	
	public void addChild(Being child)
	{
		if (num_children < 10)
			child_list[num_children++] = child;
		else
			System.out.println("ERROR: Could not add child to Being[" + getName() + "]. They already have too many children");
			
	}
	
	public Being[] getChildren()
	{
		return child_list;
	}
	
	public Being getFather()
	{
		return father;
	}
	
	public Being getMother()
	{
		return mother;
	}
	
	public int getNumChildren()
	{
		return num_children;
	}
	
	public int getGeneration()
	{
		return generation;
	}
	
	public Being[] getSiblingsFather()
	{
		return (Being[]) removeFromList(getFather().getChildren(),this);
	}
	
	public Being[] getSiblingsMother()
	{
		return (Being[]) removeFromList(getMother().getChildren(),this);
	}
	
	public Being[] getSiblings()
	{
		return (Being[]) mergeLists(getSiblingsMother(),getSiblingsFather());
	}
	
	public int isFirst(Object otherObject)
	{
		Being other = (Being) otherObject;
		return (other.getGeneration()-generation);
	}
	
	public Being clone() throws CloneNotSupportedException
	{
		return (Being) super.clone();
	}
	
	public void setName(String aName)
	{
		super.setName(aName);
	}
	
}
