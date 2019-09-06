package biz.craftware;

import biz.craftware.observers.Observer;

public interface Observable {

	void attach(Observer observer);
}
