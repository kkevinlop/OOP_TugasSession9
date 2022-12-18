package PetShop;

//Since it gonna implements Runner, so it should import runner for the package interfaces
import Interfaces.Runner;

//This class extends Pet class, which means this class is a child class / subclass
public class Rabbit extends Pet implements Runner{
	private String ear;
	
	//Constructors derived from the parent class with additional variable of this class.
	public Rabbit(String name, String type, String color, String ownership, String condition, Integer health, String ear) {
		super(name, type, color, ownership, condition, health);
		this.ear = ear;
	}

	//Getter and Setter
	public String getEar() {
		return ear;
	}

	public void setEar(String ear) {
		this.ear = ear;
	}

	//Abstract method of the Runner interface from the Interfaces Package.
	@Override
	public void AbleToRun() {
		System.out.println("Rabbit is excited to be chosen!");
		System.out.println("Bunny is running & hopping around right now !");
		
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
