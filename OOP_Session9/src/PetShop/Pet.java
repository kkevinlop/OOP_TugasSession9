package PetShop;

// Pet class is an abstract class as well as a parent class.
public abstract class Pet {
	private String name;
	private String type;
	private String color;
	private String ownership;
	private String condition;
	private Integer health;
	
	//Constructors for every variable
	public Pet(String name, String type, String color, String ownership, String condition, Integer health) {
		super();
		this.name = name;
		this.type = type;
		this.color = color;
		this.ownership = ownership;
		this.condition = condition;
		this.health = health;
	}
	
	//Getters and Setters of each variable
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getOwnership() {
		return ownership;
	}

	public void setOwnership(String ownership) {
		this.ownership = ownership;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public Integer getHealth() {
		return health;
	}

	public void setHealth(Integer health) {
		this.health = health;
	}
	
	// Abstract method that can be used for all sub classes.
	public abstract int HealthCheckedUp();
}
