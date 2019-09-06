package biz.craftware.breed;

import biz.craftware.domain.farm.Cattle;

public abstract class AbstractCattleBuilder {
	public abstract AbstractCattleBuilder with(Cattle.Breed breed);

	public abstract AbstractCattleBuilder with(Cattle.Color color);

	public abstract AbstractCattleBuilder with(int weight);

	public abstract AbstractCattleBuilder withMotherName(String name);

	public abstract Cattle build();
}
