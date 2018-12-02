import java.io.*;
import java.util.*;
import java.lang.*;


class Santa
{
	private boolean debug;

	public static void main(String args[])
	{
		//initialise command line read and clear, set debug mode.
		debug = args.length > 0 && args[0].equals("debug");
		Scanner scanner = new Scanner(System.in);
		CLS cls = new CLS(); 
		

		List<Person> people = new ArrayList<Person>();

		if(debug)
		{
			AddSamplePeople(people);		
		} else {
			InputPeople(people, scanner);
		}
		
		if(people.size() < 3){
			System.out.println("You need at least three people for this to work. This program will now exit.");
			scanner.nextLine();
			return;
		}

		//clear screen
		if(!debug){
			try 
			{
				cls.clear();
			}
			catch(Exception e)
			{
				System.out.println("Something went wrong!");
			}
		}

		//tell users who their target is
		OutputUsers(people, scanner);
			
		try{

			System.in.read();
		}
		catch (Exception e){
			System.out.println("Something went wrong!");
		}
	}

	//tell users who their target is
	private static void OutputUsers(List<Person> people, Scanner scanner){
	//Scramble the people
		ScrambleList.ScramblePeopleContinuous(people, debug);
		Thread t;
		
		for (Person user: people){
			try 
			{
				//Print a person
				System.out.println("Hi " + user.name + "...");
				
				//Wait for confirmation from the user;
				if (!debug)
				{
					System.out.println("Press enter to get your recipient...");				
					scanner.nextLine();
				}
				
				//Give them their target
				System.out.println("Your recipient is: " + user.target.name);
				
				//Wait for response then clear screen
				if (!debug)
				{
					System.out.println("Press enter to clear the screen...");
					scanner.nextLine();
					cls.clear();
				}
			} 
			catch(Exception e)
			{
				 System.out.println("Something went wrong!");
			}
		}

		System.out.println("That is all the people");
	}

	//allow users to be entered
	private static void InputPeople(List<Person> people, Scanner scanner){
		
		System.out.println("Enter your name and press enter. Once everyone is in, press enter without adding anyone.");
		
		while (true){
			String name = scanner.nextLine();
			
			// if input was not empty, add the person, otherwise we have finished adding people
			if(name.length() > 0){
				people.add(new Person(name));
			}else{
				break;
			}
		}
	}

	//test users
	private static void AddSamplePeople(List<Person> people){
		people.add(new Person("Anna"));
		people.add(new Person("Bob"));
		people.add(new Person("Carl"));
		people.add(new Person("David"));
		people.add(new Person("Elaine"));
		people.add(new Person("Fred"));	 
	} 
}