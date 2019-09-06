package biz.craftware.breed;

import biz.craftware.domain.farm.Cattle;

public class Breeder {

	public Cattle breed(Cattle mother, AbstractCattleBuilder cattleBuilder){
		return cattleBuilder
				.with(mother.getBreed())
				.with(mother.getColor())
				.with(mother.getWeight())
				.withMotherName(mother.getName())
				.build();
	}
}
