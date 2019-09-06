package biz.craftware.domain.farm;

public class Cattle implements Animal{

	public enum Breed {ABONDANCE, ANGUS, HOLSTEIN, RANDALL, REDPOOL;}

	public enum Color {BLACK, BROWN, STRIPED;}

	public enum Sex {COW, BULL;}
	protected int weight;
	private final Breed breed;
	private final Color color;
	private final Sex sex;

	private String ownersMark;
	private String name;

	public Cattle(int weight, Breed breed, Color color) {
		this(weight, breed, color, Sex.COW);
	}
	public Cattle(int weight, Sex sex) {
		this(weight, Breed.ABONDANCE, Color.STRIPED, sex);
	}

	public Cattle(int weight, Breed breed, Color color, Sex sex) {
		this.weight = weight;
		this.breed = breed;
		this.color = color;
		this.sex = sex;
	}



	public static Cattle createAnyCow() {
		return null;
	}

	public static Cattle createBlackAngusBull(int  weight) {
		return null;
	}

	public static Cattle createStripedMilkCow(int weight) {
		return null;
	}

	@Override
	public int getWeight() {
		return weight;
	}

	@Override
	public void markWithOwnersName(String mark) {
		this.ownersMark = mark;
	}

	@Override
	public String getOwnersMark() {
		return ownersMark;
	}

	public Breed getBreed() {
		return breed;
	}

	public Color getColor() {
		return color;
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
	public String makeSound(){
		return "Muuuuuuuuuu";
	}

	public Sex getSex() {
		return sex;
	}

	public void changeWeight(int delta){
		weight += delta;
	}

	@Override
	public String toString() {
		return "Cattle{" +
				"weight=" + weight +
				", breed=" + breed +
				", color=" + color +
				", sex=" + sex +
				", ownersMark='" + ownersMark + '\'' +
				", name='" + name + '\'' +
				'}';
	}
}
