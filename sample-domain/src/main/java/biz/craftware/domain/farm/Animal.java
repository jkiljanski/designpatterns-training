package biz.craftware.domain.farm;

import java.util.Collections;
import java.util.List;

public interface Animal {
	int getWeight();

	void markWithOwnersName(String mark);

	String getOwnersMark();

	String getName();

	void setName(String name);

	String makeSound();

	default List<Animal> getChildren(){
		return Collections.emptyList();
	}
}
