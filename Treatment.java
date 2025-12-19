package practice_1;

public class Treatment {
    private int TreatmentID = 0;
    private double totalAmount;
    private String status;
    Owner owner;
    Pet pet;
    Veterinarian veterinarian;
    Treatment(int TreatmentID, Owner owner, Pet pet, Veterinarian veterinarian){
        this.TreatmentID = TreatmentID;
        this.owner = owner;
        this.pet = pet;
        this.veterinarian = veterinarian;
    }
    public void completeTreatment(){
        status = "Completed";
    }
    public boolean isComplete(){
        return status == "Completed";
    }
    public double calculateAmount(){
            if(pet.getSpecies() == "dog") totalAmount = 500;
            else if(pet.getSpecies() == "cat") totalAmount = 700;
            else if(pet.getSpecies() == "parrot") totalAmount = 300;
            else if(pet.getSpecies() == "rabbit") totalAmount = 750;
            else totalAmount = -1;
            if(owner.isVIP()) return  totalAmount/2;
            else return totalAmount;
    }

    //getters
    public int getTreatmentID(){
        return TreatmentID;
    }
    public double getTotalAmount(){
        return totalAmount;
    }
    public String getStatus(){
        return status;
    }
    public Owner getOwner(){
        return owner;
    }
    public Pet getPet(){
        return pet;
    }
    public Veterinarian getVeterinarian(){
        return veterinarian;
    }

    //setters
    public void setTreatmentID(int treatmentID){
        if(treatmentID >= 0){
            this.TreatmentID = treatmentID;
        }else System.out.println("TreatmentID can't be negative");
    }
    public void setTotalAmount(double totalAmount){
        if(totalAmount >= 0){
            this.totalAmount = totalAmount;
        }else System.out.println("Total amount can't be negative");
    }
    public void setStatus(String status){
        if(status.equals("Completed") ||  status.equals("Pended") && status != null && !status.isEmpty()) {
            this.status = status;
        }else System.out.println("Invalid status");
    }
    public void setOwner(Owner owner){
        if(owner != null){
            this.owner = owner;
        }else System.out.println("Owner can't be null");
    }
    public void setPet(Pet pet){
        if(pet != null){
            this.pet = pet;
        }else System.out.println("Pet can't be null");
    }
    public void setVeterinarian(Veterinarian veterinarian){
        if(veterinarian != null){
            this.veterinarian = veterinarian;
        }else System.out.println("Veterinarian can't be null");
    }
}