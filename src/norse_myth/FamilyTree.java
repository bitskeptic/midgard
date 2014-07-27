package norse_myth;

import java.util.*;

public class FamilyTree {

	@SuppressWarnings("resource")
	public static void main(String[] args) 
	{	
		Being[] being_list = new Being[100];
		Race[] race_list = new Race[10];
		World[] world_list = new World[15];
		
		world_list[0] = new World("Asgard",1);
		world_list[1] = new World("Jotunheim",3);
		world_list[2] = new World("Vanaheimr",3);
		race_list[0] = new Race("AEsir", world_list[0]);
		race_list[1] = new Race("Jotun", world_list[1]);
		race_list[2] = new Race("Vanir", world_list[2]);
		
		being_list[0] = new Being("Ymir", Gender.MALE, race_list[1], null, null);
		being_list[1] = new Being("Thrudgelmir", Gender.MALE, race_list[1], being_list[0], null);
		being_list[2] = new Being("Bergelmir", Gender.MALE, race_list[1], being_list[1], null);
		being_list[3] = new Being("Bolthorn", Gender.MALE, race_list[1], being_list[2], null);
		being_list[4] = new Being("Bestla", Gender.FEMALE, race_list[1], being_list[3], null);
		being_list[5] = new Being("Buri", Gender.MALE, race_list[1], null, null);
		being_list[6] = new Being("Borr", Gender.MALE, race_list[1], being_list[5], null);
		being_list[7] = new Being("Odin", Gender.MALE, race_list[0], being_list[6], being_list[4]);
		//being_list[8] = new Being("Vili", Gender.MALE, race_list[0], being_list[6], being_list[4]);
		//being_list[9] = new Being("Ve", Gender.MALE, race_list[0], being_list[6], being_list[4]);
		//being_list[10] = new Being("Hoenir", Gender.MALE, race_list[0], being_list[6], being_list[4]);
		try
		{
			being_list[8] = being_list[7].clone();
			being_list[8].setName("Vili");
			being_list[9] = being_list[7].clone();
			being_list[9].setName("Ve");
			being_list[10] = being_list[7].clone();
			being_list[10].setName("Hoenir");
		}
		catch (CloneNotSupportedException e)
		{
			e.printStackTrace();
		}
		
		being_list[11] = new Being("Frigga", Gender.FEMALE, race_list[0], null, null);
		being_list[12] = new Being("Baldr", Gender.MALE, race_list[0], null, null);
		
		Scanner in = new Scanner(System.in);
		
		String new_being;
		String name;
		String gender_string;
		String race_string;
		String mother_string;
		String father_string;
		
		Gender gender;
		Race race;
		Being mother;
		Being father;
		
		do
		{
		
			System.out.println("Input new being? ");
			new_being = in.nextLine();
			if (new_being.equalsIgnoreCase("yes"))
			{
				System.out.println("Name: ");
				name = in.nextLine();
				System.out.println("Gender: ");
				gender_string = in.nextLine();
				if (gender_string == "male")
					gender = Gender.MALE;
				else
					gender = Gender.FEMALE;
				System.out.println("Race: ");
				race_string = in.nextLine();
				race = (Race) Race.lookup(race_string, race_list);
				System.out.println("Mother: ");
				mother_string = in.nextLine();
				mother = (Being) Being.lookup(mother_string, being_list);
				System.out.println("Father: ");
				father_string = in.nextLine();
				father = (Being) Being.lookup(father_string, being_list);
				being_list[Being.getNextId()] = new Being(name,gender,race,mother,father);
			}
		} while (new_being.equalsIgnoreCase("yes"));
		
		
		System.out.println(new_being + "This is a list of all the gods and goddesses of the norse religion");
		
		for (Being b : being_list)
		{
			if (b != null)
			{
				System.out.print("Name: " + b.getName() + " Generation: " + b.getGeneration());
				if (b.getFather() != null && b.getMother() != null)
					System.out.println(" Father: " + b.getFather().getName() + " Mother: " + b.getMother().getName());
				else
					System.out.println();
			}
		}
		for (Being c : being_list[7].getSiblings())
		{
			if (c != null)
				System.out.println("Siblings of Odin: " + c.getName());
		}
	}
}
