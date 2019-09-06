package biz.craftware;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


public class MathCalculationTest extends PatternsSpringTest{

	@Autowired
	private Calculator calculator;
	
	@DataProvider
	private Object[][] mathInputWithResult(){
		return new Object[][]{
				{generateMap(map("a", 5), map("b", 3), map("c", 6)), 13},
				{generateMap(map("a", 1), map("b", 2), map("c", 8)), -2}
		};
	}

	@Test(dataProvider = "mathInputWithResult")
	public void calculateExpressionWithSampleValues(Map<String, Integer> values, int expectedResult){
		//given
		MathExpression expression = null;

		//when
		int result = calculator.calculate(expression, values);

		//then
		assertThat(result).isEqualTo(expectedResult);
		assertThat(expression.getNotation()).isEqualTo("(a*b)-(c/b)");

	}

	private static class Pair{
		String key;
		int value;

		private Pair(String key, int value) {
			this.key = key;
			this.value = value;
		}

	}

	public static Pair map(String key, int value){
		return new Pair(key, value);
	}

	private static Map<String, Integer> generateMap(Pair... pairs){
		return Stream.of(pairs).collect(Collectors.toMap(pair -> pair.key, pair -> pair.value));
	}
}
