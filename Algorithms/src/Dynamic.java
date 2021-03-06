import java.util.Arrays;

/**
 * Dynamic programming is mostly just a matter of taking a recursive algorithm
 * and finding the overlapping subproblems (that is, the repeated calls). You
 * then cache those results for future recursive calls. Alternatively, you can
 * study the pattern of the recursive calls and implement something iterative.
 * You still "cache" previous work. Drawing the recursive calls as a tree is a
 * great way to figure out the runtime of a recursive algorithm. Memoization -
 * by storing the results of expensive function calls and returning the cached
 * result when the same inputs occur again.
 */

public class Dynamic {

	public static void main(String[] args) {

		Dynamic dym = new Dynamic();

		int[] absMin = { 1, -3, 71, 68, 17 };
		System.out.println("Absoulte Min = " + minimumAbsoluteDifference(absMin));

		int[] largestSumNonAdjacent = { 5, 5, 10, -100, 10, 5 };
		System.out.println("Given array: " + Arrays.toString(largestSumNonAdjacent)
				+ ", the Larkest sum of non adjacent integers is  " + largestSumOfNonAdjacent(largestSumNonAdjacent));

		System.out.println("Fibonacci modified of (i-1)^2 + i-2 = " + fibonacci(6));
		// 0,1,1,2,5,27 (0, 1, 1+1^2=2, 1+2^2=5, 2+5^2=27, 5+27^2=734
		int[] maxNonConsecSum = { 2, 7, 9, 3, 1, 10, 9 };
		System.out.println("Max Sum = " + returnBiggestNonConsecutiveSum(maxNonConsecSum));
	}

	/** fibonacci modified of (i-1)^2 + i-2 = */
	public static int fibonacci(int num) {

		int[] fib = new int[num + 1];
		fib[0] = 0;
		fib[1] = 1;

		for (int i = 2; i <= num; i++) {
			fib[i] = (fib[i - 1] * fib[i - 1]) + fib[i - 2];
		}
		return fib[num];
	}

	/** Return largest sum of non-adjacent numbers */
	public static int largestSumOfNonAdjacent(int[] arr) {

		/** includePrevious = Max sum INCLUDING the previous element */
		int includePrevious = arr[0];

		/** excludePrevious = Max sum EXCLUDING the previous element */
		int excludePrevious = 0;

		int exclude_new = 0;

		for (int i = 1; i < arr.length; i++) {

			/** current max EXCLUDING i */
			exclude_new = (includePrevious > excludePrevious) ? includePrevious : excludePrevious;

			/** current max INCLUDING i */
			includePrevious = excludePrevious + arr[i];
			excludePrevious = exclude_new;
		}

		/** return max of includePrevious and excludePrevious */
		return ((includePrevious > excludePrevious) ? includePrevious : excludePrevious);

	}

	static int minimumAbsoluteDifference(int[] arr) {

		int min = 1000, diff = 0;

		for (int i = 0; i < arr.length; i++) {

			for (int j = i + 1; j < arr.length; j++) {

				diff = Math.abs(arr[i] - arr[j]);

				if (diff < min) {
					min = diff;
				}
			}
		}
		return min;
	}

	public static int returnBiggestNonConsecutiveSum(int[] arr) {

		if (arr == null || arr.length == 0) {
			return 0;
		}
		if (arr.length == 1) {
			return arr[0];
		}
		if (arr.length == 2) {
			return Math.max(arr[0], arr[1]);
		}

		// represents max money up to the ith house
		int[] dp = new int[arr.length];
		dp[0] = arr[0];
		dp[1] = Math.max(arr[0], arr[1]);

		for (int i = 2; i < dp.length; i++) {
			// max of current and two before or sum of last
			dp[i] = Math.max(arr[i] + dp[i - 2], dp[i - 1]);
		}
		return dp[arr.length - 1];
	}

}
