package biz.craftware;

import java.util.Collections;
import java.util.List;

public class Stamp<T> {
	private T originalCow;

	public Stamp(T originalCow) {
		this.originalCow = originalCow;
	}

	public List<T> produce(int numberOfCopies) {
		return Collections.emptyList();
	}
}
