package Behavioral;

/**
 * The class behavior changes based on its state
 * https://www.javatpoint.com/state-pattern
 */
interface StateDemo {
	public void doAction(Context context);
}

class StartState implements StateDemo {

	public void doAction(Context context) {
		System.out.println("Player is in start state");
		context.setState(this);
	}

	public String toString() {
		return "Start State";
	}
}

class StopState implements StateDemo {

	public void doAction(Context context) {
		System.out.println("Player is in stop state");
		context.setState(this);
	}

	public String toString() {
		return "Stop State";
	}
}

class Context {
	
	private StateDemo state;

	public Context() {
		state = null;
	}

	public void setState(StateDemo state) {
		this.state = state;
	}

	public StateDemo getState() {
		return state;
	}
}

public class StatePattern {

	public static void main(String[] args) {

		Context context = new Context();

		StartState startState = new StartState();
		startState.doAction(context);

		System.out.println(context.getState().toString());

		StopState stopState = new StopState();
		stopState.doAction(context);

		System.out.println(context.getState().toString());
	}
}
