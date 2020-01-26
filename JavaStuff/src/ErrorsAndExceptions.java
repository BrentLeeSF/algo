
public class ErrorsAndExceptions {

	public static void main(String[] args) {

		exceptionTest(0);
		System.out.println("\n\n");
		errorTest(5);

	}

	/** Exception will allow program to continually run */
	public static void exceptionTest(int num) {
		int a = 5;

		try {
			int c = a / num;
		} catch (ArithmeticException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This is a runtime error - the program will crash. Exception will not work
	 * here
	 */
	public static void errorTest(int num) {
		if (num == 0) {
			return;
		}
		errorTest(num++);
	}

}
