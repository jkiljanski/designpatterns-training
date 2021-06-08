package biz.craftware;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DualChatTest extends PatternsSpringTest {

    @Test
    public void communicateInBothWays() {
        //given
        RecordingUser alice = new RecordingUser();
        RespondingUser bob = new RespondingUser();

        Chat chat = new ChatForTwoPersons(alice, bob);

        //when
        alice.sendMessage("Hi!");

        //then
        assertThat(alice.getRecordedResponse()).isEqualTo("Hi! I'm Bob!");

    }
}
