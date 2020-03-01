package Behavioral;

/**
 * A way of passing a request between a chain of objects to handle request
 * https://www.geeksforgeeks.org/chain-responsibility-design-pattern/
 */
interface ChainOfResponsibilityTwoInterface {

	public abstract void setNext(ChainOfResponsibilityTwoInterface nextInChain);

	public abstract void process(Number request);
}

class Number {

	private int number;

	public Number(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

}

class NegativeProcessor implements ChainOfResponsibilityTwoInterface {

	private ChainOfResponsibilityTwoInterface nextInChain;

	public void setNext(ChainOfResponsibilityTwoInterface c) {
		nextInChain = c;
	}

	public void process(Number request) {

		if (request.getNumber() < 0) {
			System.out.println("NegativeProcessor : " + request.getNumber());
		}

		else {
			nextInChain.process(request);
		}
	}
}

class ZeroProcessor implements ChainOfResponsibilityTwoInterface {

	private ChainOfResponsibilityTwoInterface nextInChain;

	public void setNext(ChainOfResponsibilityTwoInterface c) {
		nextInChain = c;
	}

	public void process(Number request) {

		if (request.getNumber() == 0) {
			System.out.println("ZeroProcessor : " + request.getNumber());
		}

		else {
			nextInChain.process(request);
		}
	}
}

class PositiveProcessor implements ChainOfResponsibilityTwoInterface {

	private ChainOfResponsibilityTwoInterface nextInChain;

	public void setNext(ChainOfResponsibilityTwoInterface c) {
		nextInChain = c;
	}

	public void process(Number request) {

		if (request.getNumber() > 0) {
			System.out.println("PositiveProcessor : " + request.getNumber());
		} else {
			nextInChain.process(request);
		}
	}
}

public class ChainOfResponsibilityTwo {

	public static void main(String[] args) {

		/** configure Chain of Responsibility */
		ChainOfResponsibilityTwoInterface c1 = new NegativeProcessor();
		ChainOfResponsibilityTwoInterface c2 = new ZeroProcessor();
		ChainOfResponsibilityTwoInterface c3 = new PositiveProcessor();
		c1.setNext(c2);
		c2.setNext(c3);

		/** calling chain of responsibility */
		c1.process(new Number(90));
		c1.process(new Number(-50));
		c1.process(new Number(0));
		c1.process(new Number(91));
	}
}
