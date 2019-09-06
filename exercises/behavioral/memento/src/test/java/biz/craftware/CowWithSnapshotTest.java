package biz.craftware;

import biz.craftware.domain.farm.Cattle;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CowWithSnapshotTest {

	@Test
	public void shouldGoThroughChangesAndBack(){
		//given
		List<CowSnapshot> cowSnapshots = new LinkedList<>();
		Cattle cow = new Cattle(200, Cattle.Sex.COW);
		cow.setName("small Cow");
		//when
		CowRecorder cowRecorder = new CowRecorder(cow);

		cowSnapshots.add(cowRecorder.createSnapshot());

		cow.changeWeight(150);
		cow.setName("bigger Cow");

		cowSnapshots.add(cowRecorder.createSnapshot());

		cow.changeWeight(100);
		cow.setName("huge Cow");

		//then
		assertThat(cow.getWeight()).isEqualTo(450);
		assertThat(cow.getName()).isEqualTo("huge Cow");

		cowRecorder.restore(cowSnapshots.get(1));
		assertThat(cow.getWeight()).isEqualTo(350);
		assertThat(cow.getName()).isEqualTo("bigger Cow");

		cowRecorder.restore(cowSnapshots.get(0));
		assertThat(cow.getWeight()).isEqualTo(200);
		assertThat(cow.getName()).isEqualTo("small Cow");
	}
}
