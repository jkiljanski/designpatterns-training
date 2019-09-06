package biz.craftware.domain.farm;

public class Horse implements Animal{


	private int weight = 400;

	public Horse() {
	}

	public Horse(int weight) {
		this.weight = weight;
	}

	private String ownersMark;
	private String name;

	@Override
	public int getWeight() {
		return weight;
	}

	@Override
	public void markWithOwnersName(String mark) {

		ownersMark = mark;
	}

	@Override
	public String getOwnersMark() {
		return ownersMark;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String makeSound() {
		return "Ihaahaa";
	}
}
