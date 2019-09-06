package biz.craftware;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ContinousIteratorTest {

	@Test
	public void iteratorWillProceedOverMultipleCollections(){
		//given

		List<Integer> list1 = Arrays.asList(1,2,3,4);
		List<Integer> list2 = Arrays.asList(5,6,7,8);

		//when
		MultiListIterator multiListIterator = new MultiListIterator(list1, list2);


		//then
		assertThat(multiListIterator).containsExactly(1, 2, 3, 4, 5, 6, 7, 8);
	}
}
