

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;



/** Locks
For more granular control, we can utilize a lock. A lock (or monitor) is used 
to synchronize access to a shared resource by associating the resource with the lock. 
A thread gets access to a shared resource by first acquiring the lock associated with the resource. 
At any given time, at most one thread can hold the lock and, therefore, 
only one thread can access the shared resource.
A common use case for locks is when a resource is accessed from multiple places, 
but should be only */
public class LockedATM {
	
	
    private Lock lock;
    private int balance = 100;

    public LockedATM() {
        lock = new ReentrantLock();
    }
    

    public int withdraw(int value) {
    	
        lock.lock();
        int temp = balance;
        
        try {
            Thread.sleep(100);
            temp = temp - value;
            Thread.sleep(100);
            balance = temp;
            
        } catch (InterruptedException e) {    }
        
        lock.unlock();
        return temp;
    }

    
    public int deposit(int value) {
    	
        lock.lock();
        int temp = balance;
        
        try {
            Thread.sleep(100);
            temp = temp + value;
            Thread.sleep(100);
            balance = temp;
            
        } catch (InterruptedException e) {    }
        
        lock.unlock();
        return temp;
    }

    public int getBalance() {
        return balance;
    }
}
