package Structural;

import java.util.Random;

/** decouple the functional abstraction from the implementation 
 * so that the two can vary independently */
/** Separates an object’s interface from its implementation 
 * https://sourcemaking.com/design_patterns/bridge/java/3 */

/**
 * Separates abstraction from the implementation so they work independently
 * Create an interface/wrapper class that "has a" implementation object and
 * delegates all requests to it
 */
class Stack {

	protected StackImp imp;

	public Stack(String s) {
		if (s.equals("java")) {
			imp = new StackJava();
		} else {
			imp = new StackMine();
		}
	}

	public Stack() {
		this("java");
	}

	public void push(int in) {
		imp.push(in);
	}

	public int pop() {
		return (Integer) imp.pop();
	}

	public boolean isEmpty() {
		return imp.empty();
	}
}

/**
 * Embellish the interface class with derived classes if desired
 */
class StackHanoi extends Stack {

	private int totalRejected = 0;

	public StackHanoi() {
		super("java");
	}

	public StackHanoi(String s) {
		super(s);
	}

	public int reportRejected() {
		return totalRejected;
	}

	public void push(int in) {
		if (!imp.empty() && in > (Integer) imp.peek()) {
			totalRejected++;
		} else {
			imp.push(in);
		}
	}
}

/**
 * Create an implementation/body base class
 */
interface StackImp {
	Object push(Object o);

	Object peek();

	boolean empty();

	Object pop();
}

class StackJava extends java.util.Stack implements StackImp {
}

/**
 * Derive the separate implementations from the common abstraction
 */
class StackMine implements StackImp {

	private Object[] items = new Object[20];
	private int total = -1;

	public Object push(Object o) {
		return items[++total] = o;
	}

	public Object peek() {
		return items[total];
	}

	public Object pop() {
		return items[total--];
	}

	public boolean empty() {
		return total == -1;
	}
}

public class Bridge {

	public static void main(String[] args) {

		Stack[] stacks = { new Stack("java"), new Stack("mine"), new StackHanoi("java"), new StackHanoi("mine") };

		for (int i = 0, num; i < 20; i++) {

			num = (int) (Math.random() * 1000) % 40;

			for (Stack stack : stacks) {
				stack.push(num);
			}
		}

		for (int i = 0, num; i < stacks.length; i++) {

			while (!stacks[i].isEmpty()) {
				System.out.print(stacks[i].pop() + "  ");
			}
			System.out.println();
		}
		System.out.println("total rejected is " + ((StackHanoi) stacks[3]).reportRejected());
	}
}
