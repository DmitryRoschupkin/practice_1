package practice_1.models;

public class Surgery extends Treatment {
    private int duration;
    private String difficulcy;
    public void defineDifficulcy(){
        if(duration > 0 && duration <= 2){
            difficulcy = "Easy";
        }
        else if(duration > 2 && duration <= 6){
            difficulcy = "Medium";
        }
        else if(duration > 6){
            difficulcy = "Hard";
        }
        else{
            difficulcy = "Unknown";
        }
    }
    public Surgery(int TreatmentID, Owner owner, Pet pet, Veterinarian veterinarian, String status, int duration) {
        super(TreatmentID, owner, pet, veterinarian, status);
        this.duration = duration;
        defineDifficulcy();
    }

    //implemented method
    @Override
    public void completeTreatment() {
        if(duration == 1) System.out.println("Surgery on "+pet.getName() +" has been completed in "+duration+" hour");
        else System.out.println("Surgery on "+pet.getName() +" has been completed in "+duration+" hours");
        status = "Completed";
    }


    @Override
    public double calculateAmount(){
        switch(difficulcy) {
            case "Easy":
                return super.totalAmount += 300;
            case "Medium":
                return super.totalAmount += 500;
            case "Hard":
                return super.totalAmount += 1000;
            default:
                return super.totalAmount;
        }
    }

    @Override
    public String getTreatmentType() {
        return "Surgery";
    }
    public int getDuration() {
        return duration;
    }
    public String getDifficulcy() {
        return difficulcy;
    }
    public void setDuration(int duration) {
        if(duration > 0) this.duration = duration;
        else System.out.println("Invalid duration: cannot be negative");
    }

}
