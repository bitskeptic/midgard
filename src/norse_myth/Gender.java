package norse_myth;

public enum Gender implements First {
	
	MALE("M",1), FEMALE("F",2);
	
	
	
	private String abb;
	private int first;
	
	private Gender(String aAbb, int aFirst)
	{
		abb = aAbb;
		first = aFirst;
	}
	
	public String getAbb()
	{
		return abb;
	}
	
	
	public int getFirst()
	{
		return first;
	}
	
	public int isFirst(Object otherObject)
	{
		Gender other = (Gender) otherObject;
		return (other.getFirst()-first);
	}

	
}
