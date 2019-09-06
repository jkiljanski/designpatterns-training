package biz.craftware;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DifferentStylesOfMuuTest {


	@DataProvider
	public Object[][] strategiesToMoo(){
		return new Object[][]{
				{"Muuu", null, "Muuu"},
				{"Muuu", new NoOpStrategy(), "Muuu"},
				{"Muuu", new LoudStrategy(), "MUUU!!!"},
				{"MUUU", new SilentStrategy(), "mu"},
				{"Muuu!", new StammerStrategy(), "M... u... u... u... !"},

		};
	}


	@Test(dataProvider = "strategiesToMoo")
	public void shouldMooNormal(String whatDoesNormally, StrategyToMoo strategyToMoo, String expectedSound){
		//given
		CowWithMooStrategy cow = new CowWithMooStrategy(whatDoesNormally);

		//when
		String sound = cow.makeSound(strategyToMoo);

		//then
		assertThat(sound).isEqualTo(expectedSound);

	}
}
