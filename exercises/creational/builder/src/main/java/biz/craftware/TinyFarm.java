package biz.craftware;

import biz.craftware.domain.farm.Cattle;

public class TinyFarm {

	private final String address;
	private final int moneyBalance;
	private final Cattle cattle;

	public TinyFarm(String address, int moneyBalance, Cattle cattle) {
		this.address = address;
		this.moneyBalance = moneyBalance;
		this.cattle = cattle;
	}

	public String getAddress() {
		return address;
	}

	public int getMoneyBalance() {
		return moneyBalance;
	}

	public Cattle getCattle() {
		return cattle;
	}
}
