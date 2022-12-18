package PetShop;

//Since it gonna implements Runner, so it should import runner for the package interfaces
import Interfaces.Runner;

//This class extends Pet class, which means this class is a child class / subclass
public class Kitten extends Pet implements Runner{
	private String claw;
	
	//Constructors derived from the parent class with additional variable of this class.
	public Kitten(String name, String type, String color, String ownership, String condition, Integer health, String claw) {
		super(name, type, color, ownership, condition, health);
		this.claw = claw;
	}

	//Getter and Setter
	public String getClaw() {
		return claw;
	}

	public void setClaw(String claw) {
		this.claw = claw;
	}

	//Abstract method of the Runner interface from the Interfaces Package.
	@Override
	public void AbleToRun() {
		System.out.println("Kitten is really happy to be chosen!");
		System.out.println("Kitty is running around right now !");
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
