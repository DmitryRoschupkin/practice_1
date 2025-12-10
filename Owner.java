package practice_1;

public class Owner{
		private int ownerId;
		private String name;
		private String phone;
		private int numberOfPets;

		public Owner(int ownerId, String name, String phone, int numberOfPets){
			this.ownerId = ownerId;
			this.name = name;
			this.phone = phone;
			this.numberOfPets = numberOfPets;
		}
		public Owner(){
			ownerId = 0;
			name = "John Smith";
			phone = "00-00-00";
			numberOfPets = 0;
		}

		public void addPets(int addedNum){
			numberOfPets += addedNum;
		}
		public void addPets(){
			numberOfPets ++;
		}
		boolean isFrequentClient(){
			if(numberOfPets >= 3) return true;
			else return false;
			//in future i'll add some new super-mega-cool logic for this method, related with other classes, but now i don't want
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
			return numberOfPets;
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
		public void setNumberOfPets(int numberOfPets){
			this.numberOfPets = numberOfPets;
		}
		
		//toString
		public String toString(){
			return "ownerId: "+getOwnerId()+"\n"
			+ "Owner's name: "+getName()+"\n"
			+ "Owner's phone: "+getPhone()+"\n"
			+ "Owner's number of pets: "+getNumberOfPets();
		}
}
