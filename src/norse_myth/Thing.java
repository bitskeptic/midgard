package norse_myth;

public abstract class Thing {
	
	private String name;
	
	public Thing(String aName)
	{
		name = aName;
	}
	
	public String getName()
	{
		return name;
	}
	
	
	public boolean equals(Thing aThing)
	{
		return (aThing.getName() == getName());	
	}
	
	public static Thing[] mergeLists(Thing[] listOne, Thing[] listTwo)
	{
		boolean addThing = true;
		Thing[] list = new Thing[listOne.length];
		int elements = 0;
		for (int i = 0; i < listOne.length; i++)
			if (listOne[i] != null)
				list[elements++] = listOne[i];
		for (int i = 0; i < listTwo.length; i++)
		{
			if (listTwo[i] != null)
			{
				addThing = true;
				for (int j = 0; j < listOne.length; j++)
					if (list[j] != null && listTwo[i].equals(list[j]))
						addThing = false;
				if (addThing)
					listOne[elements++] = listTwo[i];
			}
		}
		return listOne;
	}
	
	public static Thing[] removeFromList(Thing[] aThingList, Thing aThing)
	{
		
		int elements;
		for (int i = 0; i < aThingList.length; i++)
			if (aThingList[i] != null && aThingList[i].equals(aThing))
			{
				elements = Thing.getElementsInList(aThingList);
				if (i == elements-1)
					aThingList[i] = null;
				else
				{
					aThingList[i] = aThingList[elements-1];
					aThingList[elements-1] = null;
				}
			}
		return aThingList;
	}
	
	public static Thing lookup(String aName, Thing[] aList)
	{
		for (int i = 0; i < aList.length; i++)
			if (aList[i] != null && aList[i].getName().equalsIgnoreCase(aName))
				return aList[i];
		return null;
	}
	
	public static int getElementsInList(Thing[] aList)
	{
		int i;
		for (i = 0; aList[i] != null; i++);
		return i;
	}
	
	public void setName(String aName)
	{
		name = aName;
	}


}
