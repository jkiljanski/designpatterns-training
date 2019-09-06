package biz.craftware;

import biz.craftware.domain.farm.*;
import biz.craftware.domain.farm.Secret;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FarmInspectionTest {

	private Farm prepareFarm(){

		Farm farm = new Farm("Southpark");
		farm.add(new Cattle(600, Cattle.Sex.BULL));
		farm.add(new Cattle(700, Cattle.Sex.BULL));
		farm.add(new Cattle(400, Cattle.Sex.COW));
		farm.add(new Cattle(300, Cattle.Sex.COW));
		farm.add(new Cattle(20, Cattle.Sex.COW));

		farm.add(new Horse(400));
		farm.add(new Horse(50));

		farm.setTractor(new Tractor("Ursus", 200));

		farm.setSecret(
				new Secret("door", 40)
						.add(
								new Secret("Wall", 0),
								new Secret("Elevator", 2000)
									.add(
											new Secret("Meth lab", 1000000),
											new Secret("Startrek", 1000000000)
									)
						)
		);

		return farm;

	}

	@Test
	public void prepareStandardReport(){
		//given

		DEAVisitor visitor = new DEAVisitor();
		Farm farm = prepareFarm();

		//when
		//TODO call visitor on farm

		//then
		assertThat(visitor.getReport()).isEqualTo(
				"Farm in Southpark: 2 Bulls, 3 cows (2 adult), 2 Horses (1 adult), Ursus tractor");
	}

	@Test
	public void prepareDEAReport(){
		//given

		DEAVisitor visitor = new DEAVisitor();
		Farm farm = prepareFarm();

		//when
		//TODO call visitor on farm

		//then
		assertThat(visitor.getReport()).isEqualTo(
				"ATTENSION! Found something big: Meth Lab!");
	}


	@Test
	public void prepareEasyToFullDEAReport(){
		//given

		DEAVisitor visitor = new EasyToFullDEAVisitor();
		Farm farm = prepareFarm();

		//when
		//TODO call visitor on farm

		//then
		assertThat(visitor.getReport()).isEqualTo(
				"Nothing suspicious found");
	}

}
