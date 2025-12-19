package practice_1;

public class Pet{
	private int petId;
	private String name;
	private String species;
	private int age;
	private Owner owner;

	public Pet(int petId, String name, String species, int age, Owner owner){
		this.petId = petId;
		this.name = name;
		this.species = species;
		this.age = age;
		this.owner = owner;
		owner.addPets(this);
	}
	public Pet(){
		petId = 0;
		name = "Sharik";
		species = "dog";
		age = 5;
		//ownerName = "John Smith";
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
				return "we can't calculate life stage for this animal((";
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
	public String getOwnerName(){
		return owner != null ? owner.getName() : "no owner or incorrect owner's name";
		//i used ternary operator for validation and connected pets with owners, so
		//owner is not just text, it's real object like in databases
	}

	//setters
	public void setName(String name){
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }else System.out.println("Invalid name: cannot be empty");
    }
	public void setPetId(int petId){
        if (petId >= 0) {
            this.petId = petId;
        }else System.out.println("Invalid petId: cannot be negative");
    }
	public void setSpecies(String species){
        if (species != null && !species.isEmpty()) {
            this.species = species;
        }else System.out.println("Invalid species: cannot be empty");
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
		"Owner's name: "+getOwnerName();
	}
}
