
/** Threads can be created by using two mechanisms :
 * 1. Extending the Thread class
 * 2. Implementing the Runnable Interface*/


/** Java code for thread creation by extending the Thread class */
class MultithreadingDemoThreadClass extends Thread {
	public void run() {
		try {
			// Displaying the thread that is running
			System.out.println("Thread " + Thread.currentThread().getId() + " is running");

		} catch (Exception e) {
			// Throwing an exception
			System.out.println("Exception is caught");
		}
	}
}

/** Main Class */
class MultithreadThreadClass {
	
	public static void main(String[] args) {
		
		int n = 8; // Number of threads
		
		for (int i = 0; i < 8; i++) {
			MultithreadingDemoThreadClass object = new MultithreadingDemoThreadClass();
			object.start();
		}
	}
}

/**
 * OUTPUT: Thread 8 is running 
 * Thread 9 is running 
 * Thread 10 is running 
 * Thread 11 is running 
 * Thread 12 is running 
 * Thread 13 is running 
 * Thread 14 is running
 * Thread 15 is running
 */

/**
 * Java code for thread creation by implementing the Runnable Interface We
 * create a new class which implements java.lang.Runnable interface and override
 * run() method. Then we instantiate a Thread object and call start() method on
 * this object.
 */
class MultithreadingDemoRunnable implements Runnable {
	public void run() {
		try {
			// Displaying the thread that is running
			System.out.println("Thread " + Thread.currentThread().getId() + " is running");
		} catch (Exception e) {
			// Throwing an exception
			System.out.println("Exception is caught");
		}
	}
}

/** Main Class */
class MultithreadRunnable {

	public static void main(String[] args) {

		int n = 8; // Number of threads

		for (int i = 0; i < n; i++) {
			Thread object = new Thread(new MultithreadingDemoRunnable());
			object.start();
		}
	}
}

/**
 * Output : 
 * Thread 8 is running 
 * Thread 8 is running 
 * Thread 9 is running 
 * Thread 10 is running 
 * Thread 11 is running 
 * Thread 12 is running 
 * Thread 13 is running
 * Thread 14 is running 
 * Thread 15 is running
 */

public class ThreadVsRunnable {
}
