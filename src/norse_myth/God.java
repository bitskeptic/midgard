package norse_myth;

public class God extends Being {

	private String godOf;
	
	public God(String aName, Gender aGender, Race aRace, Being aMother,
			Being aFather, String aGodOf) {
		super(aName, aGender, aRace, aMother, aFather);
		godOf = aGodOf;
	}
	
	public String getGodOf()
	{
		return godOf;
	}
	
	

}
