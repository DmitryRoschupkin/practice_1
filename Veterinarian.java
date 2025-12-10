package practice_1;

class Veterinarian{
    private int vetId;
    private String name;
    private String specialization;
    private int experience;

    public Veterinarian(int vetId, String name, String specialization, int experience){
        this.vetId = vetId;
        this.name = name;
        this.specialization = specialization;
        this.experience = experience;
    }
    public Veterinarian(){
        this.vetId = 0;
        this.name = "Ivan Veterinarov";
        this.specialization = "dog";
        this.experience = 5;
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
    //setters
    public void setVetId(int vetId){
        this.vetId = vetId;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setSpecialization(String specialization){
        this.specialization = specialization;
    }
    public void setExperience(int experience){
        this.experience = experience;
    }

    public String toString(){
        return "vetId: "+getVetId()+"\n"
                + "Veterinatian's name: "+getName()+"\n"
                + "Specialization: "+getSpecialization()+"\n"
                + "Experience: "+getExperience();
    }


}