package norse_myth;

public class Being {
	
	private String name;
	private Gender gender;
	private Race race;
	private Being father;
	private Being mother;
	private Being[] child_list = new Being[10];
	private int num_children = 0;
	private World home;
	
	public Being(String aName, Gender aGender, Race aRace, Being aMother, Being aFather)
	{
		name = aName;
		gender = aGender;
		race = aRace;
		mother = aMother;
		father = aFather;
		if (aMother != null)
			aMother.addChild(this);
		if (aFather != null)
			aFather.addChild(this);
	}
	
	public String getName()
	{
		return name;
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
			System.out.println("ERROR: Could not add child to Being[" + name + "]. They already have too many children");
			
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
	
	public Being[] getSiblingsFather()
	{
		return getFather().getChildren();
	}
	
	public Being[] getSiblingsMother()
	{
		return getMother().getChildren();
	}
	
	public Being[] getSiblings()
	{
		return mergeBeingLists(getSiblingsMother(),getMother().getNumChildren(),getSiblingsFather(),getFather().getNumChildren());
	}
	
	public boolean equals(Being aBeing)
	{
		return (aBeing.getName() == getName());	
	}
	
	public Being[] mergeBeingLists(Being[] listOne, int listOneLength, Being[] listTwo, int listTwoLength)
	{
		boolean addBeing = true;
		Being[] list = new Being[20];
		int elements = 0;
		for (int i = 0; i < listOneLength; i++)
			list[elements++] = listOne[i];
		for (int i = 0; i < listTwoLength; i++)
		{
			addBeing = true;
			for (int j = 0; j < listOneLength; j++)
				if (listTwo[i].equals(listOne[j]))
					addBeing = false;
			if (addBeing)
				list[elements++] = listTwo[i];
		}
		return list;
	}
		
}
