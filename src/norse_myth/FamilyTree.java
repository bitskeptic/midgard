package norse_myth;

public class FamilyTree {

	public static void main(String[] args) 
	{	
		Being[] being_list = new Being[10];
		Race[] race_list = new Race[10];
		World[] world_list = new World[15];
		
		world_list[0] = new World("Asgard");
		world_list[1] = new World("Jotunheim");
		world_list[2] = new World("Vanaheimr");
		race_list[0] = new Race("AEsir", world_list[0]);
		race_list[1] = new Race("Jotun", world_list[1]);
		race_list[2] = new Race("Vanir", world_list[2]);
		
		being_list[0] = new Being("Ymir", Gender.MALE, race_list[1], null, null);
		being_list[1] = new Being("Thrudgelmir", Gender.MALE, race_list[1], being_list[0], null);
		being_list[2] = new Being("Bergelmir", Gender.MALE, race_list[1], being_list[1], null);
		being_list[3] = new Being("Bolthorn", Gender.MALE, race_list[1], null, null);
		being_list[4] = new Being("Bestla", Gender.FEMALE, race_list[1], being_list[3], null);
		being_list[5] = new Being("Buri", Gender.MALE, race_list[1], null, null);
		being_list[6] = new Being("Borr", Gender.MALE, race_list[1], being_list[5], null);
		being_list[7] = new Being("Odin", Gender.MALE, race_list[0], being_list[6], being_list[4]);
		being_list[8] = new Being("Frigga", Gender.FEMALE, race_list[0], null, null);
		being_list[9] = new Being("Baldr", Gender.MALE, race_list[0], null, null);
		
		System.out.println("Title: This is a list of all the gods and goddesses of the norse religion");
		
		for (Being b : being_list)
		{
			System.out.print("Name: " + b.getName());
			if (b.getFather() != null && b.getMother() != null)
				System.out.println(" Father: " + b.getFather().getName() + " Mother: " + b.getMother().getName());
			else
				System.out.println();
		}
	}
}
