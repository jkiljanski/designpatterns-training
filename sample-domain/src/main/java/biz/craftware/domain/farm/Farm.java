package biz.craftware.domain.farm;

import java.util.HashSet;
import java.util.Set;

public class Farm {
	final String address;

	Set<Cattle> cattleHerd = new HashSet<>();

	Set<Horse> horseHerd = new HashSet<>();

	Tractor tractor;

	Secret secret;

	public Farm(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public Set<Cattle> getCattleHerd() {
		return cattleHerd;
	}

	public Set<Horse> getHorseHerd() {
		return horseHerd;
	}

	public Tractor getTractor() {
		return tractor;
	}

	public void setTractor(Tractor tractor) {
		this.tractor = tractor;
	}


	public void add(Cattle cattle) {
		cattleHerd.add(cattle);
	}

	public void add(Horse horse) {
		horseHerd.add(horse);
	}

	public void setSecret(Secret secret) {
		this.secret = secret;
	}
}
