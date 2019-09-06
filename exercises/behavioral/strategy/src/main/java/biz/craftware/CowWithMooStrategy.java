package biz.craftware;

public class CowWithMooStrategy {

	private String muuuSound;

	public CowWithMooStrategy(String muuuSound) {

		this.muuuSound = muuuSound;
	}

	public String makeSound(){
		return muuuSound;
	}

	public String makeSound(StrategyToMoo strategyToMoo) {
		return null;
	}
}
