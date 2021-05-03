package clonning;

public class Test {

	public static void main(String[] args) {

		/*
		 * for (int i = 1; i <= 100; i++) { if (getPrimeNumber(i) == true)
		 * System.out.println(i); }
		 */
		int num = 6;
		System.out.println(getFactorial(num));
		System.out.println(getFactorialByRecursion(6));

//		getFaboniccaSeries();
		int n1 = 0, n2 = 1, n3 = 0, count = 0;
		System.out.print(n1 + ", " + n2 + ", ");
		getFaboniccaSeriesByRecursion(n1,n2,n3,count);

	}

	private static int  getFaboniccaSeriesByRecursion(int n1, int n2, int n3, int count) {
		if (count < 100) {
			n3 = n1 + n2;
			System.out.print(n3 + ", ");
			n1 = n2;
			n2 = n3;
			count++;
			return (getFaboniccaSeriesByRecursion(n1,n2,n3,count));
		}
		return count;
	}

	private static void getFaboniccaSeries() {
		int n1 = 0, n2 = 1, n3;
		System.out.print(n1 + ", " + n2 + ", ");
		for (int i = 0; i < 100; i++) {
			n3 = n1 + n2;
			System.out.print(n3 + ", ");
			n1 = n2;
			n2 = n3;
		}
	}

	private static boolean getPrimeNumber(int num) {
		for (int i = 2; i < num; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

	private static int getFactorial(int num) {
		int k = 1;
		for (int i = num; i >= 1; i--) {
			k = k * i;
		}
		return k;
	}

	private static int getFactorialByRecursion(int num) {
		if (num > 1) {
			return num * getFactorialByRecursion(num - 1);
		} else
			return num;
	}

}
