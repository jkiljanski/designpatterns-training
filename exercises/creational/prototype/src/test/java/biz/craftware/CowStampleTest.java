package biz.craftware;

import biz.craftware.domain.farm.Cattle;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CowStampleTest {

	@Test
	public void shouldCreateManyCowsBasedOnOne(){
		//given
		Cattle originalCow = new CloneableCattle(456, Cattle.Breed.ANGUS, Cattle.Color.BROWN);
		originalCow.setName("Mucka");

		Stamp stamp = new Stamp(originalCow);

		//when
		List<Cattle> clones = stamp.produce(20);


		//then
		assertThat(clones)
				.hasSize(20)
				.allMatch(cattle -> Cattle.Breed.ANGUS.equals(cattle.getBreed()))
				.allMatch(cattle -> Cattle.Color.BROWN.equals(cattle.getColor()))
				.allMatch(cattle -> cattle.getWeight() == 456)
				.allMatch(cattle -> "clone of Mucka".equals(cattle.getName()));

	}
}
