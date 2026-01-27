package practice_1.menu;

import practice_1.database.OwnerDAO;
import practice_1.database.PetDAO;
import practice_1.database.VetDAO;
import practice_1.models.*;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuManager implements Menu {
//    private static ArrayList<Owner> owners = new ArrayList<Owner>();
    //private static ArrayList<Veterinarian> veterinarians = new ArrayList<Veterinarian>();
    private static ArrayList<Treatment> treatments = new ArrayList<>();
    static OwnerDAO ownerDAO = new OwnerDAO();
    static PetDAO petDAO = new PetDAO();
    static VetDAO vetDAO = new VetDAO();
    private static ArrayList<Owner> owners_fromDb = ownerDAO.selectAllOwners();
    private static ArrayList<Pet> pets_fromDb = petDAO.selectAllPets();
    private static ArrayList<Veterinarian> vets_fromDb = vetDAO.selectAllVets();

    private static Scanner s = new Scanner(System.in);


    //validation methods

    public static boolean isValid(String input){
        return !input.isEmpty();
    }

    public static boolean isValid(int input){
        return input >= 0;
    }

    private static String readSafeString(String message) {
        while (true){
            System.out.println(message);
            System.out.print(">>> ");
            String input = s.nextLine();
            if(input.isEmpty()){
                System.out.println("Error: empty input");
                continue;
            }
            return input;
        }
    }

    private static int readSafeInt(String message) {
        while(true){
            try{
                String input = readSafeString(message);
                int number = Integer.parseInt(input);

                if(!isValid(number)){
                    System.out.println("Error: number cannot be negative!");
                    continue;
                }
                return number;
            }catch(NumberFormatException e){
                System.out.println("Invalid input! Please, enter integer!");
            }
        }
    }

    //other methods

    public static void displayMenu() {
        System.out.println("\n=====================================");
        System.out.println("VETERINARIAN CLINIC MANAGEMENT SYSTEM");
        System.out.println("=====================================");
        System.out.println("1. Add Owner");
        System.out.println("2. View Owners");
        System.out.println("3. Add Pets");
        System.out.println("4. View Pets");
        System.out.println("5. Add Veterinarians");
        System.out.println("6. View Veterinarians");
        System.out.println("7. Add Treatments");
        System.out.println("8. View Treatments");
        System.out.println("9. Update owner");
        System.out.println("10. Delete owner");
        System.out.println("=======SEARCH AND FILTER=======");
        System.out.println("11. Search Owner by name");
        System.out.println("12. Search Owner by loyalty points range");
        System.out.println("13. Most valuble owners (LP >= min)");
        System.out.println("=======DEMO & OTHER=======");
        System.out.println("14. Polymorphism demo");
        System.out.println("0. Exit");
        System.out.println("\n=====================================");
        System.out.println("Enter your choice:\n");
        System.out.print(">>> ");
    }

    private static void createOwner() {
        String name = readSafeString("Enter Owner's name: ");
        String phone = readSafeString("Enter Owner's phone number: ");
        Owner owner = new Owner(owners_fromDb.size() + 1, name, phone);
        //owners.add(owner);
        System.out.println("New Owner created successfully!");
        OwnerDAO dao = new OwnerDAO();
        dao.insertOwner(owner);

    }
    private static void createPets(){
        String name = readSafeString("Enter Pet's name: ");
        String species = readSafeString("Enter Pet's species: ");
        int age = readSafeInt("Enter Pet's age: ");
        String ownerName = readSafeString("Enter Owner's name: ");
        Owner owner = null; // we have to find owner
//        OwnerDAO ownerDAO = new OwnerDAO();
//        ArrayList<Owner> owners_fromDb = ownerDAO.selectAllOwners();
        for(Owner o : owners_fromDb){
            if(o.getName().equalsIgnoreCase(ownerName)){
                owner = o;
                break;
            }
        }
        if(owner == null){
            System.out.println("Owner not found!");
            return;
        }
        Pet pet = new Pet(name, species, age, owner);
        System.out.println("New Pet with ID "+pet.getPetId()+" created successfully!");
        owner.getPets().add(pet);
        petDAO.insertPet(pet);
    }
    private static void createVeterinarians(){
        String name = readSafeString("Enter Veterinarian's name: ");
        String specialization = readSafeString("Enter Veterinarian's specialization: ");
        int experience = readSafeInt("Enter Veterinarian's experience: ");
        if(experience == 67) System.out.println("67 67 67 ne smeshno");
        String phone = readSafeString("Enter Veterinarian's phone: ");
        Veterinarian veterinarian = new Veterinarian(vets_fromDb.size() + 1, name, specialization, experience, phone);
        vetDAO.insertVet(veterinarian);
        //vets_fromDb.add(veterinarian);
        System.out.println("New Veterinarian created successfully!");
    }
    private static void createTreatments(){
        String ownerName = readSafeString("Enter Owner's name: ");
        String veterinarianName = null;
        String petName = null;
        veterinarianName = readSafeString("Enter Veterinarian's name: ");
        petName = readSafeString("Enter Pet's name: ");
        String status = readSafeString("Enter treatment's status: ");
        String type = readSafeString("Enter treatment's type: ");
        Owner owner = null;
        Veterinarian veterinarian = null;
        Pet pet = null;
        for(Owner o : owners_fromDb){
            if(o.getName().equalsIgnoreCase(ownerName)){
                owner = o;
                break;
            }
        }
        if(owner == null){
            System.out.println("Owner not found!");
            return;
        }
        for(Veterinarian v : vets_fromDb){
            if(v.getName().equalsIgnoreCase(veterinarianName)){
                veterinarian = v;
                break;
            }
        }
        if(veterinarian == null){
            System.out.println("Veterinarian not found!");
        }
        for(Pet p : pets_fromDb){
            if(p.getName().equalsIgnoreCase(petName)){
                pet = p;
                break;
            }
        }
        if(pet == null){
            System.out.println("Pet not found!");
            return;
        }
        if(!veterinarian.canTreat(pet)){
            System.out.println("Veterinarian "+veterinarian.getName()+" can not treat "+pet.getSpecies()+" "+pet.getName()+"!");
            return;
        }//67 six seven hahahhaha
        Treatment treatment;
        if(type.equalsIgnoreCase("Vaccination")){
            System.out.println("Enter Vaccine name: \n");
            System.out.print(">>> ");
            String vaccineName = s.nextLine();
            treatment = new Vaccination(treatments.size()+1, owner, pet, veterinarian, status,  vaccineName);
            treatment.completeTreatment();
            owner.addLoyaltyPoints(20);
        }else if(type.equalsIgnoreCase("Surgery")){
            System.out.println("Enter Surgery duration in hours: \n");
            System.out.print(">>> ");
            int duration = s.nextInt();
            s.nextLine();
            treatment = new Surgery(treatments.size()+1, owner, pet, veterinarian, status,  duration);
            treatment.completeTreatment();
            owner.addLoyaltyPoints(25);
        }else{
            System.out.println("Invalid input! You haven't written the type of a treatment!");
            return;
        }
        treatments.add(treatment);
        System.out.println("New Treatment created successfully!");
    }
    private static void viewTreatments(){
        System.out.println("===== TREATMENT LIST =====");
        for(Treatment t : treatments){
            if(t instanceof Vaccination){
                Vaccination vaccination = (Vaccination)t;
                System.out.println("Vaccine: "+vaccination.getVaccineName());
            }
            if(t instanceof Surgery){
                Surgery surgery = (Surgery)t;
                System.out.println("Difficulcy: "+surgery.getDifficulcy());
            }
            if(t instanceof Treatment){
                System.out.println(t);
            }
            System.out.println("\n");
        }
    }
    private static void updateOwner(){
        System.out.println("Enter Owner's ID to update: ");
        int  ownerId = s.nextInt();
        s.nextLine();
        Owner existingOwner = owners_fromDb.get(ownerId-1);
        if(existingOwner == null){
            System.out.println("Owner not found!");
            return;
        }
        System.out.println("Current owner's info: "+existingOwner.toString());
        System.out.println("New name: ["+existingOwner.getName()+"]");
        System.out.println("Enter new name: ");
        System.out.print(">>> ");
        String newName = s.nextLine();
        if(newName.trim().isEmpty()){
            newName = existingOwner.getName();
        }
        System.out.println("New phone: ["+existingOwner.getPhone()+"]");
        System.out.println("Enter new phone number: ");
        System.out.print(">>> ");
        String newPhone = s.nextLine();
        if(newPhone.trim().isEmpty()){
            newPhone = existingOwner.getPhone();
        }
        Owner updatedOwner = new Owner(ownerId, newName, newPhone);
        ownerDAO.updateOwner(updatedOwner);
    }
    public static void deleteOwner(){
        System.out.println("Enter Owner's ID to delete: ");
        int  ownerId = s.nextInt();
        s.nextLine();
        Owner existingOwner = owners_fromDb.get(ownerId-1);
        if(existingOwner == null){
            System.out.println("Owner not found!");
            return;
        }
        System.out.println("Current owner to delete: ");
        System.out.println(existingOwner.toString());

        System.out.println("Are you sure? (y/n)");
        String answer = s.nextLine();
        if(answer.equalsIgnoreCase("y")){
            ownerDAO.deleteOwner(existingOwner);

        }else{
            System.out.println("Deletion canceled!");
        }

    }
    public static void searchOwnerByName(){
        String ownerName = readSafeString("Enter Owner name: ");
        System.out.println(ownerDAO.searchOwnerByName(ownerName));
    }
    public static void searchOwnerByLoyaltyPoints(){
        int minLoyaltyPoints = readSafeInt("Enter minimum loyalty points: ");
        int maxLoyaltyPoints = readSafeInt("Enter maximum loyalty points: ");
        System.out.println(ownerDAO.searchOwnerByLoyaltyPointsRange(minLoyaltyPoints, maxLoyaltyPoints));
    }
    public static void searchOwnerByMinLoyaltyPoints(){
        int minLoyaltyPoints = readSafeInt("Enter loyalty points: ");
        System.out.println(ownerDAO.searchOwnerByMinLoyaltyPoints(minLoyaltyPoints));
    }

    public static void demonstratePolymorphism(){
        for(Treatment t : treatments){
            t.completeTreatment();
        }
    }

    public void run() {
        boolean running = true;
        while(running){
            displayMenu();
            int choice = s.nextInt();
            s.nextLine();
            switch(choice){
                case 1:
                    createOwner();
                    break;
                case 2:
                    if(owners_fromDb.isEmpty()){
                        System.out.println("No owner found!");
                    }else{
                        for(Owner o : owners_fromDb){
                            System.out.println(o);
                            System.out.println();
                        }
                    }
                    break;
                case 3:
                    createPets();
                    break;
                case 4:
                    if(pets_fromDb.isEmpty()){
                        System.out.println("No pets found!");
                    }else{
                        for(Pet p : pets_fromDb){
                            System.out.println(p);
                            System.out.println();
                        }
                    }
                    break;
                case 5:
                    createVeterinarians();
                    break;
                case 6:
                    if(vets_fromDb.isEmpty()){
                        System.out.println("No veterinarians found!");
                    }else{
                        for(Veterinarian v : vets_fromDb){
                            System.out.println(v);
                            System.out.println();
                        }
                    }
                    break;
                case 7:
                    createTreatments();
                    break;
                case 8:
                    viewTreatments();
                    break;
                case 9:
                    updateOwner();
                    break;
                case 10:
                    deleteOwner();
                    break;
                case 11:
                    searchOwnerByName();
                    break;
                case 12:
                    searchOwnerByLoyaltyPoints();
                    break;
                case 13:
                    searchOwnerByMinLoyaltyPoints();
                    break;
                case 14:
                    demonstratePolymorphism();
                    break;
                case 0:
                    System.out.println("It was trial mode, to use this program again");
                    System.out.println("You have to give 100 points to Dmitriy Rochshupkin from IT-2505");
                    System.out.println("Thank you for using this program!");
                    running = false;
                    break;
                default:
                    System.out.println("Wrong choice!");
                    break;
            }
            if(running){
                System.out.print("Press any key to continue...");
                s.nextLine();
            }
        }
        s.close();
    }

}
