

/** To create and use a thread using this interface, we do the following:
1. Create a class which implements the Runnable interface. 
An object of this class is a Runnable object,
2. CreateanobjectoftypeThreadbypassingaRunnableobjectasargumenttotheThreadconstructor. 
The Thread object now has a Runnable object that implements the r u n ( ) method,
3. The s t a r t () method is invoked on the Thread object created in the previous step. */
public class RunnableThreadExample implements Runnable {
	
    public int count = 0;

    public void run() {
    	
        System.out.println("RunnableThread starting.");
        
        try {
            while (count < 5) {
                Thread.sleep(500);
                count++;
            }
            
        } catch (InterruptedException exc) {
            System.out.println("RunnableThread interrupted.");
        }
        
        System.out.println("RunnableThread terminating.");
    }
}
