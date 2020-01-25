
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Roots {
	public final double x1, x2;

	public Roots(double x1, double x2) {
		this.x1 = x1;
		this.x2 = x2;
	}
}

public class StringArray {

	static final int SIZE = 128;
	static final int OUT = 0;
	static final int IN = 1;

	String uniqueStringTest = "afg456362989";
	String uniqueStringTest2 = "abcdefg123567";

	int[] sortThis = { 3, 4, 61, 6, 8, 9, 2, 55, 7, 0, 93, 34, 5 };
	int[] lonelyIntArr = { 1, 2, 3, 4, 3, 2, 1, -1, -2, -3, -4, -3, -2, -1 };

	String compressString = "aaabbccddddeeefff";
	String compressString2 = "abcdef";
	String reverseCompress = "a3b2c2d4e3f3";
	String compressString3 = "cdefg";

	int[] primes = { 2, 4, 7, 6, 9, 11, 12, 15, 16, 17, 18, 19, 21, 22, 23 };

	int[] combinationArray = { 1, 2, 3, 4, 5 };

	String longestSub1 = "hithereyoungfella";
	String longestSub2 = "abcdereyoabdytw";
	String longestCommonSub1 = "abcdefghi";
	String longestCommonSub2 = "aaabccccddddeeeei";

	public static void main(String[] args) {

		StringArray strArr = new StringArray();

		System.out.println(
				"Unique String of: " + strArr.uniqueStringTest + " is " + strArr.uniqueString(strArr.uniqueStringTest));
		System.out.println("Unique String of: " + strArr.uniqueStringTest2 + " is "
				+ strArr.uniqueString(strArr.uniqueStringTest2));

		System.out.println("Sort " + Arrays.toString(strArr.sortThis) + " is: "
				+ Arrays.toString(strArr.selectionSort(strArr.sortThis)));

		System.out.println("lonely int = " + strArr.lonelyInt(strArr.lonelyIntArr));

		System.out
				.println("Compress " + strArr.compressString + " = " + strArr.stringCompression(strArr.compressString));
		System.out.println(
				"Compress " + strArr.compressString2 + " = " + strArr.stringCompression(strArr.compressString2));
		System.out.println("Reverse Compress " + strArr.reverseCompress + " = "
				+ strArr.reverseStringCompression(strArr.reverseCompress));

		System.out.println("Is " + strArr.compressString2 + " a substring of " + strArr.compressString + " "
				+ strArr.isSubString(strArr.compressString, strArr.compressString2));

		System.out.print("Prime numbers: ");
		ArrayList<Integer> primeNums = strArr.countPrimeNumbers(strArr.primes);
		for (int i = 0; i < primeNums.size(); i++) {
			System.out.print(primeNums.get(i) + ", ");
		}
		System.out.println();

		int arr[] = { 1, 2, 3, 4, 5 };
		int maxCombo = 3, arrLength = arr.length;
		strArr.printCombination(arr, arrLength, maxCombo);

		List<String> uh = strArr.generateParenthesis(3);
		for (int i = 0; i < uh.size(); i++) {
			System.out.print(uh.get(i) + ", ");
		}
		System.out.println();

		strArr.staircase(5);

		String[] names1 = new String[] { "Ava", "Emma", "Olivia" };
		String[] names2 = new String[] { "Olivia", "Sophia", "Emma" };
		String[] huh = strArr.uniqueNames(names1, names2); // should print Ava, Emma, Olivia, Sophia
		for (int k = 0; k < huh.length; k++) {
			System.out.print(huh[k] + ", ");
		}
		System.out.println();

		Roots roots = strArr.findRoots(2, 10, 8);
		System.out.println("Roots: " + roots.x1 + ", " + roots.x2);

		int[] students = { 4, 73, 67, 38, 33 };
		strArr.gradingStudents(students);

		int mat[][] = { { 4, 0, 0, 0 }, { 0, 7, 0, 0 }, { 0, 0, 5, 0 }, { 0, 0, 1, 1 } };

		if (strArr.isDiagonalMatrix(mat, 4)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}

		System.out.println("4^3 = " + strArr.power(4, 3));

		System.out.println("Longest SubString of " + strArr.longestSub1 + " and " + strArr.longestSub2 + " is "
				+ strArr.longestSubString(strArr.longestSub1, strArr.longestSub2));

		System.out
				.println("Longest common sub array of " + strArr.longestCommonSub1 + " and " + strArr.longestCommonSub2
						+ " is " + strArr.longestCommonSub(strArr.longestCommonSub1, strArr.longestCommonSub2));

		String stringCharAndWordCount = "Abracadabra       Alakazam!!  i  ";
		System.out.println("\nIn Order Character and Word Count of: " + stringCharAndWordCount);
		printCharWithFreq(stringCharAndWordCount);

		int[] combinationSum = { 10, 1, 2, 7, 6, 1, 5 };
		int combinationSumTarget = 8;
		System.out.println(
				"Combination of " + Arrays.toString(combinationSum) + " with sum of " + combinationSumTarget + " is ");
		strArr.combinationSum2(combinationSum, combinationSumTarget);

		System.out.println("\nCombinations");
		int[] arrPermute = { 1, 2, 3, 4 };
		ArrayList<ArrayList<Integer>> permuteArrayList = new ArrayList<ArrayList<Integer>>();
		permuteArrayList = strArr.permute(arrPermute);
		for (List<Integer> innerList : permuteArrayList) {
			for (Integer number : innerList) {
				System.out.print(number + ", ");
			}
			System.out.println();
		}
	}

