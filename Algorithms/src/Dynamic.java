import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Dynamic {

	public static void main(String[] args) {

		Dynamic dym = new Dynamic();

		int[] firstArray = { 1, 2, 3 };
		int[] thisArray = { 2, 5, 3, 6 };
		// 22222, 2233, 226, 235, 55
		int[] secondArray = { 2, 5, 3, 6, 4 };
		// 22222, 2224, 2233, 226, 235, 244, 334, 55, 64,
		// System.out.println("Combinations of 4 with list 1,2,3 = " +
		// dym.max(firstArray, 4));
		System.out.println("Combinations of 10 with list 1,5,3,6 = " + dym.max(secondArray, 10));
		List<Long> uh = new ArrayList<>();
		uh.add(2L);
		uh.add(5L);
		uh.add(3L);
		uh.add(6L);
		uh.add(4L);
		System.out.println("Combinations of 10 with list 1,5,3,6 = " + dym.max(secondArray, 10));
	}

	/**
	 * https://www.geeksforgeeks.org/understanding-the-coin-change-problem-with-dynamic-programming/
	 */
	public static int max(int[] coins, int target) {

		/** Create the ways array to 1 plus the amount to stop overflow */
		int[] numCoins = new int[target + 1];

		/**
		 * Set the first way to 1 because its 0 and there is 1 way to make 0 with 0
		 * coins
		 */
		numCoins[0] = 1;

		/** Go through all of the coins */
		for (int i = 0; i < coins.length; i++) {

			/** Make a comparison to each index value of ways with the coin value. */
			for (int j = 0; j < numCoins.length; j++) {

				if (coins[i] <= j) {
					/** Update the ways array */
					numCoins[j] += numCoins[j - coins[i]];
				}
			}
		}

		/** return the value at the Nth position of the ways array. */
		return numCoins[target];
	}

	public static long numWays(int n, int[] coins) {
		if (n < 0) {
			return 0;
		}
		return numWays(n, coins, 0, new HashMap<String, Long>());
	}

	public static long numWays(int n, int[] coins, int coinNumber, HashMap<String, Long> cache) {
		/* Check our cache */
		String key = n + "," + coinNumber;
		if (cache.containsKey(key)) {
			return cache.get(key);
		}
		/* Base case */
		if (coinNumber == coins.length - 1) {
			if (n % coins[coinNumber] == 0) {
				cache.put(key, 1L);
				return 1;
			} else {
				cache.put(key, 0L);
				return 0;
			}
		}
		/* Recursive case */
		long ways = 0;
		for (int i = 0; i <= n; i += coins[coinNumber]) {
			ways += numWays(n - i, coins, coinNumber + 1, cache);
		}
		/* Cache and return solution */
		cache.put(key, ways);
		return ways;
	}

}
