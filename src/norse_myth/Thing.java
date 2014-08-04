package norse_myth;

import java.util.*;

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
		return (aThing.getName().equalsIgnoreCase(getName()));	
	}
	
	public static ArrayList<Thing> mergeLists(ArrayList<Thing> listOne, ArrayList<Thing> listTwo)
	{
		boolean addThing = true;
		for (Thing xThing : listOne)
		{
			for (Thing yThing : listTwo)
				if (xThing.equals(yThing))
					addThing = false;
			if (addThing)
				listTwo.add(xThing);
		}
		
		return listTwo;
	}
	
	public static ArrayList<Thing> removeFromList(ArrayList<Thing> aThingList, Thing aThing)
	{
		
		aThingList.remove(aThing);
		
		return aThingList;
	}
	
	public static int getElementsInList(ArrayList<Thing> aList)
	{
		return aList.size();
	}
	
	public void setName(String aName)
	{
		name = aName;
	}
	
	public static Thing lookup(String aName, ArrayList<Thing> aList)
	{
		for (Thing currentThing : aList)
		{
			if (currentThing.getName().equalsIgnoreCase(aName))
				return currentThing;
		}
		return null;
	}


}