	/** Prints the character, its frequency in order, and word count */
	static void printCharWithFreq(String str) {

		int characterCount = 0;
		int state = OUT;
		int wordCount = 0;
		int n = str.length();

		/** 'freq[]' implemented as hash table */
		int[] freq = new int[SIZE];

		/** accumulate freqeuncy of each character in 'str' */
		for (int i = 0; i < n; i++) {

			/** If not space, */
			if (str.charAt(i) != 32) {
				freq[str.charAt(i)]++;
				characterCount++;
			}
			if (str.charAt(i) == ' ' || str.charAt(i) == '\n' || str.charAt(i) == '\t') {
				state = OUT;

			} else if (state == OUT) {
				state = IN;
				++wordCount;
			}
		}

		/** traverse 'str' from left to right */
		for (int i = 0; i < n; i++) {

			// System.out.println("- "+freq[str.charAt(i) - 0]);
			/** if frequency of character str.charAt(i) is not equal to 0 */
			if (freq[str.charAt(i) - 0] != 0) {

				/** print the character along with its frequency */
				System.out.print(str.charAt(i) + "=");
				System.out.print(freq[str.charAt(i)] + ", ");

				/**
				 * update frequency of str.charAt(i) to 0 so the same character is not printed
				 * again
				 */
				freq[str.charAt(i)] = 0;
			}
		}
		System.out.println("\nCharacter Count = " + characterCount + ", Word Count = " + wordCount + "\n\n");
	}

	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		/** start from an empty list */
		result.add(new ArrayList<Integer>());

		for (int i = 0; i < num.length; i++) {

			/** list of list in current iteration of the array num */
			ArrayList<ArrayList<Integer>> current = new ArrayList<ArrayList<Integer>>();

			for (ArrayList<Integer> l : result) {

				/** # of locations to insert is largest index + 1 */
				for (int j = 0; j < l.size() + 1; j++) {

					/** + add num[i] to different locations */
					l.add(j, num[i]);

					ArrayList<Integer> temp = new ArrayList<Integer>(l);
					current.add(temp);

					/** - remove num[i] add to not add again */
					l.remove(j);
				}
			}

			result = new ArrayList<ArrayList<Integer>>(current);
		}

