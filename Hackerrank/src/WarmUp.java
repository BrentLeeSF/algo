import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WarmUp {

	public static void main(String[] args) {

		List<Integer> compareTripletA = new ArrayList<>();
		compareTripletA.add(5);
		compareTripletA.add(6);
		compareTripletA.add(7);
		List<Integer> compareTripletB = new ArrayList<>();
		compareTripletB.add(3);
		compareTripletB.add(6);
		compareTripletB.add(10);
		List<Integer> returnedTripletList = compareTriplets(compareTripletA, compareTripletB);
		System.out.println("Compate Triplets = " + returnedTripletList.get(0) + ", " + returnedTripletList.get(1));

		List<List<Integer>> diagonalDiff = new ArrayList();
		diagonalDiff.add(new ArrayList<Integer>(Arrays.asList(11, 2, 4)));
		diagonalDiff.add(new ArrayList<Integer>(Arrays.asList(4, 5, 6)));
		diagonalDiff.add(new ArrayList<Integer>(Arrays.asList(10, 8, -12)));
		System.out.println("\nDiff of 11+5+-12=4 and 4+5+10=19 = " + diagonalDifference(diagonalDiff));

		staircase(5);

		int[] minAndMaxArr = { 1, 2, 3, 4, 99999, 999999999 };
		System.out.println("\nMin and max of " + Arrays.toString(minAndMaxArr) + " is: ");
		minAndMax(minAndMaxArr);

		int[] bithdayCandles = { 3, 2, 1, 3, 6, 7, 8, 5, 8 };
		System.out.println("\nHighest birthday candles count = " + birthdayCakeCandles(bithdayCandles));
	}

	/** Return the frequency of the highest number */
	static int birthdayCakeCandles(int[] ar) {

		int tallest = 0, frequency = 0;

		for (int i = 0; i < ar.length; i++) {

			int height = ar[i];

			if (height > tallest) {
				tallest = height;
				frequency = 1;

			} else if (height == tallest) {
				frequency++;
			}
		}
		return frequency;
	}

	/**
	 * Print min and max of 1 less then size of array ex: arr = 1,2,3,4,5. Min
	 * =1+2+3+4, max = 5+4+3+2
	 */
	public static void minAndMax(int[] arr) {
		
		int total = arr.length - 1;
		int index = 0;
		long min = 0L, max = 0L;
		
		Arrays.sort(arr);
		
		for (int i = 0; i < total; i++) {
			
			min += Long.valueOf(arr[i]);
			max += Long.valueOf(arr[arr.length - 1 - i]);
		}
		System.out.println(min + " " + max);
	}

	/**
	 * Print staircase https://www.hackerrank.com/challenges/staircase/problem
	 */
	static void staircase(int n) {
		
		int zero = 0, hash = 0, num = 0;
		
		for (int i = 0; i < n; i++) {
			
			zero = i + 1;
			
			while (zero < n) {
				System.out.print(" ");
				zero++;
			}

			hash = n - i - 1;
			while (hash < n) {
				System.out.print("#");
				hash++;
			}
			System.out.println();
		}

	}

	
	/**
	 * Return the difference between the difference of left to right diagonal and
	 * right to left diagonal
	 */
	public static int diagonalDifference(List<List<Integer>> arr) {

		int leftToRight = 0, rightToLeft = 0;

		for (int i = 0; i < arr.size(); i++) {
			
			for (int j = 0; j < arr.size(); j++) {
				
				if (i == j) {
					leftToRight += arr.get(i).get(j);
				}
				
				if (j + i == arr.size() - 1) {
					rightToLeft += arr.get(i).get(j);
				}
			}
		}
		return Math.abs(leftToRight - rightToLeft);
	}
	

	/**
	 * If numbers in both lists are same, no one gets points if number in list a is
	 * bigger then number in list b, a gets a point if number in list b is bigger
	 * then number in list a, a gets b point return result in list
	 */
	static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
		
		List<Integer> returnedList = new ArrayList<>();
		int first = 0, second = 0;
		
		for (int i = 0; i < a.size(); i++) {
			if (a.get(i) == b.get(i)) {
				continue;
			}
			if (a.get(i) > b.get(i)) {
				first++;
			} else {
				second++;
			}
		}
		returnedList.add(first);
		returnedList.add(second);
		return returnedList;
	}

}
