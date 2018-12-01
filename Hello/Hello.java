import java.io.*;

class Hello
{
	public static void main(String args[])
	{
		for (String i: args){
			System.out.println(i);
		}

		try{
			System.in.read();
		}
		catch (Exception e){}
	}
}