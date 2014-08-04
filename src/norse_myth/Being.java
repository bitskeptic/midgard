package norse_myth;

import java.util.*;

public class Being extends Thing implements First, Cloneable {
	
	private int id;
	private Gender gender;
	private Race race;
	private Being father;
	private Being mother;
	private ArrayList<Thing> child_list = new ArrayList<>();
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
		child_list.add(child);
	}
	public ArrayList<Thing> getChildren()
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
	
	public ArrayList<Thing> getSiblingsFather()
	{
		return removeFromList(getFather().getChildren(),this);
	}
	
	public ArrayList<Thing> getSiblingsMother()
	{
		return removeFromList(getMother().getChildren(),this);
	}
	
	public ArrayList<Thing> getSiblings()
	{
		return mergeLists(getSiblingsMother(),getSiblingsFather());
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
