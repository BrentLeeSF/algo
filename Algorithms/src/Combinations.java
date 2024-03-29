import java.util.*;

public class Combinations {

	public static void main(String[] args) {

		Combinations combo = new Combinations();

		int[] arrPermute = { 1, 2, 3, 4 };

		System.out.println("\nCombinations of "+Arrays.toString(arrPermute));
		List<List<Integer>> permuteArrayList = combo.combinationsOfNumbers(arrPermute);

		for (int i = 0; i < permuteArrayList.size(); i++) {
			for (int j = 0; j < permuteArrayList.get(i).size(); j++) {
				System.out.print(permuteArrayList.get(i).get(j) + " ");
			}
			System.out.println();
		}

		System.out.println("\nCombinations 2 - of "+Arrays.toString(arrPermute));
		ArrayList<ArrayList<Integer>> permuteArrayList2 = combo.combinationsOfNumbersTwo(arrPermute);

		for (int i = 0; i < permuteArrayList2.size(); i++) {
			for (int j = 0; j < permuteArrayList2.get(i).size(); j++) {
				System.out.print(permuteArrayList2.get(i).get(j) + " ");
			}
			System.out.println();
		}

		String letterCombo = "2345";
		System.out.println("\nGiven this Telephone Number = "+letterCombo+", These are the letter combinations");
		List<String> stringComboResult = combo.letterCombinations(letterCombo);

		for (int i = 0; i < stringComboResult.size(); i++) {
			System.out.print(stringComboResult.get(i) + ", ");
			if(i != 0 && i%9 == 0) {
				System.out.println();
			}
		}
		System.out.println();

		int[] combinationSumArray = { 10, 1, 2, 7, 6, 1, 5 };
		int combinationSumTarget = 8;
		int[] secondArray = { 2, 5, 3, 6, 4 };
		int secondTarget = 10;

		System.out.println("\nCombination of " + Arrays.toString(combinationSumArray) + " with sum of "
				+ combinationSumTarget + " is ");
		combo.combinationSum(combinationSumArray, combinationSumTarget);
		System.out
				.println("\nCombination of " + Arrays.toString(secondArray) + " with sum of " + secondTarget + " is ");
		combo.combinationSum(secondArray, secondTarget);

		int printComboArr[] = { 1, 2, 3, 4, 5 };
		int maxCombo = 3, arrLength = printComboArr.length;
		System.out.println("\nCombinations of 1,2,3,4,5 with sets of 3");
		combo.printCombination(printComboArr, arrLength, maxCombo);
		
		System.out.println("\nParenthesis Combinations");
		List<String> uh = combo.generateParenthesis(3);
		for (int i = 0; i < uh.size(); i++) {
			System.out.print(uh.get(i) + ", ");
		}
		System.out.println();

		/** PERMUTATION - FIND ALL COMBINATIONS OF GIVEN ARRAY */
		int[] permutation1Arr = { 1, 2, 3, 4 };
		System.out.println("\nMore Combinations of 1,2,3,4");
		ArrayList<ArrayList<Integer>> huh = combo.permutation1(permutation1Arr);
		for (int j = 0; j < huh.size(); j++) {
			System.out.println(huh.get(j));
		}

		System.out.println();
		int[] combinationSum = {2,3,6,7};
		//int[] combinationSum = {2,3,5};
		//int combinationSumTargetInteger = 7;
		int combinationSumTargetInteger = 8;
		List<List<Integer>> returnedCombinationSumLists = combo.combinationSumWithTarget(combinationSum, combinationSumTargetInteger);
		System.out.println("\nReturned combinations of "+Arrays.toString(combinationSum)+" with target = "+combinationSumTargetInteger+", including duplicates");
		for(int i = 0; i < returnedCombinationSumLists.size(); i++) {
			System.out.print(returnedCombinationSumLists.get(i).toString()+", ");
			System.out.println();
		}
		
		int targetSize = 5, targetLength = 3;
		System.out.println("Target Size = "+targetSize+", Length = "+targetLength);
		List<List<Integer>> combosYo = combo.combine(targetSize, targetLength);
		for (int i = 0; i < combosYo.size(); i++) {
			System.out.print("[");
			for (int j = 0; j < combosYo.get(i).size(); j++) {
				System.out.print(combosYo.get(i).get(j) + " ");
			}
			System.out.println("]");
		}
	}
	
	/**
	 * https://leetcode.com/problems/combinations/
	 * Given two integers targetSize and targetLength, return all possible 
	 * combinations of targetLength numbers chosen from the range 
	 * [1, targetSize]
	 * @param targetSize
	 * @param targetLength
	 * @return
	 */
	public List<List<Integer>> combine(int targetSize, int targetLength) {
		List<List<Integer>> list = new ArrayList<>();
        combinationHelper(list, new ArrayList<>(), targetSize, targetLength, 1);
        return list;
    }
    
	public void combinationHelper(
		List<List<Integer>> list,
		List<Integer> tempList,
		int targetSize,
		int targetLength,
		int start
	){
        if(tempList.size() == targetLength) {
        	list.add(new ArrayList<>(tempList));
        }
        
        for(int i = start; i <= targetSize; i++){
        	tempList.add(i);
            combinationHelper(list, tempList, targetSize, targetLength, ++start);
            tempList.remove(tempList.size() - 1);
        }
    }

	/** https://leetcode.com/problems/combination-sum/
	 * Given an array of distinct integers candidates and a target integer target, 
	 * return a list of all unique combinations of candidates where the 
	 * chosen numbers sum to target
	 * */
	public List<List<Integer>> combinationSumWithTarget(int[] arr, int target) {
		List<List<Integer>> ans = new ArrayList<>();
		if (arr == null || arr.length == 0) { return ans; }
		dfsCombination(arr, target, 0, 0, new ArrayList<>(), ans);
		return ans;
	}

