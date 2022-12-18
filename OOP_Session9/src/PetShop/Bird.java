package PetShop;

//Since it gonna implements Fly, so it should import fly for the package Interfaces
import Interfaces.Fly;

//This class extends Pet class, which means this class is a child class / subclass
public class Bird extends Pet implements Fly{
	private String beak;

	//Constructors derived from the parent class with additional variable of this class.
	public Bird(String name, String type, String color, String ownership, String condition, Integer health, String beak) {
		super(name, type, color, ownership, condition, health);
		this.beak = beak;
	}

	//Getter and Setter
	public String getBeak() {
		return beak;
	}

	public void setBeak(String beak) {
		this.beak = beak;
	}

	//Abstract method of the Fly interface from the Interfaces Package.
	@Override
	public void AbleToFly() {
		System.out.println("Bird is celebrating !!");
		System.out.println("Birdy is flying and chirping around");
		
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
