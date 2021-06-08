package biz.craftware;

import biz.craftware.domain.farm.Animal;
import biz.craftware.domain.farm.Cattle;
import biz.craftware.domain.farm.Horse;

public interface IRSOffice {

	void applyVaccine(Cattle cattle);

	void applyVaccine(Horse horse);
}
