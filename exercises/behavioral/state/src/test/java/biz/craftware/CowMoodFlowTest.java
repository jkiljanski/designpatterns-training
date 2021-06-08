package biz.craftware;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CowMoodFlowTest {

    public static Object[][] cowStatesWithTransition() {
        return new Object[][]{
                {"normal", tran(CowWithMood::play), "happy"},
                {"normal", tran(CowWithMood::scare), "scared"},
                {"normal", tran(CowWithMood::calmDown), "normal"},
                {"normal", tran(CowWithMood::goToBox), "sad"},

                {"happy", tran(CowWithMood::play), "happy"},
                {"happy", tran(CowWithMood::scare), "scared"},
                {"happy", tran(CowWithMood::calmDown), "happy"},
                {"happy", tran(CowWithMood::goToBox), "normal"},

                {"scared", tran(CowWithMood::play), "scared"},
                {"scared", tran(CowWithMood::scare), "scared"},
                {"scared", tran(CowWithMood::calmDown), "normal"},
                {"scared", tran(CowWithMood::goToBox), "scared"},

                {"sad", tran(CowWithMood::play), "normal"},
                {"sad", tran(CowWithMood::scare), "scared"},
                {"sad", tran(CowWithMood::calmDown), "normal"},
                {"sad", tran(CowWithMood::goToBox), "sad"}

        };
    }

    @MethodSource("cowStatesWithTransition")
    @ParameterizedTest(name = "[{index}] {0} -> {2}")
    public void shouldFlowThroughMoods(String state, Transition transition, String expectedState) {
        //given
        CowWithMood cowWithMood = new CowWithMood(state);

        //when
        transition.transition(cowWithMood);

        //then
        assertThat(cowWithMood.getState()).isEqualTo(expectedState);

    }

    static Transition tran(Transition transition) {
        return transition;
    }

    private interface Transition {
        void transition(CowWithMood cowWithMood);
    }

}
