package biz.craftware;

import java.util.Iterator;
import java.util.List;

public class MultiListIterator implements Iterator<Integer>{
	public MultiListIterator(List<Integer> ... lists) {
	}

	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public Integer next() {
		return null;
	}
}
