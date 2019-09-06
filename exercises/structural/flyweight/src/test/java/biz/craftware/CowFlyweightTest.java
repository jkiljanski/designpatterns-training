package biz.craftware;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CowFlyweightTest extends PatternsSpringTest {

	@Autowired
	SortingService sortingService;

	@Test(timeOut = 1000)
	public void heavyCalculationsOnCows() {
		//given

		sortingService.register(new CowWithSlowOperations("big", 700));
		sortingService.register(new CowWithSlowOperations("medium", 600));
		sortingService.register(new CowWithSlowOperations("tiny", 150));
		sortingService.register(new CowWithSlowOperations("small", 200));

		List<String> entries = new LinkedList<>();

		//when

		//then
		assertThat(sortingService.getNamesOfCowsWithWeight(i -> i > 100)).containsOnly("big", "medium", "tiny", "small");
		assertThat(sortingService.getNamesOfCowsWithWeight(i -> i > 650)).containsOnly("big");
		assertThat(sortingService.getNamesOfCowsWithWeight(i -> i > 170 && i < 650)).containsOnly("medium", "small");

	}
}
