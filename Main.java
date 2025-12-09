package practice_1;

class Main{
	public static void main(String[] args){
		Pet dog1 = new Pet(1, "Mishka", "dog", 2, "Dmitriy Rochshupkin");
		Pet cat1 = new Pet(2, "Karamel", "cat", 5, "Manas Agatayev");
		Pet parrot1 = new Pet(3, "Sanya", "parrot", 2, "Aidos Lazzatbekov");
		System.out.println("Is "+dog1.getName()+" young?");
		System.out.println(dog1.isYoung());
		System.out.println("What is "+cat1.getName()+"'s life stage?");
		System.out.println(cat1.getLifeStage());
		System.out.println("What is "+parrot1.getName()+"'s life stage?");
		System.out.println(parrot1.getLifeStage());
		System.out.println(dog1.toString());
		System.out.println(cat1.toString());
		System.out.println(parrot1.toString());
	}
}
