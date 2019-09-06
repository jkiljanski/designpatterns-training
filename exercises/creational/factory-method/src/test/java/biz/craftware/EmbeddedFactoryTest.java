package biz.craftware;

import biz.craftware.domain.farm.Cattle;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EmbeddedFactoryTest {

	@Test
	public void createsBySimpleCall(){
		//given

		//when
		Cattle cattle = Cattle.createAnyCow();

		//then
		assertThat(cattle).isNotNull();

	}

	@Test
	public void createsByCallingNamedFactoryMethod(){
		//given

		//when
		Cattle cattle = Cattle.createBlackAngusBull(700);

		//then
		assertThat(cattle)
				.hasFieldOrPropertyWithValue("weight", 700)
				.hasFieldOrPropertyWithValue("sex", Cattle.Sex.BULL)
				.hasFieldOrPropertyWithValue("breed", Cattle.Breed.ANGUS);
	}

	@Test
	public void createsByCallingOtherNamedFactoryMethod(){
		//given

		//when

		Cattle cattle = Cattle.createStripedMilkCow(500);

		//then
		assertThat(cattle)
				.hasFieldOrPropertyWithValue("weight", 500)
				.hasFieldOrPropertyWithValue("sex", Cattle.Sex.COW)
				.hasFieldOrPropertyWithValue("breed", Cattle.Breed.HOLSTEIN);

	}

}
