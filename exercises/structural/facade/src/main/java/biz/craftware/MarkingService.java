package biz.craftware;

import biz.craftware.domain.farm.Cattle;
import biz.craftware.domain.farm.Horse;

public interface MarkingService {

	void markCow(Cattle cattle);

	void mark(Horse horse);
}
