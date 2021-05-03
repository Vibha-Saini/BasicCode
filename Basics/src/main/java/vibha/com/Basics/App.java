package vibha.com.Basics;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		TestInterface sbiTi = (msg, msg2) -> System.out.println("welcome to sbi " + msg);
		sbiTi.checkStatus("SAini", " Saini");
		Payment p = new Payment();
		p.pay();
		Hdfc hdfcsupport = new HdfcSupport();
		Hdfc.checkBlance();
		RBI hdfc = new Hdfc();
		TestInterface.checkBlance();
		System.out.println(hdfc.printPassBook("vibha"));
		System.out.println(hdfcsupport.printPassBook("Vibha Saini"));
	}

}
