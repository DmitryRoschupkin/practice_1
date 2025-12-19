package practice_1;

public class Veterinarian{
    private int vetId;
    private String name;
    private String specialization;
    private int experience;
    private String phone;

    public Veterinarian(int vetId, String name, String specialization, int experience, String phone){
        this.vetId = vetId;
        this.name = name;
        this.specialization = specialization;
        this.experience = experience;
        this.phone = phone;
    }
    public Veterinarian(){
        this.vetId = 0;
        this.name = "Ivan Veterinarov";
        this.specialization = "dog";
        this.experience = 5;
        this.phone = "00-00-00";
    }

    public boolean canTreat(Pet pet){
        if(specialization.equals(pet.getSpecies()))return true;
        else return false;
    }

    public boolean isExperienced(){
        if(experience >= 5) return true;
        else return false;
    }
    //getters
    public int getVetId(){
        return vetId;
    }
    public String getName(){
        return name;
    }
    public String getSpecialization(){
        return specialization;
    }
    public int getExperience(){
        return experience;
    }
    public String getPhone(){return phone;}
    //setters
    public void setVetId(int vetId){
        if (vetId >= 0) {
            this.vetId = vetId;
        }else System.out.println("Invalid vetId: cannot be negative");
    }
    public void setName(String name){
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }else System.out.println("Invalid name: cannot be empty");
    }
    public void setSpecialization(String specialization){
        if (specialization != null && !specialization.isEmpty()) {
            this.specialization = specialization;
        }else System.out.println("Invalid specialization: cannot be empty");
    }
    public void setExperience(int experience){
        if (experience >= 0) {
            this.experience = experience;
        }else if (experience >=100) {
            System.out.println("I don't believe that it is not joke, but anyway I'll accept it))");
            this.experience = experience;
        }else System.out.println("Invalid experience: cannot be negative");
    }
    public void setPhone(String phone){
        if (phone != null && !phone.isEmpty()) {
            this.phone = phone;
        }else System.out.println("Invalid phone: cannot be empty");
    }

    public String toString(){
        return "vetId: "+getVetId()+"\n"
                + "Veterinatian's name: "+getName()+"\n"
                + "Specialization: "+getSpecialization()+"\n"
                + "Experience: "+getExperience()+"\n"
                + "Phone: "+getPhone();
    }


}