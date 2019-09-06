package biz.craftware;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LazyCowWithCommandsTest {

	@Test
	public void orderCowboyToDoThingsWithCow(){
		//given

		LazyCow cow = new LazyCow(500);
		Cowboy cowboy = new Cowboy(cow);
		//when
		cowboy.feed();
		cowboy.makeItRun();
		cowboy.water();
		cowboy.makeItRun();
		cowboy.askToPoo();

		//then
		assertThat(cow.getWeight()).isEqualTo(500);
		cow.doSomething(); //will eat
		assertThat(cow.getWeight()).isEqualTo(520);
		cow.doSomething(); //will run
		assertThat(cow.getWeight()).isEqualTo(510);
		cow.doSomething(); //will drink
		assertThat(cow.getWeight()).isEqualTo(515);
		cow.doSomething(); //will run
		assertThat(cow.getWeight()).isEqualTo(505);
		cow.doSomething(); //will poo
		assertThat(cow.getWeight()).isEqualTo(500);


	}
}
