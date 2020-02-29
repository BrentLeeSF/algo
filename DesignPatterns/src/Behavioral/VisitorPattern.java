package Behavioral;

/**
 * Visitor lets you define a new operation without changing the classes of the
 * elements on which it operates.
 * https://sourcemaking.com/design_patterns/visitor
 */
interface ElementDemo {
	void accept(Visitor v);
}

class FOO implements ElementDemo {

	public void accept(Visitor v) {
		v.visit(this);
	}

	public String getFOO() {
		return "FOO";
	}
}

class BAR implements ElementDemo {

	public void accept(Visitor v) {
		v.visit(this);
	}

	public String getBAR() {
		return "BAR";
	}
}

class BAZ implements ElementDemo {

	public void accept(Visitor v) {
		v.visit(this);
	}

	public String getBAZ() {
		return "BAZ";
	}
}

interface Visitor {

	void visit(FOO foo);

	void visit(BAR bar);

	void visit(BAZ baz);
}

class UpVisitor implements Visitor {

	public void visit(FOO foo) {
		System.out.println("do Up on " + foo.getFOO());
	}

	public void visit(BAR bar) {
		System.out.println("do Up on " + bar.getBAR());
	}

	public void visit(BAZ baz) {
		System.out.println("do Up on " + baz.getBAZ());
	}
}

class DownVisitor implements Visitor {

	public void visit(FOO foo) {
		System.out.println("do Down on " + foo.getFOO());
	}

	public void visit(BAR bar) {
		System.out.println("do Down on " + bar.getBAR());
	}

	public void visit(BAZ baz) {
		System.out.println("do Down on " + baz.getBAZ());
	}
}

public class VisitorPattern {

	public static void main(String[] args) {

		ElementDemo[] list = { new FOO(), new BAR(), new BAZ() };
		UpVisitor up = new UpVisitor();
		DownVisitor down = new DownVisitor();

		for (ElementDemo element : list) {
			element.accept(up);
		}

		for (ElementDemo element : list) {
			element.accept(down);
		}

	}
}
