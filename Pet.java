package practice_1;

public class Pet{
	private int petId;
	private String name;
	private String species;
	private int age;
	private String ownerName;
	public Pet(int petId, String name, String species, int age, String ownerName){
		this.petId = petId;
		this.name = name;
		this.species = species;
		this.age = age;
		this.ownerName = ownerName;
	}
	public Pet(){
		petId = 0;
		name = "Bobik";
		species = "dog";
		age = 5;
		ownerName = "John Smith";
	}
	public boolean isYoung(){
		if(species.equals("dog")){
			if(age >= 0 && age <= 8) return true;
			else return false;
		}else return true; //default output for other animals,
				// I'll write some conditions for some other species later

	}
	public int getPetId(){
		return petId;
	} 
	public String getName(){
		return name;
	}
	public String getSpecies(){
		return species;
	}
	public int getAge(){
		return age;
	}
	public String getOwnerName(){
		return ownerName;
	}
	public String toString(){
		return "petId: "+getPetId()+"\n" +
		"Name: "+getName()+"\n" +
		"Species: "+getSpecies()+"\n" +
		"Age: "+getAge()+"\n" +
		"Owner's name: "+getOwnerName();
	}
}
