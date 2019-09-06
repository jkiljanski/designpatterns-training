package biz.craftware;

import biz.craftware.domain.farm.Farm;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateFarmTest extends PatternsSpringTest{

	@Autowired
	FarmFactory farmFactory;

	@Test
	public void createsSmallFarm(){
		//given

		//when
		Farm farm = farmFactory.createSmallFarm("Pcim 123");

		//then
		assertThat(farm).isNotNull();
		assertThat(farm.getAddress()).isEqualTo("Pcim 123");
		assertThat(farm.getCattleHerd()).hasSize(2).allMatch(cattle -> cattle.getWeight()<300);
		assertThat(farm.getHorseHerd()).hasSize(1).allMatch(horse -> horse.getWeight()<400);
	}

	@Test
	public void createsHugeFarm(){
		//given

		//when
		Farm farm = farmFactory.createHugeFarm("Megaville");

		//then
		assertThat(farm).isNotNull();
		assertThat(farm.getAddress()).isEqualTo("Megaville");
		assertThat(farm.getCattleHerd()).hasSize(100).allMatch(cattle -> cattle.getWeight()>400);
		assertThat(farm.getHorseHerd()).hasSize(50).allMatch(horse -> horse.getWeight()>450);
	}

}
