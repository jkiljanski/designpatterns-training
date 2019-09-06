package biz.craftware.domain.shipping;

public class Parcel {

	private final int weight;
	private final String label;
	private final Size size;

	public Parcel(int weight, String label, Size size) {
		this.weight = weight;
		this.label = label;
		this.size = size;
	}

	public String knockKnock(){
		return "<nothing>";
	}

	public enum Size{
		SMALL, MEDIUM, LARGE, HUGE;
	}

	public int getWeight() {
		return weight;
	}

	public String getLabel() {
		return label;
	}

	public Size getSize() {
		return size;
	}

}
