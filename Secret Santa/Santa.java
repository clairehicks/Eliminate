import java.io.*;
import java.util.*;
import java.lang.*;


class Santa
{
	private static boolean debug;
	private static boolean continousPeople;

	public static void main(String args[])
	{
		//initialise read and screen clear; set debug mode.
		debug = args.length > 0 && args[0].equals("debug");
		Scanner scanner = new Scanner(System.in);
		CLS cls = new CLS(); 
		
		//configure the program options
		Configure(scanner);
	
		List<Person> people = new ArrayList<Person>();

		if(debug)
		{
			AddSamplePeople(people);		
		} else {
			InputPeople(people, scanner);
		}
		
		//need more than two people, or the output is self-evident
		if(people.size() < 3){
			System.out.println("You need at least three people for this to work. This program will now exit.");
			scanner.nextLine();
			return;
		}

		//clear screen as we have finished adding names
		if(!debug){
			try 
			{
				cls.clear();
			}
			catch(Exception e)
			{
				System.out.println("Something went wrong while clearing the screen.");
			}
		}

		//scramble the people based on chosen scramble method
		if(continousPeople)
		{
			ScrambleList.ScramblePeopleContinuous(people, debug);
		} else {
			ScrambleList.ScramblePeopleMicroLoops(people, debug);
		}

		//tell users who their target are
		OutputUsers(people, scanner);
			
		try{
			//final read to stop the window from auto-closing
			System.in.read();
		}
		catch (Exception e){
			System.out.println("Something went wrong retrieving the recipient!");
		}
	}

	private static void Configure(Scanner scanner){
		System.out.println("Do you want your players to be in a continuous loop? (y/n)");
		continousPeople = scanner.nextLine().charAt(0) != 'n';
	}

	//tell each user who their target is
	private static void OutputUsers(List<Person> people, Scanner scanner){
		CLS cls = new CLS();
		
		Thread t;
		
		for (Person user: people){
			try 
			{
				//greet the next player and wait for confirmation to ensure the correct user is shown the target.
				System.out.println("Hi " + user.name + ",");
				
				if (!debug)
				{
					System.out.println("Press enter to get your recipient.");				
					scanner.nextLine();
				}
				
				//give them their target, then wait for them to respond before clearing the screen.
				System.out.println("Your recipient is: " + user.target.name);
				
				if (!debug)
				{
					System.out.println("Press enter to clear the screen...");
					scanner.nextLine();
					cls.clear();
				}
			} 
			catch(Exception e)
			{
				 System.out.println("Something went wrong while giving the player's their targets.");
			}
		}

		System.out.println("That is all the people");
	}

	//allow users to be entered
	private static void InputPeople(List<Person> people, Scanner scanner){
		
		System.out.println("Enter your name and press enter. Once everyone is in, press enter without adding anyone.");
		
		while (true){
			String name = scanner.nextLine();
			
			//if input was not empty, add the person, otherwise we have finished adding people
			if(name.length() > 0){
				people.add(new Person(name));
			}else{
				break;
			}
		}
	}

	//hard-coded users for debug mode
	private static void AddSamplePeople(List<Person> people){
		people.add(new Person("Anna"));
		people.add(new Person("Bob"));
		people.add(new Person("Carl"));
		people.add(new Person("David"));
		people.add(new Person("Elaine"));
		people.add(new Person("Fred"));	 
	} 
}