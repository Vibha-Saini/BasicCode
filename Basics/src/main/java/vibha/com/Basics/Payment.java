package vibha.com.Basics;

public class Payment implements TestInterface {

	@Override
	public void checkStatus(String msg1, String msg2) {

	}

	@Override
	public void pay() {
		TestInterface.super.pay();
	}
}
