package biz.craftware;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

public class DifferentStylesOfMuuTest {


    static Object[][] strategiesToMoo() {
        return new Object[][]{
                {"Muuu", null, "Muuu"},
                {"Muuu", new NoOpStrategy(), "Muuu"},
                {"Muuu", new LoudStrategy(), "MUUU!!!"},
                {"MUUU", new SilentStrategy(), "mu"},
                {"Muuu!", new StammerStrategy(), "M... u... u... u... !"},

        };
    }


    @ParameterizedTest(name = "[{index}]{0} -> {2}")
    @MethodSource("strategiesToMoo")
    public void shouldMooNormal(String whatDoesNormally, StrategyToMoo strategyToMoo, String expectedSound) {
        //given
        CowWithMooStrategy cow = new CowWithMooStrategy(whatDoesNormally);

        //when
        String sound = cow.makeSound(strategyToMoo);

        //then
        assertThat(sound).isEqualTo(expectedSound);

    }
}
