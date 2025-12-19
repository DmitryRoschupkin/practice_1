package practice_1;

import java.util.ArrayList;

public class Owner{
		private int ownerId;
		private String name;
		private String phone;
		private int loyaltyPoints;
		private ArrayList<Pet> pets;

		public Owner(int ownerId, String name, String phone){
			this.ownerId = ownerId;
			this.name = name;
			this.phone = phone;
			this.loyaltyPoints = 0;
			this.pets = new ArrayList<>();
		}
		public Owner(){
			ownerId = 0;
			name = "John Smith";
			phone = "00-00-00";
			//numberOfPets = 0;
			loyaltyPoints = 0;
		}
		//this method is used in Pet class in order to make connection
		//between owner and pet like in real DBMS
		public void addPets(Pet pet){
			pets.add(pet);
		}
		public Pet regPet(String name, String species, int age){
			//String petName = "pet"+(pets.size()+1);
			Pet pet = new Pet(pets.size()+1, name, species, age, this);
			return pet;
		}
		boolean isFrequentClient(){
			return pets.size()>=3;
		}

		//getters
		public int getOwnerId(){
			return ownerId;
		}	
		public String getName(){
			return name;
		}
		public String getPhone(){
			return phone;
		}
		public int getNumberOfPets(){
			return pets.size();
		}
		// I decided to place pet's getter here, because pets are related with owner.
		// I used ArrayList to get array of pets that belong to owner,
		// And "new" instruction in order to return copy of
		// "pets" array to defend list of pets from outer access
		// true incapsulation!!! imho, this move can help me when I learn DBMS
		public int getLoyaltyPoints(){
				return loyaltyPoints;
		}
		public ArrayList <Pet> getPets(){
			return new ArrayList<>(pets);
		}

		//setters
		public void setOwnerId(int ownerId){
			this.ownerId = ownerId;
		}
		public void setName(String name){
			this.name = name ;
		}
		public void setPhone(String phone){
			this.phone = phone;
		}

		
		//toString
		public String toString(){
			return "ownerId: "+getOwnerId()+"\n"
			+ "Owner's name: "+getName()+"\n"
			+ "Owner's phone: "+getPhone()+"\n"
			+ "Owner's number of pets: "+getNumberOfPets()+"\n"
			+ "Owner's loyalty points: "+getLoyaltyPoints();
		}
}
