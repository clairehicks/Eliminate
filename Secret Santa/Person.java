import java.util.UUID;

class Person
{
	public UUID id;
	public String name;
	public Person target;
	
	//initialiser takes a name and gives the player an ID. This ensures uniqueness.
	public Person(String name){
		this.id = UUID.randomUUID();
		this.name = name;
	}
}