import java.util.*;
import java.util.UUID;


class Person
{
	public UUID id;
	public String name;
	public Person target;
	
	//Initialiser takes a name and gives them an ID. This ensures uniqueness.
	public Person(String name){
		this.id = UUID.randomUUID();
		this.name = name;
	}
}