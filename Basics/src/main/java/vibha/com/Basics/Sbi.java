package vibha.com.Basics;

public class Sbi implements RBI {
	public String doKyc() {
		String docs = "please submit your adhar card, pan card, birth certificate";
		return docs;
	}

	public String printPassBook(String customerName) {

		return "Thank you " + customerName + " your pass book is ready";
	}
}
