package biz.craftware;

import biz.craftware.domain.farm.Animal;
import biz.craftware.domain.farm.Cattle;
import biz.craftware.domain.farm.Horse;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

public class CowDecoratorTest {



	Cattle createSampleCow(){
		Cattle cow = new Cattle(500, Cattle.Breed.ANGUS, Cattle.Color.STRIPED);
		cow.setName("Mucka");
		return cow;

	}

	@Test
	public void horseInChains(){
		//given
		Horse horse = new Horse();
		horse.setName("Benek");

		//when
		//TODO finish me
		Animal horseInChains = horse;

		//then
		assertThat(horseInChains.getName()).isEqualTo("Benek in chains");
		assertThat(horseInChains.makeSound()).isEqualTo("Ihaahaa, <clank> <clank>");

	}


	@Test
	public void cowInChains(){
		//given
		Cattle cow = createSampleCow();

		//when
		//TODO finish me
		Animal cowInChains = cow;

		//then
		assertThat(cowInChains.getName()).isEqualTo("Mucka in chains");
		assertThat(cowInChains.makeSound()).isEqualTo("Muuuuuuuuuu, <clank> <clank>");

	}

	@Test
	public void cowInChainsAndLogging(){
		//given
		Cattle cow = createSampleCow();
		Queue<String> queue = new LinkedList<>();

		//when
		//TODO finish me
		Animal cowInChains = cow;

		//then
		assertThat(cowInChains.getName()).isEqualTo("Mucka in chains");
		assertThat(cowInChains.makeSound()).isEqualTo("Muuuuuuuuuu, <clank> <clank>");
		assertThat(queue.poll()).isEqualTo("Mucka in chains was called");
	}
}
