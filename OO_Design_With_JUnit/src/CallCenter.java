
/**
 * Image you have a call center with three levels of employees: respondent,
 * manager, and director. An incoming call must first be allocated to a
 * respondent who is free. If the respondent can't handle the call, he or she
 * must escalate the call to a manager. If the manager is not free or not able
 * to handle it, then the call should be escalated to the director.
 * 
 * Design the classes and data structures for this problem. Implement a method
 * dispatchCall() which assigns a call to the first available employee
 */

abstract class Employee {

	int employeeLevelID = 0;
	int employeeID = 0;
	boolean isAvailable;

	public Employee(int employeeLevelID, int employeeID, boolean isAvailable) {
		this.employeeLevelID = employeeLevelID;
		this.employeeID = employeeID;
		this.isAvailable = isAvailable;
	}

	public abstract void getCall();
}

class Respondent extends Employee {
	public Respondent(int employeeLevelID, int employeeID, boolean takingCall) {
		super(employeeLevelID, employeeID, takingCall);
	}

	public void getCall() {
		isAvailable = false;
	}
}

class Manager extends Employee {
	public Manager(int employeeLevelID, int employeeID, boolean takingCall) {
		super(employeeLevelID, employeeID, takingCall);
	}

	public void getCall() {
		isAvailable = false;
	}
}

class Director extends Employee {
	public Director(int employeeLevelID, int employeeID, boolean takingCall) {
		super(employeeLevelID, employeeID, takingCall);
	}

	public void getCall() {
		isAvailable = false;
	}
}

class TheCallCenter {

	Respondent[] respondent;
	Manager[] manager;
	Director[] director;
	int respCounter = 0;
	int manCounter = 0;
	int dirCounter = 0;

	public TheCallCenter() {
		respondent = new Respondent[10];
		manager = new Manager[5];
		director = new Director[3];
	}

	public void createCallCenter() {
		for (int i = 0; i < 10; i++) {
			respondent[i] = new Respondent(1, i, true);
		}
		for (int i = 0; i < 5; i++) {
			manager[i] = new Manager(2, i, true);
		}
		for (int i = 0; i < 3; i++) {
			director[i] = new Director(3, i, true);
		}
	}

	public void dispatchCall(int index) {
		if (respCounter < respondent.length) {
			respondent[respCounter].getCall();
			System.out.println("Respondent " + index);
			respCounter++;
		} else if (manCounter < manager.length) {
			System.out.println("Manager " + index);
			manager[manCounter].getCall();
			System.out.println("Manager " + index);
			manCounter++;
		} else if (dirCounter < director.length) {
			director[dirCounter].getCall();
			System.out.println("Director " + index);
			dirCounter++;
		} else {
			System.out.println(allCallsAreBusy(index));
		}
	}
	
	public String allCallsAreBusy(int index) {
		return "All lines are busy "+index;
	}

}

public class CallCenter {

	public static void main(String[] args) {

		TheCallCenter newCallCenter = new TheCallCenter();
		newCallCenter.createCallCenter();

		for (int i = 0; i < 20; i++) {
			newCallCenter.dispatchCall(i);
		}
	}
}
