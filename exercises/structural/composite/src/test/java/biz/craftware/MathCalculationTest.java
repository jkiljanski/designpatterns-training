package biz.craftware;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


public class MathCalculationTest extends PatternsSpringTest {

    @Autowired
    private Calculator calculator;

    public static Stream<Arguments> mathInputWithResult() {
        return Stream.of(
                Arguments.of(5,3,6,13),
                Arguments.of(1,2,8,-2)
        );
    }

    @ParameterizedTest(name = "#{index} - Test with a={0}, b={1}, c={2} should give {3}")
    @MethodSource("mathInputWithResult")
    public void calculateExpressionWithSampleValues(int a, int b, int c, int expectedResult) {
        //given
        Map<String, Integer> values = Map.of(
                "a", a,
                "b", b,
                "c", c
        );
        MathExpression expression = null;

        //when
        int result = calculator.calculate(expression, values);

        //then
        assertThat(result).isEqualTo(expectedResult);
        assertThat(expression.getNotation()).isEqualTo("(a*b)-(c/b)");

    }

    private static class Pair {
        String key;
        int value;

        private Pair(String key, int value) {
            this.key = key;
            this.value = value;
        }

    }
}
