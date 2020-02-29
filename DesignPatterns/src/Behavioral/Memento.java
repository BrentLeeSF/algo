package Behavioral;

import java.util.ArrayList;

/**
 * Memento pattern is used to restore state of an object to a previous state.
 * https://www.tutorialspoint.com/design_pattern/memento_pattern.htm
 */
class MementoDemo {

	private String state;

	public MementoDemo(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}
}

class Originator {

	private String state;

	/**
	 * lots of memory consumptive private data that is not necessary to define the
	 * state and should thus not be saved. Hence the small memento object.
	 */

	public void setState(String state) {
		System.out.println("Originator: Setting state to " + state);
		this.state = state;
	}

	public MementoDemo save() {
		System.out.println("Originator: Saving to Memento.");
		return new MementoDemo(state);
	}

	public void restore(MementoDemo m) {
		state = m.getState();
		System.out.println("Originator: State after restoring from Memento: " + state);
	}
}

class Caretaker {

	private ArrayList<MementoDemo> mementos = new ArrayList<>();

	public void addMemento(MementoDemo m) {
		mementos.add(m);
	}

	public MementoDemo getMemento() {
		return mementos.get(1);
	}
}

public class Memento {

	public static void main(String[] args) {

		Caretaker caretaker = new Caretaker();
		Originator originator = new Originator();

		originator.setState("State1");
		originator.setState("State2");

		caretaker.addMemento(originator.save());
		originator.setState("State3");

		caretaker.addMemento(originator.save());
		originator.setState("State4");

		originator.restore(caretaker.getMemento());
	}

}
