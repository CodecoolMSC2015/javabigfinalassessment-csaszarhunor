package personStore;

public class Skill {

	private String name;
	private String description;
	private double rate;
	
	public Skill(String name, String description) {
		this.name = name;
		this.description = description;
	}

	@Override
	public String toString() {
		return name;
	}
	
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public double getRate() {
		return rate;
	}
	
	public void setRate(double rate) {
		this.rate = rate;
	}
	
}
