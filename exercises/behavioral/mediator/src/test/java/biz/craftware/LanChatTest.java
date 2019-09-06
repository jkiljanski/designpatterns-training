package biz.craftware;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LanChatTest extends PatternsSpringTest{

	@Test
	public void communicateInBothWays(){
		//given
		RecordingUser sender = new RecordingUser();
		RespondingUser user1 = new RespondingUser();
		RespondingUser user2 = new RespondingUser();
		RespondingUser user3 = new RespondingUser();

		Chat chat = new ChatForManyPersons(sender, user1, user2, user3);

		//when
		sender.sendMessage("Hi!");

		//then
		assertThat(sender.getRecordedResponses()).contains(
				"Hi! I'm user1!",
				"Hi! I'm user2!",
				"Hi! I'm user3!"
		);

	}
}
