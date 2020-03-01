package Structural;

import java.util.ArrayList;
import java.util.List;

/**
 * A tree structure of simple and composite objects. Composite - Allows clients
 * to operate in generic manner on objects that may or may not represent a
 * hierarchy of objects https://www.geeksforgeeks.org/composite-design-pattern/
 */

interface CompositeEmployee {
	public void showEmployeeDetails();
}

class Developer implements CompositeEmployee {

	private String name;
	private long empId;
	private String position;

	public Developer(long empId, String name, String position) {

		this.empId = empId;
		this.name = name;
		this.position = position;
	}

	@Override
	public void showEmployeeDetails() {
		System.out.println(empId + " " + name);
	}
}

class Manager implements CompositeEmployee {

	private String name;
	private long empId;
	private String position;

	public Manager(long empId, String name, String position) {

		this.empId = empId;
		this.name = name;
		this.position = position;
	}

	@Override
	public void showEmployeeDetails() {
		System.out.println(empId + " " + name);
	}
}

class CompanyDirectory implements CompositeEmployee {

	private List<CompositeEmployee> employeeList = new ArrayList<CompositeEmployee>();

	@Override
	public void showEmployeeDetails() {

		for (CompositeEmployee emp : employeeList) {
			emp.showEmployeeDetails();
		}
	}

	public void addEmployee(CompositeEmployee emp) {
		employeeList.add(emp);
	}

	public void removeEmployee(CompositeEmployee emp) {
		employeeList.remove(emp);
	}
}

class Composite {

	public static void main(String[] args) {

		Developer dev1 = new Developer(100, "Brent Rucka", "Pro Developer");
		Developer dev2 = new Developer(101, "Random Dude", "Developer");

		CompanyDirectory engDirectory = new CompanyDirectory();

		engDirectory.addEmployee(dev1);
		engDirectory.addEmployee(dev2);

		Manager man1 = new Manager(200, "Some Random Manager", "SEO Manager");
		Manager man2 = new Manager(201, "Highest Level Dude ", "Some Random Manager's Manager");

		CompanyDirectory accDirectory = new CompanyDirectory();

		accDirectory.addEmployee(man1);
		accDirectory.addEmployee(man2);

		CompanyDirectory directory = new CompanyDirectory();

		directory.addEmployee(engDirectory);
		directory.addEmployee(accDirectory);
		directory.showEmployeeDetails();

	}
}