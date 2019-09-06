package biz.craftware;

import biz.craftware.domain.farm.Cattle;

public interface CattleRegistration {

	void registerCowForBreed(Cattle cattle);
	void registerBullForBreed(Cattle cattle);
	void registerCowForMilk(Cattle cattle);
	void registerCowForMeat(Cattle cattle);
}
