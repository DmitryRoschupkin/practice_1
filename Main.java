package practice_1;
import java.util.ArrayList;

class Main{
	public static void main(String[] args){
		ArrayList<Pet> pets = new ArrayList<Pet>();
		ArrayList<Owner> owners = new ArrayList<Owner>();
		ArrayList<Veterinarian> veterinarians = new ArrayList<Veterinarian>();

		Pet dog1 = new Pet(1, "Mishka", "dog", 2, "Dmitriy Rochshupkin");
		Pet cat1 = new Pet(2, "Karamel", "cat", 5, "Manas Agatayev");
		Pet parrot1 = new Pet(3, "Sanya", "parrot", 2, "Aidos Lazzatbekov");

		pets.add(dog1);
		pets.add(cat1);
		pets.add(parrot1);

		Owner owner1 = new Owner(1, "Dmitriy Rochshupkin", "03-03-03", 1);
		Owner owner2 = new Owner(2, "Manas Agatayev", "10-10-10", 1);
		Owner owner3 = new Owner(3, "Aidos Lazzatbekov", "16-16-16", 1);

		owners.add(owner1);
		owners.add(owner2);
		owners.add(owner3);

		Veterinarian veterinarian1 = new Veterinarian(1, "Smith Johnson", "dog", 10);
		Veterinarian veterinarian2 = new Veterinarian(2, "Lionel Messi", "dog", 3);
		Veterinarian veterinarian3 = new Veterinarian(3, "Timur Iskakov", "cat", 16);
		Veterinarian veterinarian4 = new Veterinarian(4, "Alexander Durov", "parrot", 2);
		Veterinarian veterinarian5 = new Veterinarian(5, "Anna Nikolayeva", "rabbit", 1);

		veterinarians.add(veterinarian1);
		veterinarians.add(veterinarian2);
		veterinarians.add(veterinarian3);
		veterinarians.add(veterinarian4);
		veterinarians.add(veterinarian5);

		//testing Pet's methods
		System.out.println("Is "+dog1.getName()+" young?");
		System.out.println(dog1.isYoung());

		System.out.println("What is "+cat1.getName()+"'s life stage?");
		System.out.println(cat1.getLifeStage());

		System.out.println("What is "+parrot1.getName()+"'s life stage?");
		System.out.println(parrot1.getLifeStage());
		System.out.println("\n");

		System.out.println(dog1.toString());
		System.out.println("\n");

		System.out.println(cat1.toString());
		System.out.println("\n");

		System.out.println(parrot1.toString());
		System.out.println("\n");

		//testing Veterinarian's methods
		for(int i = 0; i < veterinarians.size(); i++){
			System.out.println("Is "+veterinarians.get(i).getName()+" experienced enough?");
			System.out.println(veterinarians.get(i).isExperienced());
		}
		System.out.println("\n");
		System.out.println("Can "+veterinarian1.getName()+" treat "+parrot1.getSpecies()+" "+parrot1.getName()+"?");
		System.out.println(veterinarian1.canTreat(parrot1));
		System.out.println("Can "+veterinarian2.getName()+" treat "+dog1.getSpecies()+" "+dog1.getName()+"?");
		System.out.println(veterinarian2.canTreat(dog1));

		//testing Owners' methods
		

	}
}
