import java.io.*;
import java.util.*;
import java.lang.*;

class Santa
{
	public static void main(String args[])
	{
		//Hard code List of people for now
		List<String> people = new ArrayList<String>(Arrays.asList("Anna","Bob","Carl","David","Elaine","Fred"));	 
		
		//Scramble the people
		String[] scrambled = ScrambleList.ScrambleContinuous(people);

		Thread t;
		for (String i: scrambled){
			//Print a person
			System.out.println(i);

			//wait 3 seconds
			try 
			{
				Thread.sleep(3000);
			} 
			catch(InterruptedException e)
			{
				 // this part is executed when an exception (in this example InterruptedException) occurs
			}
		}

		System.out.println("That is all the people");	
		try{

			System.in.read();
		}
		catch (Exception e){}
	}
}