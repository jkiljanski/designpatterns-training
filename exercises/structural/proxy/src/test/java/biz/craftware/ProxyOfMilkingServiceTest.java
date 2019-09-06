package biz.craftware;

import biz.craftware.domain.farm.Cattle;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProxyOfMilkingServiceTest extends PatternsSpringTest {

	@Autowired
	MilkingService milkingService;

	@Test
	public void shouldMilkCow() {
		//given
		Cattle cow = new Cattle(500, Cattle.Breed.ANGUS, Cattle.Color.STRIPED, Cattle.Sex.COW);
		//when
		int milkFromCow = milkingService.getMilkFromCow(cow);

		//then
		assertThat(milkFromCow).isEqualTo(5);

	}

	@Test(expectedExceptions = CannotMilkBullsException.class)
	public void shouldNotMilkBulls() {
		//given
		Cattle cow = new Cattle(500, Cattle.Breed.ANGUS, Cattle.Color.STRIPED, Cattle.Sex.BULL);
		//when
		int milkFromCow = milkingService.getMilkFromCow(cow);

		//then

	}

}
