package biz.craftware;

import biz.craftware.domain.farm.Cattle;
import biz.craftware.domain.farm.Horse;
import biz.craftware.domain.farm.Tractor;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeTest {

    @Test
    public void playMelodyUsingAnimals() {
        //given
        Cattle cattle = new Cattle(500, Cattle.Breed.ANGUS, Cattle.Color.BROWN);
        Horse horse = new Horse();
        Tractor tractor = new Tractor("Ursus", 200);

        List<String> melody = new LinkedList<>();

        //when
        //TODO add players: cow, horse, tractor
        Orchestra orchestra = new Orchestra();

        melody.add(orchestra.makeSoundOfPlayer(0));
        melody.add(orchestra.makeSoundOfPlayer(1));
        melody.add(orchestra.makeSoundOfPlayer(2));
        melody.add(orchestra.makeSoundOfPlayer(1));
        melody.add(orchestra.makeSoundOfPlayer(0));

        //then
        assertThat(melody).containsExactly(
                "Muuuuuuuuuu",
                "Ihaahaa",
                "bruuum",
                "Ihaahaa",
                "Muuuuuuuuuu"
        );


    }
}
