package biz.craftware;

import java.util.Arrays;
import java.util.List;

public class Orchestra {

	private final List<Player> players;

	public Orchestra(Player ... players) {
		this.players = Arrays.asList(players);
	}

	public String makeSoundOfPlayer(int i){
		return null;
	}
}
