
/** 
public class FinalWord extends Bike {
*
if you make a class final, you cannot extend it
*/


public class FinalWord extends FinalMethod {

	public static void main(String[] args) {
		
		FinalVariable fv = new FinalVariable();
		fv.run();
		
		FinalMethod fm = new FinalMethod();
	}
	
	
	/** This will not compile
	void run() {
		System.out.println("running safely with 100mph");
	}*/
}


/** You cannot change a final variable */
class FinalVariable extends FinalMethod {
	
	final int speedlimit = 60;
	
	/** this will not compile
	void run() {
		//speedlimit = 80;
	} */
}


/** If you make any method as final, you cannot override it. */
class FinalMethod {
	final void run() {
		System.out.println("running");
	}
}



/** If you man any class final, you cannot extend it */
final class Bike{}  


