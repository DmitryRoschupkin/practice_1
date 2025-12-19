package practice_1;
import java.util.ArrayList;

class Main{
	public static void main(String[] args){
		ArrayList<Owner> owners = new ArrayList<Owner>();
		ArrayList<Veterinarian> veterinarians = new ArrayList<Veterinarian>();


		Owner owner1 = new Owner(1, "Dmitriy Rochshupkin", "03-03-03");
		Owner owner2 = new Owner(2, "Manas Agatayev", "10-10-10");
		Owner owner3 = new Owner(3, "Aidos Lazzatbekov", "16-16-16");

		owners.add(owner1);
		owners.add(owner2);
		owners.add(owner3);

		Pet dog1 = new Pet(1, "Mishka", "dog", 2, owner1);
		Pet cat1 = new Pet(2, "Karamel", "cat", 5, owner2);
		Pet parrot1 = new Pet(3, "Sanyok", "parrot", 2, owner3);

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

		for(Owner owner : owners){
			for(Pet pet : owner.getPets()){
				System.out.println(pet);
				System.out.println();
			}
		}

		//testing Veterinarian's methods
        for (Veterinarian veterinarian : veterinarians) {
            System.out.println("Is " + veterinarian.getName() + " experienced enough?");
            System.out.println(veterinarian.isExperienced());
        }
		System.out.println("\n");
		System.out.println("Can "+veterinarian1.getName()+" treat "+parrot1.getSpecies()+" "+parrot1.getName()+"?");
		System.out.println(veterinarian1.canTreat(parrot1));
		System.out.println("Can "+veterinarian2.getName()+" treat "+dog1.getSpecies()+" "+dog1.getName()+"?");
		System.out.println(veterinarian2.canTreat(dog1));
		System.out.println("\n");

		//testing Owners' methods
        for (Owner owner : owners) {
            System.out.println(owner.toString());
        }
		System.out.println("\n");
		System.out.println("Adding 3 new pets to "+owner1.getName()+"\n");
		//owner1.addPets(5);
		owner1.regPet("Rex","dog", 13);
		owner1.regPet("Vox","parrot", 2);
		owner1.regPet("Tigr Lev","cat", 5);
		System.out.println("Number of "+owner1.getName()+"'s pets is "+owner1.getNumberOfPets()+"\n");
		for(Pet pet : owner1.getPets()){
			System.out.println(pet);
			System.out.println();
		}
		System.out.println("\n");
        for (Owner owner : owners) {
            System.out.println("Is " + owner.getName() + " frequent client?");
            System.out.println(owner.isFrequentClient());
        }

	}
}
