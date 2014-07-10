package norse_myth;

public class FamilyTree {

	public static void main(String[] args) 
	{	
		Being[] family_list = new Being[100];
		Race[] race_list = new Race[10];
		World[] world_list = new World[15];
		
		world_list[0] = new World("Asgard");
		world_list[1] = new World("Jotunheim");
		world_list[2] = new World("Vanaheimr");
		race_list[0] = new Race("AEsir", world_list[0]);
		race_list[1] = new Race("Jotun", world_list[1]);
		race_list[2] = new Race("Vanir", world_list[2]);
		
		family_list[0] = new Being("Odin", Gender.MALE, race_list[0], null, null);
		family_list[1] = new Being("Frigga", Gender.FEMALE, race_list[0], null, null);
		family_list[10] = new Being("Baldr", Gender.MALE, race_list[0], null, null);
	}
}
