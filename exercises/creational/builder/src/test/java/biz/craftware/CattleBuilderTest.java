package biz.craftware;

import biz.craftware.domain.farm.Cattle;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CattleBuilderTest {

	@Test
	public void createsDefaultCow(){
		//given
		CattleBuilder cattleBuilder = CattleBuilder.create();

		//when
		Cattle cattle = cattleBuilder.build();

		//then
		assertThat(cattle)
				.hasFieldOrPropertyWithValue("weight", 500)
				.hasFieldOrPropertyWithValue("sex", Cattle.Sex.COW)
				.hasFieldOrPropertyWithValue("breed", Cattle.Breed.ABONDANCE);

	}

	@Test
	public void createsTwoCowsWithIncrementNames(){
		//given
		CattleBuilder cattleBuilder = CattleBuilder.create();

		//when
		Cattle cow1 = cattleBuilder.build();
		Cattle cow2 = cattleBuilder.build();
		Cattle cow3 = cattleBuilder.with(Cattle.Breed.ANGUS).build();

		//then
		assertThat(cow1.getName()).isEqualTo("Mucka #1");
		assertThat(cow2.getName()).isEqualTo("Mucka #2");
		assertThat(cow1).isNotSameAs(cow2);

		assertThat(cow3.getName()).isEqualTo("Mucka #3");
		assertThat(cow3.getBreed()).isEqualTo(Cattle.Breed.ANGUS);

	}


	@Test
	public void createsSameCattleButBull(){
		//given
		CattleBuilder cattleBuilder = CattleBuilder.create();

		//when
		Cattle cattle = cattleBuilder
				.with(Cattle.Sex.BULL)
				.withWeight(800)
				.build();

		//then
		assertThat(cattle)
				.hasFieldOrPropertyWithValue("weight", 800)
				.hasFieldOrPropertyWithValue("sex", Cattle.Sex.BULL)
				.hasFieldOrPropertyWithValue("breed", Cattle.Breed.ABONDANCE);

	}
}
