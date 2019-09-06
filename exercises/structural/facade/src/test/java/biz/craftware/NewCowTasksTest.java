package biz.craftware;

import biz.craftware.domain.farm.Cattle;
import biz.craftware.domain.farm.Horse;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

public class NewCowTasksTest extends PatternsSpringTest{

	@Autowired
	IRSOffice irsOffice;

	@Autowired
	MarkingService markingService;

	@Autowired
	Veterinary veterinary;

	@Autowired
	MilkBuyer milkBuyer;

	@Test
	public void handleNewCow(){
		//given
		Cattle cow = new Cattle(500, Cattle.Breed.HOLSTEIN, Cattle.Color.STRIPED);

		//when
		//TODO notify services

		//then
		verify(irsOffice).applyVaccsine(cow);
		verify(markingService).markCow(cow);
		verify(veterinary).applyVaccsine(cow);
		verify(milkBuyer).registerNewCow(cow);
	}

	@Test
	public void handleNewHorse(){
		//given
		Horse horse = new Horse();

		//when
		//TODO notify services

		//then
		verify(irsOffice).applyVaccsine(horse);
		verify(markingService).markCow(horse);
		verify(veterinary).applyVaccsine(horse);
		verifyNoMoreInteractions(milkBuyer);
	}
}
