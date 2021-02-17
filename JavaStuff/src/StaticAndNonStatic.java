
/** Implement static and non-static classes in java */
class OuterClass {

	private static String msg = "GeeksForGeeks";

	/** Static nested class */
	public static class NestedStaticClass {

		/**
		 * Only static members of Outer class is directly accessible in nested static
		 * class
		 */
		public void printMessage() {

			/** Try making 'message' a non-static variable, there will be compiler error */
			System.out.println("Message from nested static class: " + msg);
		}
	}

	/** non-static nested class - also called Inner class */
	public class InnerClass {

		/**
		 * Both static and non-static members of Outer class are accessible in this
		 * Inner class
		 */
		public void display() {
			System.out.println("Message from non-static nested class: " + msg);
		}
	}
}

class StaticAndNonStatic {

	// static variable
	static int a = 10;
	static int b;
	int c = 10;
	int d = 0;

	// static block
	static {
		System.out.println("Static block initialized.");
		b = a * 4;
	}

	public void test() {
		d = c * 4;
		System.out.println("NON - Static function = "+d);
	}

	/** How to create instance of static and non static nested class? */
	public static void main(String args[]) {

		System.out.println("from main");
		System.out.println("Value of a : " + a);
		System.out.println("Value of b : " + b);
		StaticAndNonStatic st = new StaticAndNonStatic();
		st.test();

		OuterClass.NestedStaticClass printer = new OuterClass.NestedStaticClass();

		/** call non static method of nested static class */
		printer.printMessage();

		/**
		 * In order to create instance of Inner class we need an Outer class instance.
		 * Let us create Outer class instance for creating non-static nested class
		 */
		OuterClass outer = new OuterClass();
		OuterClass.InnerClass inner = outer.new InnerClass();

		/** calling non-static method of Inner class */
		inner.display();

		/** Combine above steps in one step to create instance of Inner class */
		OuterClass.InnerClass innerObject = new OuterClass().new InnerClass();

		/** similarly we can now call Inner class method */
		innerObject.display();

		int a = 5, b = 0;

		/** Attempting to divide by zero */
		try {
			int c = a / b;
			System.out.println("C = " + c);
		} catch (ArithmeticException e) {
			e.printStackTrace();
		}
		System.out.println("Tacos -- ");

	}
}
