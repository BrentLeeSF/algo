package Creational;

/**
 * A class of which only a single instance can exist
 * https://www.tutorialspoint.com/design_pattern/singleton_pattern.htm
 */
class SingleObject {

	/**
	 * A class of which only a single instance can exist create an object of
	 * SingleObject
	 */
	private static SingleObject instance = new SingleObject();

	/** make constructor private so that this class cannot be instantiated */
	private SingleObject() {
	}

	/** Get the only object available */
	public static SingleObject getInstance() {
		return instance;
	}

	public void showMessage() {
		System.out.println("Hello World!");
	}

}

public class Singleton {

	public static void main(String[] args) {

		/** Compile Time Error: The constructor SingleObject() is not visible */
		// SingleObject newObject = new SingleObject();

		/** Get the only object available */
		SingleObject object = SingleObject.getInstance();

		/** show the message */
		object.showMessage();
	}
}
