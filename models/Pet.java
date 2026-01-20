package practice_1.models;

import practice_1.exceptions.IncorrectSpeciesException;

public class Pet implements Pacient {
	private int petId;
	private static int nextId = 1;
	private String name;
	private String species;
	private int age;
	private Owner owner;

	public Pet(String name, String species, int age, Owner owner){
		setPetId(nextId++);
		setName(name);
		setSpecies(species);
		setAge(age);
		this.owner = owner;
		owner.addPets(this);
	}

	public boolean isYoung(){
		switch (species){
			case "dog":
				if(age >= 0 && age <= 8) return true;
				else return false;
			case "cat":
				if(age >= 0 && age <= 7) return true;
				else return false;
			case "parrot":
				if(age >= 0 && age <= 8) return true;
				else return false;
			case "rabbit":
				if(age >= 0 && age <= 7) return true;
				else return false;
			default:
				return false;
		
		}
	}
	@Override
	public String getLifeStage(){
		switch(species){
			case "dog":
				if(age < 1) return "baby";
				else if(age <= 8) return "young";
				else return "senior";
			case "cat":
				if(age < 1) return "kitten";
				else if(age <= 7) return "young";
				else return "senior";
			case "parrot":
				if(age < 1) return "baby parrot";
				else if(age <= 8) return "young";
				else return "senior";
			case "rabbit":
				if(age < 1) return "baby rabbit";
				else if(age <= 7) return "young";
				else return "senior";
			default:
				return "We can't calculate life stage for this animal((";
		}
	}
	//getters
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
	public String getOwnerName() {
		return owner != null ? owner.getName() : "no owner or incorrect owner's name";
	}
	public Owner getOwner(){
		return owner;
	}
	//setters
	public void setName(String name){
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }else throw new  IllegalArgumentException("Name cannot be null or empty");
    }
	public void setPetId(int petId){
        if (petId >= 0) {
            this.petId = petId;
        }else throw new  IllegalArgumentException("Pet Id cannot be negative");
    }
	public void setSpecies(String species){
        if (species != null && !species.isEmpty()) {
            this.species = species;
        }else System.out.println("Invalid species: cannot be empty");
		if (species.equalsIgnoreCase("dog") || species.equalsIgnoreCase("cat") || species.equalsIgnoreCase("parrot") || species.equalsIgnoreCase("rabbit")){
			this.species = species;
		}else throw new IncorrectSpeciesException("Invalid species: we don't treat this animals yet");
    }
	public void setAge(int age){
        if (age >= 0) {
            this.age = age;
        }else System.out.println("Invalid age: cannot be negative");
    }

	@Override
	public String toString(){
		return "petId: "+getPetId()+"\n" +
		"Name: "+getName()+"\n" +
		"Species: "+getSpecies()+"\n" +
		"Age: "+getAge()+"\n" +
		"Owner's name: "+getOwnerName()+"\n" +
		"Life Stage: "+getLifeStage();
	}
}
