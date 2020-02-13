public class Recursion {

	public static void main(String[] args) {

		Recursion rec = new Recursion();

		/** Fibonnaci */
		int fibNum = 7;
		System.out.println("Fibbonacci of " + fibNum + ", is " + rec.fib(fibNum));

		/** Step Count */
		int steps = 5;
		System.out.println("Steps " + steps + ", Possible Steps " + rec.stepCount(steps));
	}

	/** Fibinacci */
	public int fib(int num) {
		if (num <= 1) {
			return num;
		}
		return fib(num - 1) + fib(num - 2);
	}

	/**
	 * A staircase has n steps. A child can hop 1, 2, or 3 steps to reach n steps.
	 * This function calculates the possible ways to reach n steps
	 */
	/** SOLUTION! */
	// with 5 steps
	// (1,1,1,1,1)
	// (2,1,1,1) (1,2,1,1) (1,1,2,1) (1,1,1,2)
	// (2,2,1) (2,1,2) (1,2,2)
	// (3,2) (2,3) (3,1,1) (1,3,1) (1,1,3)
	public int stepCount(int steps) {

		if (steps < 0) {
			return 0;

		} else if (steps == 0 || steps == 1) {
			return 1;

		} else {
			return stepCount(steps - 1) + stepCount(steps - 2) + stepCount(steps - 3);
		}
	}

	/**
	 * Robot in a Grid: Imagine a robot sitting on the upper left corner of grid
	 * with r rows and c columns. The robot can only move in two directions, right
	 * and down, but certain cells are "off limits" such that the robot cannot step
	 * on them. Design an algorithm to find a path for the robot from the top left
	 * to the bottom right.
	 * 
	 * SOLUTION: If we picture this grid, the only way to move to spot (r,c) is by
	 * moving to one of the adjacent spots: (r-1,c) or (r,c-1)
	 */

}