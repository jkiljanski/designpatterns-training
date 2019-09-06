package biz.craftware;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Secret {

	final String name;
	final int value;

	public Secret(String name, int value) {
		this.name = name;
		this.value = value;
	}

	private List<Secret> subSecrets = new LinkedList<>();

	public void add(Secret... secrets){
		subSecrets.addAll(Arrays.asList(secrets));
	}
}
