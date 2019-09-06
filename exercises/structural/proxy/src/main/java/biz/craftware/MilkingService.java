package biz.craftware;

import biz.craftware.domain.farm.Cattle;
import org.springframework.stereotype.Component;

@Component
public class MilkingService {

	public int getMilkFromCow(Cattle cattle){
		return cattle.getWeight()/100;
	}

}
