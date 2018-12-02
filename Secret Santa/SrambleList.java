import java.io.*;
import java.util.*;
import java.util.Random;
import java.util.Date;

class ScrambleList
{
	//takes a list of people and allocates them a target
	public static void ScramblePeopleContinuous (List<Person> people, boolean isTest){
		try {
			//Get number of people and create an array for the available people
			int peopleCount = people.size();
			List<Person> availablePeople = new ArrayList<Person>();
			availablePeople.addAll(people);

			//loop from the list and give the people their list position
			Random rand = new Random(!isTest ? (long) (new Date().getTime()): 1);
			
			//we begin by allocating to the first person on the list, so remove them from the available list
			Person current = people.get(0);
			availablePeople.remove(current);

			for (int i = peopleCount - 2; i >= 0 ; i--){
				
				//pick a target for the current person
				int chosenPerson = i> 0 ? rand.nextInt(i + 1) : 0 ;
				
				//put them in the ith slot and remove them from the available people
				Person target = availablePeople.get(chosenPerson);
				current.target = target;
				current = target;
				availablePeople.remove(chosenPerson);
			}

			//Now make the first person the traget of the last-picked person.
			current.target = people.get(0);
		}
		catch (Exception e){
		System.out.println("Something went wrong!");
		}
	}
	
	//takes a list of strings and shuffles them
	public static String[] ScrambleContinuous (List<String> inPeople)
	{
		try {
			//Get number of people and create an array for the people
			int peopleCount = inPeople.size();
			String[] outPeople = new String[peopleCount];

			//loop from the list and give the people their list position
			Random rand = new Random((long) (new Date().getTime()));
			
			for (int i = peopleCount - 1; i >= 0 ; i--){

				//pick a slot from inPeople
				int chosenPerson = i> 0 ? rand.nextInt(i + 1) : 0 ;

				//put them in the ith slot and remove them from the original
				outPeople[i] = inPeople.get(chosenPerson);
				inPeople.remove(chosenPerson);
			}

			return outPeople;
		}
		catch (Exception e){
		System.out.println("error!");
		try{System.in.read();}catch(Exception ee){}
			return null;
		}
	}
}