import java.io.*;
import java.util.*;
import java.util.Random;
import java.util.Date;

class ScrambleList
{
	//takes a list of people and allocates them a target in a continuous loop
	public static void ScramblePeopleContinuous (List<Person> people, boolean isDebug){
		try {
			//get number of people and create an array for the available (not yet set as a target) people
			int peopleCount = people.size();
			List<Person> availablePeople = new ArrayList<Person>();
			availablePeople.addAll(people);
			
			//if in debug mode, use a fixed seed, otherwise seed from time to get psudo-random numbers
			Random rand = new Random(!isDebug ? (long) (new Date().getTime()): 1);
			
			//we begin by allocating a target to the first person on the list, so remove them from the available list
			Person current = people.get(0);
			availablePeople.remove(current);

			for (int i = peopleCount - 2; i >= 0 ; i--){
				//pick a target for the current person
				int chosenPerson = i> 0 ? rand.nextInt(i + 1) : 0 ;
				
				//put the target person in the ith slot and remove them from the available people
				Person target = availablePeople.get(chosenPerson);
				current.target = target;
				current = target;
				availablePeople.remove(chosenPerson);
			}

			//now make the first person the target of the last-picked person to complete the loop.
			current.target = people.get(0);
		}
		catch (Exception e){
		System.out.println("Error occured while shuffling the users! (Continuous)");
		}
	}
	
	//takes a list of people and allocates them a target. Does not guarantee a single loop.
	public static void ScramblePeopleMicroLoops (List<Person> people, boolean isTest){
		try {
			//get number of people and create an array for the available (not yet set as a target)  people
			int peopleCount = people.size();
			List<Person> availablePeople = new ArrayList<Person>();
			availablePeople.addAll(people);

			//if in debug mode, use a fixed seed, otherwise seed from time to get psudo-random numbers
			Random rand = new Random(!isTest ? (long) (new Date().getTime()): 1);
			
			Person current;
			Person target;
			
			for (int i = peopleCount - 1; i > 0 ; i--){
				current = people.get(i);
				
				//pick a target for the current person
				int chosenPerson = rand.nextInt(i + 1);
				
				//check that we have not chosen a person as their own target
				target = availablePeople.get(chosenPerson);
					
				if(current.id == target.id)
				{
					//if so, get next person (loop to front if necessary)
					chosenPerson++;
					
					if(chosenPerson > i)
					{
						chosenPerson = 0;
					}
					target = availablePeople.get(chosenPerson);
				}
				
				//put them in the ith slot and remove them from the available people
				current.target = target;
				availablePeople.remove(chosenPerson);
			}

			//now check that the last person to be allocated a target != the last target.
			current = people.get(0);
			target = availablePeople.get(0);
			
			if(current.id != target.id)
			{
				current.target = target;
			}else{
				//swap 0th and 1st targets
				Person first = people.get(1);
				current.target = first.target;
				first.target = current;
			}
		}
		catch (Exception e){
		System.out.println("Error occured while shuffling the users! (MicroLoops)");
		}
	}
	
	//old version - takes a list of strings and shuffles them
	public static String[] ScrambleContinuous (List<String> inPeople)
	{
		try {
			//get number of people and create an array for the people
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
		System.out.println("error in continuous shuffle!");
		try{System.in.read();}catch(Exception ee){}
			return null;
		}
	}
}