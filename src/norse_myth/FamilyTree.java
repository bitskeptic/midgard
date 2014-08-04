package norse_myth;

import java.util.*;
import java.io.*;
import java.nio.file.Paths;

public class FamilyTree {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException, IOException
	{	

		ArrayList<Thing> thing_list = new ArrayList<>();
		String[] line;

		Scanner file_in = new Scanner(Paths.get("things.txt"));
		while (file_in.hasNext())
		{
			line = file_in.nextLine().split(",");
			if (line[0].equalsIgnoreCase("World"))
				thing_list.add(new World(line[1],Integer.parseInt(line[2])));
			if (line[0].equalsIgnoreCase("Race"))
				thing_list.add(new Race(line[1],(World) World.lookup(line[2], thing_list)));
			if (line[0].equalsIgnoreCase("Being"))
				thing_list.add(new Being(line[1], Gender.valueOf(line[2]), (Race) Race.lookup(line[3], thing_list), (Being) Being.lookup(line[4], thing_list), (Being) Being.lookup(line[5], thing_list)));
		}
		Scanner in = new Scanner(System.in);

		String new_being;
		String name;

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
				gender = Gender.valueOf(in.nextLine());
				System.out.println("Race: ");
				race = (Race) Race.lookup(in.nextLine(), thing_list);
				System.out.println("Mother: ");
				mother = (Being) Being.lookup(in.nextLine(), thing_list);
				System.out.println("Father: ");
				father = (Being) Being.lookup(in.nextLine(), thing_list);
				thing_list.add(new Being(name,gender,race,mother,father));
			}
		} while (new_being.equalsIgnoreCase("yes"));


		System.out.println("This is a list of all the gods and goddesses of the norse religion");

		if (!thing_list.isEmpty())
		{
			for (Thing t : thing_list)
			{
				if (t != null && t.getClass() == Being.class)
				{
					Being b = (Being) t;
					System.out.print("Name: " + b.getName() + " Generation: " + b.getGeneration());
					if (b.getFather() != null && b.getMother() != null)
						System.out.println(" Father: " + b.getFather().getName() + " Mother: " + b.getMother().getName());
					else
						System.out.println();
				}
			}

			PrintWriter out = new PrintWriter("testfile.txt");

			Being odin_being = (Being) Being.lookup("Odin", thing_list);
			for (Thing c : odin_being.getSiblings())
			{
				System.out.println("Siblings of Odin: " + c.getName());
			}

			out.close();
		}

	}
}