	public void dfsCombination(int[] candidates, int target, int sum, int index, List<Integer> currentList, List<List<Integer>> ans) {
		if (target == sum) {
			ans.add(currentList);
			return;
		}
		for (int i = index; i < candidates.length; i++) {
			if (sum + candidates[i] <= target) {
				List<Integer> newList = new ArrayList<>(currentList);
				newList.add(candidates[i]);
				dfsCombination(candidates, target, sum + candidates[i], i, newList, ans);
			}
		}
	}

	/** Combinations of letters, like on a phone given certain numbers */
	public List<String> letterCombinations(String digits) {

		List<String> result = new ArrayList<String>();
		if (digits == null || digits.length() == 0) {
			return result;
		}
		String[] mapping = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		letterCombinationsRecursive(result, digits, "", 0, mapping);
		return result;
	}

	/** Combinations of letters, Helper */
	public void letterCombinationsRecursive(List<String> result, String digits, String currentString, int index,
			String[] mapping) {
		if (index == digits.length()) {
			result.add(currentString);
			return;
		}

		String letters = mapping[digits.charAt(index) - '0'];
		for (int i = 0; i < letters.length(); i++) {
			letterCombinationsRecursive(result, digits, currentString + letters.charAt(i), index + 1, mapping);
		}
	}

	/** Combinations of numbers */
	public List<List<Integer>> combinationsOfNumbers(int[] nums) {

		List<List<Integer>> totalList = new ArrayList<List<Integer>>();

		if (nums.length == 0) {
			return totalList;
		}
		List<Integer> newList = new ArrayList<Integer>();

		/** adding first element in nums and newList to totalList */
		newList.add(nums[0]);
		totalList.add(newList);

		for (int i = 1; i < nums.length; ++i) {

			List<List<Integer>> new_ans = new ArrayList<List<Integer>>();

			for (int j = 0; j <= i; ++j) {

				for (List<Integer> innerList : totalList) {
					/** new list with size */
					List<Integer> new_l = new ArrayList<Integer>(innerList);

					new_l.add(j, nums[i]);
					new_ans.add(new_l);
				}
			}
			totalList = new_ans;
		}
		return totalList;
	}

	/** Combinations of numbers */
	public ArrayList<ArrayList<Integer>> combinationsOfNumbersTwo(int[] num) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		/** start from an empty list */
		result.add(new ArrayList<Integer>());

		for (int i = 0; i < num.length; i++) {

			/** list of list in current iteration of the array num */
			ArrayList<ArrayList<Integer>> current = new ArrayList<ArrayList<Integer>>();

			for (ArrayList<Integer> innerList : result) {

				/** # of locations to insert is largest index + 1 */
				for (int j = 0; j < innerList.size() + 1; j++) {

					/** + add num[i] to index j */
					innerList.add(j, num[i]);

					ArrayList<Integer> temp = new ArrayList<Integer>(innerList);
					current.add(temp);

					/** - remove num[i] add to not add again */
					innerList.remove(j);
				}
			}
			result = new ArrayList<ArrayList<Integer>>(current);
		}
		return result;
	}

	/** Combination Sum of Numbers Given Target */
	public void combinationSum(int[] candidates, int target) {

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

	/** Combination Sum of Numbers Given Target - HELPER */
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
		List<String> finalList = new ArrayList<>();
		/**/
		parenthesisHelper(0, 0, new StringBuilder(), n, finalList);
		return finalList;
	}

	private void parenthesisHelper(int left, int right, StringBuilder sb, int n, List<String> finalList) {
		if (left == n && right == n) {
			finalList.add(new String(sb.toString()));
			return;
		}

		if (left < n) {
			sb.append("(");
			parenthesisHelper(left + 1, right, sb, n, finalList);
			sb.setLength(sb.length() - 1);
		}

		if (right < left) {
			sb.append(")");
			parenthesisHelper(left, right + 1, sb, n, finalList);
			sb.setLength(sb.length() - 1);
		}
	}

	/**
	 * PERMUTATION
	 * 
	 * Creates ArrayList within an ArrayList of integers, and calls permute(array,
	 * startIndex, ArrayList structure) Permute(arr, start, struct) is called
	 * multiple times so when it is done, it will return the entire structure
	 */
	public ArrayList<ArrayList<Integer>> permutation1(int[] arr) {
		ArrayList<ArrayList<Integer>> finalList = new ArrayList<ArrayList<Integer>>();
		permutation1(arr, 0, finalList);
		return finalList;
	}

	/**
	 * PERMUTATION
	 * 
	 * If start is same size as array of ints, then call convertArray(arr) Goes
	 * through entire array from start and swaps the integers in the array
	 */
	public void permutation1(int[] arr, int start, ArrayList<ArrayList<Integer>> finalList) {

		if (start >= arr.length) {
			ArrayList<Integer> item = permuteConvertArrayToList(arr);
			finalList.add(item);
		}

		for (int j = start; j <= arr.length - 1; j++) {
			permuteSwap(arr, start, j);
			permutation1(arr, start + 1, finalList);
			permuteSwap(arr, start, j);
		}
	}

	/**
	 * PERMUTATION Creates an ArrayList of ints and adds each int to the ArrayList
	 * and returns it
	 */
	public ArrayList<Integer> permuteConvertArrayToList(int[] arr) {
		ArrayList<Integer> item = new ArrayList<Integer>();
		for (int h = 0; h < arr.length; h++) {
			item.add(arr[h]);
		}
		return item;
	}

	/** PERMUTATION - Swaps the integers in the array */
	public void permuteSwap(int[] arr, int start, int j) {
		int temp = arr[start];
		arr[start] = arr[j];
		arr[j] = temp;
	}
}
