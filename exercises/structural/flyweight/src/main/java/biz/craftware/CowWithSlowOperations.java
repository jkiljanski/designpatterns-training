package biz.craftware;

import biz.craftware.domain.farm.Cattle;

public class CowWithSlowOperations extends Cattle{

	public CowWithSlowOperations(String name, int weight) {
		super(weight, Breed.ANGUS, Color.STRIPED);
		setName(name);

	}

	@Override
	public int getWeight() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return super.getWeight();
	}
}