		return result;
	}

	/** Longest common substring */
	public String longestCommonSub(String arr1, String arr2) {

		int j = 0;
		StringBuilder str = new StringBuilder();
		System.out.println(arr2);

		for (int i = 0; i < arr1.length(); i++) {

			char a = arr1.charAt(i);
			j = i;

			while (j < arr2.length() && a != arr2.charAt(j)) {
				j++;
			}
			if (j < arr2.length() && a == arr2.charAt(j)) {
				str.append(arr2.charAt(j));
			} else {
				return str.toString();
			}
		}
		return str.toString();
	}

	public int longestSubString(String sub1, String sub2) {

		int iCount = 0, totalCount = 0;
		int countin = 0;

		for (int i = 0; i < sub1.length(); i++) {

			int jCount = 0;
			iCount = i;

			while (jCount < sub1.length() && jCount < sub2.length() && iCount < sub1.length()) {
				if (sub1.charAt(iCount) == sub2.charAt(jCount)) {
					totalCount++;
					iCount++;
				}
				jCount++;
			}

			if (totalCount > countin) {
				countin = totalCount;
			}
			totalCount = 0;
		}
		return countin;
	}

	public int power(int b, int e) {
		if (e == 0) {
			return 1;
		} else {
			return (b * power(b, e - 1));
		}
	}

	public boolean isDiagonalMatrix(int mat[][], int N) {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if ((i != j) && (mat[i][j] != 0)) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * If students grade < 38, return grade. If student's grade 1-2 points below %5
	 * increase grade to %5
	 */
	public void gradingStudents(int[] grades) {

		List<Integer> l1 = new ArrayList<Integer>();
		int num = 0;

		for (int i = 0; i < grades.length; i++) {
			num = grades[i];

			if (num >= 38 && num % 5 > 2) {
				int diff = Math.abs((num % 5) - 5);
				num += diff;
				l1.add(num);
			} else {
				l1.add(num);
			}
		}
		for (int i = 0; i < l1.size(); i++) {
			System.out.print(l1.get(i) + ", ");
		}
		System.out.println();
	}

	public Roots findRoots(double a, double b, double c) {
		double r1 = (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
		double r2 = (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);
		System.out.println("First root = " + r1);
		System.out.println("Second root = " + r2);
		Roots roo = new Roots(r1, r2);
		return roo;
	}

	/**
	 * 1. Merge NamesARRAYS Implement the uniqueNames method. When passed two arrays
	 * of names, it will return an array containing the names that appear in either
	 * or both arrays. The returned array should have no duplicates. For example,
	 * calling MergeNames.uniqueNames(new String[]{'Ava', 'Emma', 'Olivia'}, new
	 * String[]{'Olivia', 'Sophia', 'Emma'}) should return an array containing Ava,
	 * Emma, Olivia, and Sophia in any order.
	 */
	public String[] uniqueNames(String[] names1, String[] names2) {

		HashMap<String, Integer> hashin = new HashMap<String, Integer>();

		for (int i = 0; i < names1.length; i++) {
			String name1 = names1[i];
			hashin.put(name1, 1);
		}
		for (int k = 0; k < names2.length; k++) {
			String name2 = names2[k];
			if (!hashin.containsKey(name2)) {
				hashin.put(name2, 1);
			}
		}

		int size = hashin.size();
		String[] newArray = new String[size];

		Set<String> allKeys = hashin.keySet();
		int i = 0;
		for (String key : allKeys) {
			newArray[i] = key;
			i++;
		}
		return newArray;
	}

	public void combinationSum2(int[] candidates, int target) {

		List<List<Integer>> totalResult = new ArrayList<List<Integer>>();
		List<Integer> currentList = new ArrayList<Integer>();

		Arrays.sort(candidates);
		combinationSumHelper(candidates, 0, target, currentList, totalResult);

		for (int i = 0; i < totalResult.size(); i++) {
			for (int j = 0; j < totalResult.get(i).size(); j++) {
				System.out.print(totalResult.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}

	public void combinationSumHelper(int[] candidates, int index, int target, List<Integer> currentList,
			List<List<Integer>> totalResult) {

		/**
		 * If found combinations we want, create a new ArrayList and add to totalResult
		 */
		if (target == 0) {
			totalResult.add(new ArrayList<Integer>(currentList));
			return;
		}

		/** If taken in too many numbers, more than target, return */
		if (target < 0) {
			return;
		}

		/** DFS */
		for (int i = index; i < candidates.length; i++) {

			/**
			 * check for duplicates if at first or if current and previous are not same
			 */
			if (i == index || candidates[i] != candidates[i - 1]) {

				currentList.add(candidates[i]);

				/** return next index and new target of target - candidate we just added */
				combinationSumHelper(candidates, i + 1, target - candidates[i], currentList, totalResult);

				/** When recursive call returns we want to remove the number we just added */
				currentList.remove(currentList.size() - 1);
			}
		}
	}

	/**
	 * The main function that prints all combinations of size r in arr[] of size n.
	 * This function mainly uses combinationUtil()
	 */
	public void printCombination(int arr[], int n, int maxCombo) {

		int data[] = new int[maxCombo];
		combinationUtil(arr, n, maxCombo, 0, data, 0);

	}

	/**
	 * arr[] ---> Input Array data[] ---> Temporary array to store current
	 * combination start & end ---> Staring and Ending indexes in arr[] index --->
	 * Current index in data[] maxCombo ---> Size of a combination to be printed
	 */
	public void combinationUtil(int arr[], int n, int maxCombo, int index, int[] data, int i) {

		/** Current index combination is ready to be printed */
		if (index == maxCombo) {
			for (int j = 0; j < maxCombo; j++) {
				System.out.print(data[j] + " ");
			}
			System.out.println();
			return;
		}

		/** When no more elements can be put in data[] */
		if (i >= n) {
			return;
		}

		/** current index is included, put next location */
		data[index] = arr[i];
		combinationUtil(arr, n, maxCombo, index + 1, data, i + 1);

		/**
		 * current index is excluded, replace it with next (Note that i+1 is passed, but
		 * index is not changed)
		 */
		combinationUtil(arr, n, maxCombo, index, data, i + 1);

	}

	/**
	 * Given n pairs of parentheses, write a function to generate all combinations
	 * of well-formed parentheses. For example, given n = 3, a solution set is: [
	 * "((()))", "(()())", "(())()", "()(())", "()()()" ]
	 */
	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		parenthesisHelper(0, 0, new StringBuilder(), n, res);
		return res;
	}

	private void parenthesisHelper(int left, int right, StringBuilder sb, int n, List<String> res) {
		if (left == n && right == n) {
			res.add(new String(sb.toString()));
			return;
		}

		if (left < n) {
			sb.append("(");
			parenthesisHelper(left + 1, right, sb, n, res);
			sb.setLength(sb.length() - 1);
		}

		if (right < left) {
			sb.append(")");
			parenthesisHelper(left, right + 1, sb, n, res);
			sb.setLength(sb.length() - 1);
		}
	}

	public void staircase(int n) {

		for (int i = 0; i < n; i++) {

			int spaces = n - 1 - i;
			while (spaces > 0) {
				System.out.print(" ");
				spaces--;
			}

			int stairs = i;
			while (stairs >= 0) {
				System.out.print("#");
				stairs--;
			}
			System.out.println();
		}
	}

	/** Returns true if every character in string is unique */
	public boolean uniqueString(String thisUnique) {

		char[] testUniqueChar = new char[128];
		int thisChar = 0;

		for (int i = 0; i < thisUnique.length(); i++) {
			thisChar = thisUnique.charAt(i);
			if (testUniqueChar[thisChar] > 0) {
				return false;
			}
			testUniqueChar[thisChar]++;
		}
		return true;
	}

	/** Sorts array with selection sort */
	public int[] selectionSort(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
		System.out.println();
		return arr;
	}

	/** Return the non duplicate value in array */
	public String lonelyInt(int[] arr) {

		HashMap<Integer, Integer> mappin = new HashMap<Integer, Integer>();
		int save = 0;

		for (int i = 0; i < arr.length; i++) {
			save = arr[i];
			if (mappin.containsKey(save)) {
				mappin.put(arr[i], -1);
			} else {
				mappin.put(arr[i], 1);
			}
		}

		StringBuilder str = new StringBuilder();
		Set<Integer> allKeys = mappin.keySet();

		for (Integer key : allKeys) {
			if (mappin.get(key) == 1) {
				str.append(key + ", ");
			}
		}
		return str.toString();
	}

	/** Compresses string ex. aaabbcccc -> a3b2c4 */
	public String stringCompression(String compressThis) {

		StringBuilder str = new StringBuilder();
		char thisChar = 'a';
		int count = 0;
		for (int i = 0; i < compressThis.length(); i++) {
			thisChar = compressThis.charAt(i);
			count = 1;
			while (i + 1 < compressThis.length() && thisChar == compressThis.charAt(i + 1)) {
				count++;
				i++;
			}
			str.append(thisChar);
			str.append(count);
			count = 0;
		}
		return str.length() < compressThis.length() ? str.toString() : compressThis;
	}

	/**
	 * Reveres compressed string to regular string ex. a3b2c4 -> aaabbcccc
	 */
	public String reverseStringCompression(String compressThis) {

		StringBuilder str = new StringBuilder();
		char letter = 'a';
		int count = 1;

		for (int i = 0; i < compressThis.length(); i++) {

			letter = compressThis.charAt(i);

			if (i + 1 < compressThis.length()) {
				i++;
				count = compressThis.charAt(i) - '0';
				count--;
				str.append(letter);

				while (count > 0) {
					str.append(letter);
					count--;
				}
			}
		}
		return str.toString();
	}

	/**
	 * check if both a1 and b2 are not empty loop through a1, get first a1 index and
	 * while a1 index and b2 index are same, loop through both
	 */
	public boolean isSubString(String a1, String b2) {

		if (a1.isEmpty() || b2.isEmpty()) {
			return false;
		}

		int countB = 0;
		char b = 'b';
		for (int i = 0; i < a1.length(); i++) {
			char a = a1.charAt(i);
			if (countB < b2.length()) {
				b = b2.charAt(countB);
			}
			while (a != b && i < a1.length() && countB < b2.length()) {
				a = a1.charAt(i);
				i++;
			}
			if (a == b) {
				countB++;
			}
		}
		return countB - 1 == b2.length();
	}

	/** Returns an ArrayList of all prime numbers */
	public ArrayList<Integer> countPrimeNumbers(int[] arr) {

		ArrayList<Integer> allPrimes = new ArrayList<Integer>();
		int count = 0, prime = 0, divide = 0;

		for (int i = 0; i < arr.length; i++) {

			prime = arr[i];
			divide = prime - 1;
			count = 0;

			while (divide > 1) {
				if (prime % divide == 0) {
					count++;
				}
				divide--;
			}
			if (count == 0) {
				allPrimes.add(prime);
			}
		}
		return allPrimes;
	}

}
