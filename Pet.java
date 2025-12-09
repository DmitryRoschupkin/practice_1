package practice_1;
import String;

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
		if(species.isEqual("dog"){
			if(age >= 0 && age <= 8) return true;
			else return false;
		}

	}
	public String getLifeStage(){
		
	}
	public int getPetId(){
		return petId;
	}	

	public String toString(){
		System.out.println("petId: "+getPetId());
		System.out.println("Name: ");
		System.out.println("petId: "+getPetId());
		System.out.println("petId: "+getPetId());
		System.out.println("petId: "+getPetId());
	}
}
