package practice_1.models;

public class Veterinarian{
    private int vetId;
    private String name;
    private String specialization;
    private int experience;
    private String phone;

    public Veterinarian(int vetId, String name, String specialization, int experience, String phone){
        setVetId(vetId);
        setName(name);
        setSpecialization(specialization);
        setExperience(experience);
        setPhone(phone);
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
        if(vetId < 0){
            throw new IllegalArgumentException("Vet Id cannot be negative");
        }
        this.vetId = vetId;
    }
    public void setName(String name){
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }
    public void setSpecialization(String specialization){
        if (specialization == null || specialization.isEmpty()) {
		    throw new IllegalArgumentException("Specialization cannot be empty!");
        }
        this.specialization = specialization;
    }
    public void setExperience(int experience){
        if (experience >= 0) {
            this.experience = experience;
        }else if (experience >=100) {
            System.out.println("I don't believe that it is not joke, but anyway I'll accept it))");
            this.experience = experience;
        }else throw new IllegalArgumentException("Experience cannot be negative");
    }
    public void setPhone(String phone){
        if (phone == null || phone.isEmpty()) {
            throw new IllegalArgumentException("Phone cannot be empty");
        }
        this.phone = phone;
    }

    public String toString(){
        return "vetId: "+getVetId()+"\n"
                + "Veterinatian's name: "+getName()+"\n"
                + "Specialization: "+getSpecialization()+"\n"
                + "Experience: "+getExperience()+"\n"
                + "Phone: "+getPhone();
    }


}
