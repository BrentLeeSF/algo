


/** We can create a thread by extending the Thread class. 
 * This will almost always mean that we override the run() method, 
 * and the subclass may also call the thread constructor explicitly in its constructor. */
public class ThreadExample extends Thread {
    int count = 0;

    @Override
    public void run() {
    	
        System.out.println("Thread starting.");
        
        try {
            while (count < 5) {
                Thread.sleep(500);
                System.out.println("In Thread, count is " + count);
                count++;
            }
            
        } catch (InterruptedException exc) {
            System.out.println("Thread interrupted.");
        }
        
        System.out.println("Thread terminating.");
    }
}
