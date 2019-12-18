

// https://www.javatpoint.com/java-multithreading-interview-questions
// https://www.geeksforgeeks.org/thread-pools-java/
import java.text.SimpleDateFormat; 
import java.util.Date; 
import java.util.concurrent.ExecutorService; 
import java.util.concurrent.Executors; 


/** A thread pool reuses previously created threads to execute current tasks  
 * Since the thread is already existing when the request arrives, 
 * the delay introduced by thread creation is eliminated, making the application more responsive.
 * 
 * In case of a fixed thread pool, if all threads are being currently run by the executor then 
 * the pending tasks are placed in a queue and are executed when a thread becomes idle.
 * 
 * This is an example of a thread pool executor- FixedThreadPool.
 * 
 * Steps to be followed
 *
 * 1. Create a task(Runnable Object) to execute
 * 2. Create Executor Pool using Executors
 * 3. Pass tasks to Executor Pool
 * 4. Shutdown the Executor Pool */

// Task class to be executed (Step 1) 
class Task implements Runnable { 
	
	
	private String name; 
	
	public Task(String s)  { 
		name = s; 
	} 
	
	// Prints task name and sleeps for 1s 
	// This Whole process is repeated 5 times 
	public void run()  { 
		
		try {
			
			for (int i = 0; i<= 5; i++) {
				
				if (i == 0) {
					Date d = new Date(); 
					SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss"); 
					//prints the initialization time for every task 
					System.out.println("Initialization Time for"+ " task name - "+ name +" = " +ft.format(d)); 
				} 
				
				else {
					Date d = new Date(); 
					SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss"); 
					// prints the execution time for every task 
					System.out.println("Executing Time for task name - "+ name +" = " +ft.format(d)); 
				}
				Thread.sleep(1000); 
			}
			System.out.println(name+" complete"); 
		} 
		
		catch(InterruptedException e) { 
			e.printStackTrace(); 
		} 
	} 
} 


public class ThreadPoolTest { 
	
	// Maximum number of threads in thread pool 
	static final int MAX_T = 3;	
	

	public static void main(String[] args) { 
		
		// creates five tasks 
		Runnable r1 = new Task("task 1"); 
		Runnable r2 = new Task("task 2"); 
		Runnable r3 = new Task("task 3"); 
		Runnable r4 = new Task("task 4"); 
		Runnable r5 = new Task("task 5");	 
		
		// creates a thread pool with MAX_T no. of 
		// threads as the fixed pool size(Step 2) 
		ExecutorService pool = Executors.newFixedThreadPool(MAX_T); 
		
		// passes the Task objects to the pool to execute (Step 3) 
		pool.execute(r1); 
		pool.execute(r2); 
		pool.execute(r3); 
		pool.execute(r4); 
		pool.execute(r5); 
		
		// pool shutdown ( Step 4) 
		pool.shutdown();	 
	} 
} 
