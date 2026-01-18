package practice_1.models;

import practice_1.exceptions.IncorrectTreatmentException;

public abstract class Treatment {
    protected int TreatmentID = 0;
    protected double totalAmount;
    protected String status;
    protected String treatmentType;
    protected Owner owner;
    protected Pet pet;
    protected Veterinarian veterinarian;
    public Treatment(int TreatmentID, Owner owner, Pet pet, Veterinarian veterinarian, String status){
        setTreatmentID(TreatmentID);
        setOwner(owner);
        setPet(pet);
        setVeterinarian(veterinarian);
        setStatus(status);
    }

    public abstract void completeTreatment();

    public boolean isComplete(){
        return status.equals("Completed");
    }

    public double calculateAmount() {
        switch (pet.getSpecies()) {
            case "dog":
                totalAmount = 500;
                break;
            case "cat":
                totalAmount = 700;
                break;
            case "parrot":
                totalAmount = 300;
                break;
            case "rabbit":
                totalAmount = 750;
                break;
            default:
                totalAmount = -1;
                break;
        }
        if (owner.isVIP()) return totalAmount / 2;
        else return totalAmount;
    }

    //getters
    public int getTreatmentID(){
        return TreatmentID;
    }
    public double getTotalAmount(){
        return calculateAmount();
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
    public String getTreatmentType(){
        return "General treatment";
    }

    //setters
    public void setTreatmentID(int treatmentID){
        if(treatmentID >= 0){
            this.TreatmentID = treatmentID;
        }else throw new IllegalArgumentException("Treatment ID cannot be negative");
    }
    public void setTotalAmount(double totalAmount){
        if(totalAmount >= 0){
            this.totalAmount = totalAmount;
        }else throw new IllegalArgumentException("Total amount cannot be negative");
    }
    public void setStatus(String status){
        if(status.equalsIgnoreCase("Completed") || status.equalsIgnoreCase("Failed") ||  status.equalsIgnoreCase("Cancelled") || status.equalsIgnoreCase("Ongoing")){
            this.status = status;
        }else throw new IncorrectTreatmentException("Invalid status");
    }
    public void setOwner(Owner owner){
        if(owner != null){
            this.owner = owner;
        }else throw new IllegalArgumentException("Owner cannot be null");
    }
    public void setPet(Pet pet){
        if(pet != null){
            this.pet = pet;
        }else throw new IllegalArgumentException("Pet cannot be null");
    }
    public void setVeterinarian(Veterinarian veterinarian){
        if(veterinarian != null){
            this.veterinarian = veterinarian;
        }else throw new IllegalArgumentException("Veterinarian cannot be null");
    }
    public void setTreatmentType(String treatmentType){
        if(treatmentType != null){
            this.treatmentType = treatmentType;
        }else throw new IllegalArgumentException("Treatment type cannot be null");
        if(treatmentType.equals("Vaccination") || treatmentType.equals("Surgery")){
            this.treatmentType = treatmentType;
        }else throw new IncorrectTreatmentException("Invalid treatment type");
    }

    @Override
    public String toString() {
        return "ThreatmentID: "+getTreatmentID()+"\n"
                +"Total Amount: "+getTotalAmount()+"\n"
                +"Status: "+getStatus()+"\n"
                +"Owner: "+getOwner()+"\n"
                +"Pet: "+getPet()+"\n"
                +"Veterinarian: "+getVeterinarian()+"\n"
                +"TreatmentType: "+getTreatmentType();
    }
}