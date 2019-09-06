package biz.craftware;

import biz.craftware.domain.farm.Cattle;
import biz.craftware.domain.farm.other.api.FarmInfoRepository;
import biz.craftware.hierarchical.NamingBullWithMarkFactory;
import biz.craftware.hierarchical.NamingCowWithMarkFactory;
import biz.craftware.hierarchical.UnanymousCowWithMarkFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.mockito.BDDMockito.given;

public class HierarchicalFactoriesTest extends PatternsSpringTest {

	@Autowired
	NamingCowWithMarkFactory namingCowWithMarkFactory;

	@Autowired
	NamingBullWithMarkFactory namingBullWithMarkFactory;

	@Autowired
	UnanymousCowWithMarkFactory unanymousCowWithMarkFactory;

	@Autowired
	private FarmInfoRepository farmInfoRepositoryMock;

	@Override
	public void beforeMethod(){
		given(farmInfoRepositoryMock.getOwnerSign()).willReturn("training sign");
	}


	@Test
	public void creates3CowsWithNamesAndMark(){
		//given

		given(farmInfoRepositoryMock.getOwnerSign()).willReturn("training sign");

		List<Cattle> cows = new LinkedList<>();

		//when
		cows.add(namingCowWithMarkFactory.create());
		cows.add(namingCowWithMarkFactory.create());
		cows.add(namingCowWithMarkFactory.create());

		//then
		assertThat(cows)
				.extracting("sex", "name", "ownersSign")
				.containsExactly(
						tuple(Cattle.Sex.COW, "mucka #1", "training sign"),
						tuple(Cattle.Sex.COW, "mucka #2", "training sign"),
						tuple(Cattle.Sex.COW, "mucka #3", "training sign")
				);

	}

	@Test
	public void creates3BullsWithNamesAndMark(){
		//given
		given(farmInfoRepositoryMock.getOwnerSign()).willReturn("training sign");
		List<Cattle> bulls = new LinkedList<>();

		//when
		bulls.add(namingBullWithMarkFactory.create());
		bulls.add(namingBullWithMarkFactory.create());
		bulls.add(namingBullWithMarkFactory.create());

		//then
		assertThat(bulls)
				.extracting("sex", "name", "ownersSign")
				.containsExactly(
						tuple(Cattle.Sex.BULL, "byk #1", "training sign"),
						tuple(Cattle.Sex.BULL, "byk #2", "training sign"),
						tuple(Cattle.Sex.BULL, "byk #3", "training sign")
				);

	}

	@Test
	public void creates3CowsWithoutNamesAndWithMark(){
		//given

		//when
		Cattle cow = unanymousCowWithMarkFactory.create();

		//then
		assertThat(cow)
				.hasFieldOrPropertyWithValue("sex", Cattle.Sex.COW)
				.hasFieldOrPropertyWithValue("ownersSign", "training sign")
				.hasFieldOrPropertyWithValue("name", null);

	}
}
