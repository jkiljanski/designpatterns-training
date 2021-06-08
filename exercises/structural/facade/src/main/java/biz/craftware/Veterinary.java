package biz.craftware;

import biz.craftware.domain.farm.Cattle;
import biz.craftware.domain.farm.Horse;

public interface Veterinary {

	void applyVaccine(Cattle cattle);

	void applyVaccine(Horse horse);
}
