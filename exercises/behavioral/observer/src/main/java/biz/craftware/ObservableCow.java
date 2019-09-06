package biz.craftware;

import biz.craftware.domain.farm.Cattle;

public class ObservableCow extends Cattle {
	public ObservableCow(int weight, String name) {
		super(weight, Sex.COW);
		setName(name);
	}
}
