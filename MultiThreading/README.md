Multithreading is a Java feature that allows concurrent execution of two or more parts<br />
of a program for maximum utilization of CPU. Each part of such program is called a thread. <br />
So, threads are light-weight processes within a process.<br />
<br />
**Threads can be created by using two mechanisms:** <br />
1. Extending the **Thread class** <br />
2. Implementing the **Runnable Interface** <br />
<br />
**Thread creation by extending the Thread class**<br />
<br />
We create a class that extends the java.lang.Thread class. <br />
This class overrides the run() method available in the Thread class. <br />
A thread begins its life inside **run()** method. <br />
We create an object of our new class and call **start()** method to start the execution of a thread. <br />
Start() invokes the **run()** method on the Thread object.<br />
<br />
// Java code for thread creation by extending the Thread class <br />
class MultithreadingDemo extends Thread {<br /> 
	public void run() { <br />
		try { <br />
			// Displaying the thread that is running <br />
			System.out.println ("Thread " + Thread.currentThread().getId() + " is running"); <br />
		} <br />
		catch (Exception e) { <br />
			// Throwing an exception <br />
			System.out.println ("Exception is caught"); <br />
		} } } <br />
<br />
// Main Class <br />
public class Multithread { <br />
	public static void main(String[] args) { <br />
		int n = 8; // Number of threads <br />
		for (int i=0; i<8; i++) { <br />
			MultithreadingDemo object = new MultithreadingDemo(); <br />
			object.start(); <br />
		} } } <br />
    Output:<br />
Thread 8 is running<br />
Thread 9 is running<br />
Thread 10 is running<br />
Thread 11 is running<br />
Thread 12 is running<br />
Thread 13 is running<br />
Thread 14 is running<br />
Thread 15 is running<br />
<br /><br />
**Thread creation by implementing the Runnable Interface**<br />
We create a new class which implements java.lang.Runnable interface and override run() method.<br /> 
Then we instantiate a Thread object and call start() method on this object.<br />
// Java code for thread creation by implementing the Runnable Interface<br />
class MultithreadingDemo implements Runnable { <br />
	public void run() {<br /> 
		try {<br /> 
			// Displaying the thread that is running <br />
			System.out.println ("Thread " + Thread.currentThread().getId() + " is running"); <br />
		} <br />
		catch (Exception e) { <br />
			// Throwing an exception <br />
			System.out.println ("Exception is caught"); <br />
		} } }<br />
<br />
// Main Class <br />
class Multithread {<br /> 
	public static void main(String[] args) { <br />
		int n = 8; // Number of threads <br />
		for (int i=0; i<n; i++) { <br />
			Thread object = new Thread(new MultithreadingDemo()); <br />
			object.start(); <br />
		} <br />
	} <br />
} <br />


