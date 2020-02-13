import java.util.Arrays;

public class Dynamic {

	public static void main(String[] args) {

		Dynamic dym = new Dynamic();

		int[] absMin = { 1, -3, 71, 68, 17 };
		System.out.println("\nAbsoulte Min = " + minimumAbsoluteDifference(absMin));

		int[] largestSumNonAdjacent = { 5, 5, 10, -100, 10, 5 };
		System.out.println("Given array: " + Arrays.toString(largestSumNonAdjacent)
				+ ", the Larkest sum of non adjacent integers is  " + largestSumOfNonAdjacent(largestSumNonAdjacent));
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

}
