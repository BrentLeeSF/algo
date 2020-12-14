import java.util.*;

public class Easy {

	public static void main(String[] args) {
		
		Easy es = new Easy();
		
		int[] stocks = { 7, 1, 5, 3, 6, 4 };
		System.out.println("The total profit of buying at cheapest and selling at lowest = "+es.buySellStocks(stocks));

		String heyWorld = "Hello Worldss   ";
		System.out.println("length of last string of " + heyWorld + " = " + es.lengthLastWord(heyWorld));

		String palindromeTest = "0P";
		String palindromeTest2 = "A man, a plan, a canal: Panama";
		System.out.println("Is "+palindromeTest2+" a palendrome? Ans = "+es.validatePalendrome(palindromeTest2));
		
		int[] robHousesArray = {2,7,9,3,1};
		System.out.println("Total of every other house = "+es.robHouses(robHousesArray));

		int[] twoSumNumsArray = {2,7,11,15};
		int twoSumNumsTarget = 26;
		int[] twoSumNumsReturnedArray = es.twoSumNums(twoSumNumsArray, twoSumNumsTarget);
		System.out.println("Two Sum Nums values are: "+twoSumNumsArray[twoSumNumsReturnedArray[0]]+ " and "+twoSumNumsArray[twoSumNumsReturnedArray[1]]+" = "+twoSumNumsTarget);
	}

	/** https://leetcode.com/problems/house-robber/ */
	public int robHouses(int[] arr) {
		
		if(arr.length == 0) return 0;
		if(arr.length == 1) return arr[0];
		
		int[] returnSum = new int[arr.length];
		returnSum[0] = arr[0];
		returnSum[1] = Math.max(arr[0], arr[1]);
		
		for(int i = 2; i < arr.length; i++) {
			returnSum[i] = Math.max(returnSum[i-2] + arr[i], returnSum[i-1]);
		}
		return returnSum[arr.length-1];
	}

	public int[] twoSumNums(int[] nums, int target) {

		if(nums == null || nums.length < 2) { return null; }
		if(nums.length == 2 && nums[1]+nums[0] != target) { return null; }

		int needed = 0;
		int[] arr = new int[2];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < nums.length; i++) {
			needed = target - nums[i];
			if(map.containsKey(needed)) {
				arr[0] = map.get(needed);
				arr[1] = i;
				return arr;
			}
			if(!map.containsKey(nums[i])) {
				map.put(nums[i], i);
			}
		}
		return arr;
	}
	
	/**
	 * Return true if palindrome (same forwards and backwards)
	 * https://leetcode.com/problems/valid-palindrome/
	 */
	public boolean validatePalendrome(String s) {
		
		s = s.replaceAll("[^A-Za-z0-9]+", "").toUpperCase();
		char a = 'a', b = 'b';
		
		for (int i = 0; i < s.length(); i++) {
			
			a = s.charAt(i);
			b = s.charAt(s.length() - i - 1);
			
			if (a != b) {
				return false;
			}
		}
		return true;
	}

	public int buySellStocks(int[] prices) {

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

	public int lengthLastWord(String s) {
		String[] splited = s.split("\\s+");
		String hey = splited[splited.length - 1];
		if (hey.equals(" ")) {
			return 1;
		}
		return hey.length() > 0 ? hey.length() : 0;
	}
}
