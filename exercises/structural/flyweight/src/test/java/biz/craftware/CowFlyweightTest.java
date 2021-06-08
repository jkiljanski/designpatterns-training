package biz.craftware;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CowFlyweightTest extends PatternsSpringTest {

    @Autowired
    SortingService sortingService;

    @Timeout(1)
    @Test
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
