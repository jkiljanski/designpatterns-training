package biz.craftware;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FarmBuilderTest {

	@Test
	public void createsTinyFarmWithOneCow(){
		//given
		TinyFarmBuilder tinyFarmBuilder = TinyFarmBuilder.create();

		//when
		TinyFarm tinyFarm = tinyFarmBuilder
				.withAddress("Pszczew 44")
				.withSingleMilkCowNameAndWeight("zywicielka", 600)
				.build();

		//then
		assertThat(tinyFarm.getAddress()).isEqualTo("Pszczew 44");
		assertThat(tinyFarm.getMoneyBalance()).isEqualTo(1000);
		assertThat(tinyFarm.getCattle().getName()).isEqualTo("zywicielka");

	}

	@Test
	public void createsTwoFarmsButWithDifferentCows(){
		//given
		TinyFarmBuilder tinyFarmBuilder = TinyFarmBuilder.create();

		//when
		TinyFarm tinyFarm1 = tinyFarmBuilder
				.withSingleMilkCowNameAndWeight("zywicielka", 600)
				.build();
		TinyFarm tinyFarm2 = tinyFarmBuilder
				.withSingleMilkCowNameAndWeight("zywicielka", 600)
				.build();

		//then
		assertThat(tinyFarm1.getCattle()).isNotSameAs(tinyFarm2.getCattle());

	}
}
