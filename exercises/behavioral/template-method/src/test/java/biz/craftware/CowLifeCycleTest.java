package biz.craftware;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CowLifeCycleTest {
	
	@Test
	public void tellStoryAboutOrdinaryCow(){
		//given
		CowTellingStory cow = new OrdinaryCowTellingStory("Mucka");
		
		//when
		String dayStory = cow.sayAboutThisDay();

		//then
		assertThat(dayStory).isEqualTo("Hi! My name is Mucka. I am an ordinary Cow. I like to eat grass, that is why today I was grazing 3 times");
		
	}

	@Test
	public void tellStoryAboutCrazyCow(){
		//given
		CowTellingStory cow = new CrazyCowTellingStory("Crazy Cow");

		//when
		String dayStory = cow.sayAboutThisDay();

		//then
		assertThat(dayStory).isEqualTo("Hi! My name is Crazy Cow. I am nuts. I like to infect people, that is why today I infected them 10 times");

	}
}
