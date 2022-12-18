package Main;

/*
 The purpose of this program is for the Pet Clinic & Shop convenience;
 This program helps the Clinic to know the list of every Customer and Clinic's Pet.
 This allows the customer to be able to adopt a pet if the wanted.
 And also to cure their own pet to the clinic.
*/

//import the parent class and subclass from the different package
import PetShop.Pet;
import PetShop.Bird;
import PetShop.Fish;
import PetShop.Kitten;
import PetShop.Rabbit;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	// Scanner for inputting and ArrayList to store the list of every pet
	Scanner scan = new Scanner(System.in);
	ArrayList<Pet> petList = new ArrayList<>();
	
	public void Menu() {
		System.out.println("===========================");
		System.out.println("Dreams Pet Clinic & Shop ");
		System.out.println("===========================");
		System.out.println("1. Add new Pet");
		System.out.println("2. View Pet");
		System.out.println("3. Adopt Pet");
		System.out.println("4. Treat Pet");
		System.out.println("5. Exit");
		System.out.println("===========================");
		System.out.print(">>");
	}
	
	private void addPet() {
		// for initialize value of each variable
		String name = "", type = "", color = "", ownership = "", claw = "", ear = "", water = "", beak = "", condition = "";
		Integer health = 0;
		
		do {
			System.out.print("Input pet name [2-25 characters] (inclusive): ");
			name = scan.nextLine();
		}while(name.length() < 2 || name.length() > 25);
		
		do {
			System.out.print("Input pet type [Kitten | Rabbit | Fish | Bird] (case sensitive): ");
			type = scan.nextLine(); 
		}while(!(type.contains("Kitten") || type.contains("Rabbit") || type.contains("Fish") || type.contains("Bird")));
		
		if(type.equals("Kitten") || type.equals("Rabbit")) {
			do {
				System.out.print("Input the dominant color of the pet [white | black | brown ] (case sensitive): ");
				color = scan.nextLine();
			}while(!(color.contains("white") || color.contains("black") || color.contains("brown")));
		}else if (type.equals("Fish") || type.equals("Bird")) {
			do {
				System.out.print("Input the dominant color of the pet [White | Black | Red | Green | Blue] (case sensitive): ");
				color = scan.nextLine();
			}while(!(color.contains("White") || color.contains("Black") || color.contains("Red") || color.contains("Green") || color.contains("Blue")));
		}
		
		do {
			System.out.print("Input the pet's ownership [Customer | Clinic] (case sensitive): ");
			ownership = scan.nextLine();
		}while(!(ownership.contains("Customer") || ownership.contains("Clinic")));
		
		//Customer's pet can be either healthy or unhealthy. This part will be used on treatPet() function.
		if(ownership.equals("Customer")) {
			do {
				System.out.print("Input the condition of pet [Healthy | Unhealthy] (case sensitive): ");
				condition = scan.nextLine();
			}while(!(condition.contains("Healthy") || condition.contains("Unhealthy")));
			
			if(condition.equals("Unhealthy")) {
				do {
					System.out.print("Input the sick pet health [1-50] (inclusive): ");
					health = scan.nextInt(); scan.nextLine();
				}while(health < 1 || health > 100);
			}else if(condition.equals("Healthy")){
				health = 100;
			}
		// Clinic's pet is assumed as healthy since it is taken with good care.
		}else if(ownership.equals("Clinic")) {
			condition = "Healthy";
			health = 100;
		}
		
		// This part is about the unique characteristics/traits for each pet.
		 if(type.equals("Kitten")) {
			 do {
				 System.out.print("Input the length of claw [Long | Short] (case sensitive): ");
				 claw = scan.nextLine();
			 }while(!(claw.contains("Long") || claw.contains("Short")));
			 
			 //creating object (implementation of previous lesson) and add it to the ArrayList
			 Pet meow = new Kitten(name, type, color, ownership, condition, health, claw);
			 petList.add(meow);
		 }else if(type.equals("Rabbit")) {
			 do {
				 System.out.print("Input the length of ear [Long-Fall | Short-Lobe] (case sensitive): ");
				 ear = scan.nextLine();
			 }while(!(ear.contains("Long-Fall") || ear.contains("Short-Lobe")));
			 
			  Pet cluck = new Rabbit(name, type, color, ownership, condition, health, ear);
			  petList.add(cluck);
		 }else if(type.equals("Fish")) {
			 do {
				 System.out.print("Input the water that suits the fish [Sea Water | Fresh Water] (case sensitive): ");
				 water = scan.nextLine();
			 }while(!(water.contains("Sea Water") || water.contains("Fresh Water")));
			 
			 Pet blup = new Fish(name, type, color, ownership, condition, health, water);
			 petList.add(blup);
		 }else if(type.equals("Bird")) {
			 do {
				 System.out.print("Input the length of beak [Long-Thick | Short-Sharp] (case sensitive): ");
				 beak = scan.nextLine();
			 }while(!(beak.contains("Long-Thick") || beak.contains("Short-Sharp")));
			 
			 Pet chirp = new Bird(name, type, color, ownership, condition, health, beak);
			 petList.add(chirp);
		 }
		
		System.out.println();
		System.out.println("New pet friends has been added !!! ");
		System.out.println("Press enter to continue"); scan.nextLine();

	}

	private void viewPet() {
		//This function is being use to see every list of the pet, 
		
		// If the ArrayList is empty, then gonna show the below message.
		if(petList.isEmpty()) {
			System.out.println("Currently there is no pet");
			System.out.println("Press enter to continue"); scan.nextLine();
			return;
		}
		
		int i = 0;
		
		System.out.println("======================================================================================================");
		System.out.printf("|%-3s |%-26s | %-10s |%-10s |%-10s |%-15s |%-5s |%-10s |%-15s |%-15s |%-15s |", "No", "Name", "Type", "Color", "Ownership", "Condition", "Health", "Claw", "Ear", "Water", "Beak");
		System.out.println("======================================================================================================");
		
		for(Pet p : petList) {
			i = i + 1;
			
			if( p instanceof Kitten) {
				System.out.printf("|%-3d |%-26s | %-10s |%-10s |%-10s |%-15s |%-5d |%-10s |%-15s |%-15s |%-15s |", 
						i, p.getName(), p.getType(), p.getColor(), p.getOwnership(), p.getCondition(), p.getHealth(), ((Kitten)p).getClaw(), "-", "-", "-");
			}else if( p instanceof Rabbit) {
				System.out.printf("|%-3d |%-26s | %-10s |%-10s |%-10s |%-15s |%-5d |%-10s |%-15s |%-15s |%-15s |", 
						i, p.getName(), p.getType(), p.getColor(), p.getOwnership(), p.getCondition(), p.getHealth(), "-", ((Rabbit)p).getEar(), "-", "-");
			}else if(p instanceof Fish) {
				System.out.printf("|%-3d |%-26s | %-10s |%-10s |%-10s |%-15s |%-5d |%-10s |%-15s |%-15s |%-15s |", 
						i, p.getName(), p.getType(), p.getColor(), p.getOwnership(), p.getCondition(), p.getHealth(), "-", "-", ((Fish)p).getWater(), "-");
			}else if(p instanceof Bird) {
				System.out.printf("|%-3d |%-26s | %-10s |%-10s |%-10s |%-15s |%-5d |%-10s |%-15s |%-15s |%-15s |", 
						i, p.getName(), p.getType(), p.getColor(), p.getOwnership(), p.getCondition(), p.getHealth(), "-", "-", "-", ((Bird)p).getBeak());
			}
		}
		System.out.println("======================================================================================================");
		
	}

	private void adoptPet() {
		if(petList.isEmpty()) {
			viewPet();
		}
		
		viewPet();
		int chosenPet;
		String option, newName;
		boolean owner = false;
		
		do {
			System.out.print("Choose pet that wanted to be adopted [1-" + petList.size() + "]: ");
			chosenPet = scan.nextInt(); scan.nextLine();
			
			// Check whether it is Customer's or not cause customer's pet cannot be adopted.
			if(petList.get(chosenPet-1).getOwnership().equals("Customer")) {
				owner = false;
				System.out.println("Please choose the Clinic Pet!");
			}else if(petList.get(chosenPet-1).getOwnership().equals("Clinic")){
				owner = true;
			}
			
		}while(chosenPet < 1 || chosenPet > petList.size() || owner == false);
		
		Pet Adopted = petList.get(chosenPet-1);
		
		//Since it is adopted, customer may wanted to change it's name that is given by the clinic.
		do {
			System.out.print("Do you want to change the name of the pet [Yes/No] (case insensitive): ");
			option = scan.nextLine();
		}while(!(option.equalsIgnoreCase("Yes") || option.equalsIgnoreCase("No")));
		
		if(option.equalsIgnoreCase("Yes")){
			do {
				System.out.print("Input new name for the pet [2-25 characters] (inclusive): ");
				newName = scan.nextLine();
			}while(newName != Adopted.getName() || newName.length() < 2 || newName.length() > 25);
			
			Adopted.setName(newName);
		}
		
		// Gonna display the changing of ownership and name if changed. 
		
		System.out.println();
		System.out.println("Previous Ownership : " + Adopted.getOwnership()); 
		System.out.println();
		
		Adopted.setOwnership("Customer");
		System.out.println("Name               : " + Adopted.getName());
		System.out.println("Color              : " + Adopted.getColor());
		if(Adopted instanceof Kitten) {
			// The usage of interface to show the method that is unique for each pet
			((Kitten)Adopted).AbleToRun();
			System.out.println("Claw               : " + ((Kitten)Adopted).getClaw());
		}else if(Adopted instanceof Rabbit) {
			((Rabbit)Adopted).AbleToRun();
			System.out.println("Ear                : " + ((Rabbit)Adopted).getEar());
		}else if(Adopted instanceof Fish) {
			((Fish)Adopted).AbleTSwim();
			System.out.println("Water              : " + ((Fish)Adopted).getWater());
		}else if(Adopted instanceof Bird) {
			((Bird)Adopted).AbleToFly();
			System.out.println("Beak               : " + ((Bird)Adopted).getBeak());
		}
		System.out.println("Updated Ownership  : " + Adopted.getOwnership());
		System.out.println(" Hope u treated it well !!");
		
		// gonna remove the adopted Pet from the list
		petList.remove(chosenPet-1); scan.nextLine();
	}

	private void treatPet() {
		if(petList.isEmpty()) {
			viewPet();
		}
		
		viewPet();
		int sickPet = 0, becomeHealthy = 0;
		boolean owner = false;
		
		do {
			System.out.println("Choose the pet to be treated [1-" + petList.size() + "]: ");
			sickPet = scan.nextInt(); scan.nextLine();
			
			//Check whether the pet is Clinis's or not. Cause clinic's pet is assumed to be healthy.
			// So the treated pet only if it is the customer's pet
			if(petList.get(sickPet-1).getOwnership().equals("Clinic")) {
				owner = false;
				System.out.println("Please choose the Customer Pet!");
			}else if(petList.get(sickPet-1).getOwnership().equals("Customer")){
				owner = true;
			}
		}while(sickPet < 1 || sickPet > petList.size() || owner == false);
		
		Pet curePet = petList.get(sickPet-1);
		
		// To Display the previous health condition
		System.out.println();
		System.out.println("Previous Condition : " + curePet.getCondition());
		System.out.println("Previous Health    : " + curePet.getHealth());
		System.out.println();
		
		if(curePet instanceof Kitten) {
			// If the Pet is unhealthy then it is will be cured using the abstract method  of HealthCheckedUp()
			if(curePet.getCondition().equals("Unhealthy")){
				becomeHealthy = ((Kitten)curePet).HealthCheckedUp();
				((Kitten)curePet).setHealth(becomeHealthy);
				curePet.setCondition("Healthy");
				System.out.println("Kitten has been cured! It is meowing happily right now");
			
			// If the pet is healthy, show that the pet is in good condition.
			}else if(curePet.getCondition().equals("Healthy")) {
				System.out.println("Kitten is in healthy condition");
			}
		}else if(curePet instanceof Rabbit) {
			if(curePet.getCondition().equals("Unhealthy")){
				becomeHealthy = ((Rabbit)curePet).HealthCheckedUp();
				((Rabbit)curePet).setHealth(becomeHealthy);
				System.out.println("Rabbit has been cured! It is clucking happily right now");
			}else if(curePet.getCondition().equals("Healthy")) {
				System.out.println("Rabbit is in healthy condition");
			}
		}else if(curePet instanceof Fish) {
			if(curePet.getCondition().equals("Unhealthy")){
				becomeHealthy = ((Fish)curePet).HealthCheckedUp();
				((Fish)curePet).setHealth(becomeHealthy);
				System.out.println("Fish has been cured! It is bluping happily right now");
			}else if(curePet.getCondition().equals("Healthy")) {
				System.out.println("Fish is in healthy condition");
			}
		}else if(curePet instanceof Bird) {
			if(curePet.getCondition().equals("Unhealthy")){
				becomeHealthy = ((Bird)curePet).HealthCheckedUp();
				((Bird)curePet).setHealth(becomeHealthy);
				System.out.println("Bird has been cured! It is chirping happily right now");
			}else if(curePet.getCondition().equals("Healthy")) {
				System.out.println("Bird is in healthy condition");
			}
		}
		
		// Display the update condition and health of the pet.
		System.out.println("Name               : " + curePet.getName());
		System.out.println("Update Condition   : " + curePet.getCondition());
		System.out.println("Update Health      : " + curePet.getHealth());
		
		//After being cured, the remove from the List.
		petList.remove(sickPet-1); scan.nextLine();
		
	}
	
	public Main() {
		int select = 0;
		System.out.println("Meow, Cluck, Blup, Chirp ! Welcome to Dreams Pet Clinic & Shop");
		
		//To choose the wanted menu as long as not exit. If choose exit, the program will be closed.
		do {
			Menu();
			select = scan.nextInt(); scan.nextLine();
			
			switch(select) {
			case 1 :{
				addPet(); break;
			}
			case 2 : {
				viewPet(); break;
			}
			case 4 : {
				adoptPet(); break;
			}
			case 5 : {
				treatPet(); break;
			}
			default:{
				System.out.println("Thank you for using Dreams Pet Clinic & Shop");
				break;
			}
			}
			
		}while(select !=5);
	}


	public static void main(String[] args) {
		new Main();

	}

}
