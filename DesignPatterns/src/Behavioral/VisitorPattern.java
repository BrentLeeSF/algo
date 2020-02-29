package Behavioral;

/**
 * Visitor lets you define a new operation without changing the classes of the
 * elements on which it operates. */
/**
 * Many distinct and unrelated operations need to be performed on node objects
 * in a heterogeneous aggregate structure. You want to avoid "polluting" the
 * node classes with these operations. And, you don't want to have to query the
 * type of each node and cast the pointer to the correct type before performing
 * the desired operation. https://sourcemaking.com/design_patterns/visitor
 */
interface Base {

	void execute(Base target);

	void doJob(FOO target);

	void doJob(BAR target);

	void doJob(BAZ target);

}

class FOO implements Base {

	public void execute(Base base) {
		base.doJob(this);
	}

	public void doJob(FOO foo) {
		System.out.println("FOO object calls by yourself");
	}

	public void doJob(BAR bar) {
		System.out.println("BAR object was called from FOO");
	}

	public void doJob(BAZ baz) {
		System.out.println("BAZ object was called from FOO");
	}
}

class BAR implements Base {

	public void execute(Base base) {
		base.doJob(this);
	}

	public void doJob(FOO foo) {
		System.out.println("FOO object was called from BAR");
	}

	public void doJob(BAR bar) {
		System.out.println("BAR object calls by yourself");
	}

	public void doJob(BAZ baz) {
		System.out.println("BAZ object was called from BAR");
	}
}

class BAZ implements Base {

	public void execute(Base base) {
		base.doJob(this);
	}

	public void doJob(FOO foo) {
		System.out.println("FOO object was called from BAZ");
	}

	public void doJob(BAR bar) {
		System.out.println("BAR object was called from BAZ");
	}

	public void doJob(BAZ baz) {
		System.out.println("BAZ object calls by yourself");
	}
}

public class VisitorPattern {

	public static void main(String[] args) {

		Base objectsArray[] = { new FOO(), new BAR(), new BAZ() };

		for (Base eachObject : objectsArray) {

			for (int j = 0; j < 3; j++) {

				eachObject.execute(objectsArray[j]);
			}

			System.out.println();
		}
	}
}
