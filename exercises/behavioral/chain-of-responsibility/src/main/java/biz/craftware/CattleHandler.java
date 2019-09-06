package biz.craftware;

import biz.craftware.domain.farm.Cattle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CattleHandler {

	private final CattleRegistration cattleRegistration;

	@Autowired
	public CattleHandler(CattleRegistration cattleRegistration) {
		this.cattleRegistration = cattleRegistration;
	}


	public void handleCow(Cattle cattle){
		cattleRegistration.registerCowForMeat(cattle);
	}
}
