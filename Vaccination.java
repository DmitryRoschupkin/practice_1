package practice_1;

public class Vaccination extends Treatment{
    private String vaccineName;
    Vaccination(int TreatmentID, Owner owner, Pet pet, Veterinarian veterinarian, String status, String vaccineName) {
        super(TreatmentID, owner, pet, veterinarian, status);
        this.vaccineName = vaccineName;
    }
    @Override
    public void completeTreatment(){
        System.out.println("Doing Vaccination to "+pet.getName()+" by "+veterinarian.getName()+" with vaccine "+vaccineName);
        super.status = "Completed";
    }

    @Override
    public double calculateAmount() {
        return super.totalAmount + 250;
    }

    public String getVaccineName() {
        return vaccineName;
    }
    public String getTreatmentType() {
        return treatmentType;
    }

    public void setVaccineName(String vaccineName) {
        if(vaccineName != null){
            this.vaccineName = vaccineName;
        }
    }
}