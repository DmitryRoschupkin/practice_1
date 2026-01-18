package practice_1.menu;

import practice_1.exceptions.IllegalArgumentException;
import practice_1.models.*;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuManager implements Menu {
    private static ArrayList<Owner> owners = new ArrayList<Owner>();
    private static ArrayList<Veterinarian> veterinarians = new ArrayList<Veterinarian>();
    private static ArrayList<Treatment> treatments = new ArrayList<>();

    private static Scanner s = new Scanner(System.in);

    public static boolean isValid(String input){
        return !input.isEmpty();
    }

    public static boolean isValid(int input){
        return input > 0;
    }

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
        System.out.println("9. Polymorphism demo");
        System.out.println("0. Exit");
        System.out.println("\n=====================================");
        System.out.println("Enter your choice:\n");
        System.out.print(">>> ");
    }

    private static void createOwner() {
        try {
            System.out.println("Enter Owner's name: \n");
            System.out.print(">>> ");
            String name = s.nextLine();
            while(!isValid(name)){
                System.out.print(">>> ");
                name = s.nextLine();
            }
            System.out.println("Enter Owner's phone number: \n");
            System.out.print(">>> ");
            String phone = s.nextLine();
            while(!isValid(phone)){
                System.out.print(">>> ");
                phone = s.nextLine();
            }
            Owner owner = new Owner(owners.size() + 1, name, phone);
            owners.add(owner);
            System.out.println("New Owner created successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error! Invalid input! "+e.getMessage());
        }
    }
    private static void createPets(){
        try {
            System.out.println("Enter Pet's name: \n");
            System.out.print(">>> ");
            String name = s.nextLine();
            while(!isValid(name)){
                System.out.print(">>> ");
                name = s.nextLine();
            }
            System.out.println("Enter Pet's species: \n");
            System.out.print(">>> ");
            String species = s.nextLine();
            while(!isValid(species)){
                System.out.print(">>> ");
                species = s.nextLine();
            }
            System.out.println("Enter Pet's age: \n");
            System.out.print(">>> ");
            int age = s.nextInt();
            s.nextLine();
            while(!isValid(age)){
                System.out.print(">>> ");
                age = s.nextInt();
                s.nextLine();
            }
            System.out.println("Enter Pet's owner: \n");
            System.out.print(">>> ");
            String ownerName = s.nextLine();
            while(!isValid(ownerName)){
                System.out.print(">>> ");
                ownerName = s.nextLine();
            }
            Owner owner = null; // we have to find owner
            for(Owner o : owners){
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
        } catch (IllegalArgumentException e) {
            System.out.println("Error! Invalid input! "+e.getMessage());
        }
    }
    private static void createVeterinarians(){
        try {
            System.out.println("Enter Veterinarian's name: \n");
            System.out.print(">>> ");
            String name = s.nextLine();
            System.out.println("Enter Veterinarian's specialization: \n");
            System.out.print(">>> ");
            String specialization = s.nextLine();
            System.out.println("Enter Veterinarian's experience: \n");
            System.out.print(">>> ");
            int experience = s.nextInt();
            s.nextLine();
            System.out.println("Enter Veterinarian's phone number: \n");
            System.out.print(">>> ");
            String phone = s.nextLine();
            Veterinarian veterinarian = new Veterinarian(veterinarians.size() + 1, name, specialization, experience, phone);
            veterinarians.add(veterinarian);
            System.out.println("New Veterinarian created successfully!");
        }catch(IllegalArgumentException e){
                System.out.println("Error! "+e.getMessage());
        }
    }
    private static void createTreatments(){
        try {
            System.out.println("Enter Treatment's owner's name: \n");
            System.out.print(">>> ");
            String ownerName = s.nextLine();
            System.out.println("Enter Treatment's veterinar: \n");
            System.out.print(">>> ");
            String veterinarianName = s.nextLine();
            System.out.println("Enter Treatment's pet's name: \n");
            System.out.print(">>> ");
            String petName = s.nextLine();
            System.out.println("Enter Treatment's status: \n");
            System.out.print(">>> ");
            String status = s.nextLine();
            System.out.println("Enter Treatment's type: \n");
            System.out.print(">>> ");
            String type = s.nextLine();
            Owner owner = null;
            Veterinarian veterinarian = null;
            Pet pet = null;

            for(Owner o : owners){
                if(o.getName().equalsIgnoreCase(ownerName)){
                    owner = o;
                    break;
                }
            }
            if(owner == null){
                System.out.println("Owner not found!");
                return;
            }
            for(Veterinarian v : veterinarians){
                if(v.getName().equalsIgnoreCase(veterinarianName)){
                    veterinarian = v;
                    break;
                }
            }
            if(veterinarian == null){
                System.out.println("Veterinarian not found!");
            }
            for(Pet p : owner.getPets()){
                if(p.getName().equalsIgnoreCase(petName)){
                    pet = p;
                    break;
                }
            }
            if(pet == null){
                System.out.println("Pet not found!");
            }
            Treatment treatment;
            if(type.equalsIgnoreCase("Vaccination")){
                System.out.println("Enter Vaccine name: \n");
                System.out.print(">>> ");
                String vaccineName = s.nextLine();
                treatment = new Vaccination(treatments.size()+1, owner, pet, veterinarian, status,  vaccineName);
            }else if(type.equalsIgnoreCase("Surgery")){
                System.out.println("Enter Surgery duration in hours: \n");
                System.out.print(">>> ");
                int duration = s.nextInt();
                s.nextLine();
                treatment = new Surgery(treatments.size()+1, owner, pet, veterinarian, status,  duration);
            }else{
                System.out.println("Invalid input! You haven't written the type of a treatment!");
                return;
            }
            treatments.add(treatment);
            System.out.println("New Treatment created successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error! "+e.getMessage());
        }
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
                    for(Owner o : owners){
                        System.out.println(o.toString());
                        System.out.println("\n");
                    }
                    break;
                case 3:
                    createPets();
                    break;
                case 4:
                    for(Owner o : owners){
                        for(Pet p:o.getPets()){
                            System.out.println(p.toString());
                            System.out.println("\n");
                        }
                    }
                    break;
                case 5:
                    createVeterinarians();
                    break;
                case 6:
                    for(Veterinarian v : veterinarians){
                        System.out.println(v.toString());
                        System.out.println("\n");
                    }
                    break;
                case 7:
                    createTreatments();
                    break;
                case 8:
                    viewTreatments();
                    break;
                case 9:
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
