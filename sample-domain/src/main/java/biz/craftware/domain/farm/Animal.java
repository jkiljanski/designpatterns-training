package biz.craftware.domain.farm;

public interface Animal {
	int getWeight();

	void markWithOwnersName(String mark);

	String getOwnersMark();

	String getName();

	void setName(String name);

	String makeSound();
}
