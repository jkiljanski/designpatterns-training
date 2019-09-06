package biz.craftware;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Component
@Scope("prototype")
public class SortingService {

	List<CowWithSlowOperations> cows = new LinkedList<>();


	public void register(CowWithSlowOperations cowWithSlowOperations) {
		cows.add(cowWithSlowOperations);
	}

	public Set<String> getNamesOfCowsWithWeight(Predicate<Integer> weightPredicate) {

		return cows.stream()
				.filter(cow -> weightPredicate.test(cow.getWeight()))
				.map(cowWithSlowOperations -> cowWithSlowOperations.getName())
				.collect(Collectors.toSet());
	}

}
