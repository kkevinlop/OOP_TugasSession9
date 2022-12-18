package PetShop;

//Since it gonna implements Swimmer, so it should import swimmer for the package Interfaces
import Interfaces.Swimmer;

//This class extends Pet class, which means this class is a child class / subclass
public class Fish extends Pet implements Swimmer{
	private String water;

	//Constructors derived from the parent class with additional variable of this class.
	public Fish(String name, String type, String color, String ownership, String condition, Integer health, String water) {
		super(name, type, color, ownership, condition, health);
		this.water = water;
	}

	//Getter and Setter
	public String getWater() {
		return water;
	}
	
	public void setWater(String water) {
		this.water = water;
	}
	
	//Abstract method of the Swimmer interface from the Interfaces Package.
	@Override
	public void AbleTSwim() {
		System.out.println("The fish is swimming back and forth!!");
		
	}

	//Abstract method from the parent class to update the pet health
	@Override
	public int HealthCheckedUp() {
		int recovery = 0;
		if(this.getHealth() < 100) {
			recovery = this.getHealth() + 50;
		}
		
		while(recovery < 100) {
			recovery = recovery + 5;
		}

		
		return recovery;
	}

}
