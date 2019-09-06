package biz.craftware;

public interface User {

	void register(Chat chat);
	void sendMessage(String message);
	String messageObtained();
}
