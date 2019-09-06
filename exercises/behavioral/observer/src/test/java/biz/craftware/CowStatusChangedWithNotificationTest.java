package biz.craftware;

import biz.craftware.observers.CowNameObserver;
import biz.craftware.observers.CowWeightObserver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CowStatusChangedWithNotificationTest {

	private CowWeightObserver cowWeightObserver;
	private CowNameObserver cowNameObserver;

	private ObservableCow observableCow;

	@BeforeMethod
	public void attachObservers(){
		cowWeightObserver = new CowWeightObserver();
		cowNameObserver = new CowNameObserver();
		observableCow = new ObservableCow(456, "Mucka");
	}

	@Test
	public void nothingHappens(){
		//given

		//when

		//then
		assertThat(cowWeightObserver.getLastObservation()).isEmpty();
		assertThat(cowNameObserver.getLastObservation()).isEmpty();

	}

	@Test
	public void weightChangedAndShouldOneObserverBeInformed(){
		//given
		observableCow.changeWeight(100);

		//when

		//then
		assertThat(cowWeightObserver.getLastObservation()).isEqualTo("Weight changed from 456 to 556");
		assertThat(cowNameObserver.getLastObservation()).isEmpty();

	}

	@Test
	public void nameChangedAndShouldOneObserverBeInformed(){
		//given
		observableCow.setName("Crazy Cow");

		//when

		//then
		assertThat(cowWeightObserver.getLastObservation()).isEmpty();
		assertThat(cowNameObserver.getLastObservation()).isEqualTo("Name changed from Mucka to Crazy Cow");

	}
}
