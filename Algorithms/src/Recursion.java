/** NOTE: if the problem states: 
 * Design an algorithm to compute the nth ..""Write code to list the first n..." 
 * "Implement a method to compute all...", and so on.
 * It's probably recursion
 * 
 * In addition to top-down and bottom-up approaches, 
 * it's often effective to divide the data set in half. 
 * 
 *  All recursive algorithms can be implemented iteratively, 
 *  although sometimes the code to do so is much more complex 
 *  
 *  Drawing the recursive calls as a tree is a great way to figure out the runtime of a recursive algorithm. 
 *  
 *  Memoization - by storing the results of expensive function calls and returning the cached result when the same inputs occur again.*/

/** Bottom-Up Approach:
 * We start with knowing how to solve the problem for a simple case, 
 * like a list with only one element. 
 * Then we figure out how to solve the problem for two elements, 
 * then for three elements, and so on. 
 * The key here is to think about how you can build the solution for one case 
 * off of the previous case (or multiple previous cases). */

/**
 * Top-Down Approach: Can be more complex. In these problems, we think about how
 * we can divide the problem for case N into subproblems. Be careful of overlap
 * between the cases.
 */

public class Recursion {

	public static void main(String[] args) {

		Recursion rec = new Recursion();

		/** Fibonnaci */
		int fibNum = 9;
		System.out.println("Fibbonacci of " + fibNum + ", is " + rec.fib(fibNum));
		System.out.println("Fibbonacci Iteratively of " + fibNum + ", is " + rec.fibIterativeley(fibNum));

		/** Step Count */
		int steps = 5;
		System.out.println("Steps " + steps + ", Possible Steps " + rec.stepCount(steps));
		System.out.println("Steps " + steps + ", Possible Steps " + rec.climbStairs(steps));

		System.out.println("Greatest Common Divisor of 156 and 36 is " + rec.greatestCommonDivisor(156, 36));
		int[] stockPrices = {7,1,5,3,6,4};
		System.out.println("Buy and sell stock with highest value = "+rec.maxProfit(stockPrices));
	}

	/** Return Greatest Common Divisor */
	public int greatestCommonDivisor(int x, int y) {
		return y == 0 ? x : greatestCommonDivisor(y, x % y);
	}

	/** Fibinacci */
	public int fib(int num) {
		if (num <= 1) {
			return num;
		}
		return fib(num - 1) + fib(num - 2);
	}

	public int fibIterativeley(int num) {

		if (num <= 1)
			return num;

		int[] iter = new int[num + 2];
		iter[0] = 0;
		iter[1] = 1;

		for (int i = 2; i <= num; i++) {
			iter[i] = iter[i - 1] + iter[i - 2];
		}
		return iter[num];
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

	/** Climbing 3 stairs NON-recursion */
	public int climbStairs(int n) {

		int[] matrix = new int[n];

		if (n < 3) {
			return n;
		}

		matrix[0] = 1;
		matrix[1] = 2;
		matrix[2] = 4;

		for (int i = 3; i < matrix.length; i++) {
			matrix[i] = matrix[i - 1] + matrix[i - 2] + matrix[i - 3];
		}
		return matrix[n - 1];
	}

	/** Buy stock on cheapest day, sell at highest value */
	public int maxProfit(int[] prices) {

		int max = 0, min = Integer.MAX_VALUE;

		for (int i = 0; i < prices.length; i++) {

			if (prices[i] < min) {
				min = prices[i];
			} else {
				max = Math.max(max, prices[i] - min);
			}
		}
		return max;
	}

}