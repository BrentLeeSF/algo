

/** Synchronized Methods
Most commonly, we restrict access to shared resources through the use of 
the s y n c h r o n i z e d keyword.
It can be applied to methods and code blocks, and restricts multiple threads 
from executing the code simultaneously on the same object. */


/** Like synchronizing a method, only one thread per instance of 
 * MyObject can execute the code within the synchronized block. 
 * That means that, if threadl and thread2 have the same instance of MyObject, 
 * only one will be allowed to execute the code block at a time */
public class MyClass extends Thread {
	
	
    private String name;
    private MyObject myObj;

    
    public MyClass(MyObject obj, String n) {
        name = n;
        myObj = obj;
    }

    
    @Override
    public void run() {
        myObj.foo(name);
    }
}
