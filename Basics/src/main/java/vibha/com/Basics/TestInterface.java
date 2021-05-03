package vibha.com.Basics;

public interface TestInterface {

	void checkStatus(String msg1, String msg2);

	int i = 10;

	default void pay() {
		System.out.println("We paid your amount! Thanks ***********");
	}

	static void checkBlance() {
		System.out.println("! 5 rupees");
	}

}
