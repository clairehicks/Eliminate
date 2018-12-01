import java.io.*;
import java.util.*;
import java.util.Random;
import java.util.Date;

class ScrambleList
{
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