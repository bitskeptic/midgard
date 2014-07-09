package norse_myth;

public class Character {
	
	private String name;
	private Gender gender;
	private Race race;
	private Character father;
	private Character mother;
	private Character[] child_list = new Character[10];
	private int num_children = 0;
	private World home;
	
	public Character(String aName, Gender aGender, Race aRace, World aHome, Character aMother, Character aFather)
	{
		name = aName;
		gender = aGender;
		race = aRace;
		home = aHome;
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
	
	public void addChild(Character child)
	{
		if (num_children < 10)
			child_list[num_children++] = child;
			
	}
	
	public Character[] getChildren()
	{
		return child_list;
	}
	
	public Character getFather()
	{
		return father;
	}
	
	public Character getMother()
	{
		return mother;
	}
	
	public Character[] getSiblingsFather()
	{
		return getFather().getChildren();
	}
	
	public Character[] getSiblingsMother()
	{
		return getMother().getChildren();
	}
	
}
