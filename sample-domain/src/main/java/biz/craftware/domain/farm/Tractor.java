package biz.craftware.domain.farm;

public class Tractor {

	private final String brand;
	private final int power;

	public Tractor(String brand, int power) {
		this.brand = brand;
		this.power = power;
	}

	public String engineSound(){
		return "bruuum";
	}
}
