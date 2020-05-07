import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class Medium {

	public static void main(String[] args) {
		
		Medium med = new Medium();
		
		int[] subsetArray = {1,2,3};
		List<List<Integer>> hey = med.subsets(subsetArray);
		for(int i = 0; i < hey.size(); i++) {
			for(int j = 0; j < hey.get(i).size(); j++) {
				System.out.print(hey.get(i).get(j)+", ");
			}
			System.out.println();
		}
		System.out.println();
		
		String[] anagrams = {"eat", "tea", "tan", "ate", "nat", "bat"};
		med.printAnagrams(anagrams);
		
		int[] arr = {0,1,0,1,0,1,99};
		System.out.println("Single number = "+med.singleNumber(arr));
	}
	
	/** Return only single number https://leetcode.com/problems/single-number-ii/ */
	public int singleNumber(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < arr.length; i++) {
			if(!map.containsKey(arr[i])) {
				map.put(arr[i], 1);
			} else {
				map.put(arr[i], map.get(arr[i])+1);
			}
		}
		for(Integer val : map.keySet()) {
			if(map.get(val) == 1) {
				return val;
			}
		}
		return -1;
	}
	
	/** Print anagrams as sets. https://leetcode.com/problems/group-anagrams/
	 * Ex "eat", "tea", "tan", "ate", "nat", "bat" ->
	 * eat, tea, ate && tan, nat, && bat */
	public void printAnagrams(String[] anagrams) {
		
		HashMap<String, List<String>> hashin = new HashMap<>();
		List<List<String>> allAnagrams = new ArrayList<>();
		
		for(int i = 0; i < anagrams.length; i++) {
			
			char[] newString = anagrams[i].toCharArray();
			Arrays.sort(newString);
			String sorted = new String(newString);
			
			if(!hashin.containsKey(sorted)) {
				hashin.put(sorted, new ArrayList<>());
			}
			
			hashin.get(sorted).add(anagrams[i]);
		}
		
		allAnagrams.addAll(hashin.values());
		
		for (int i = 0; i < allAnagrams.size(); i++) {
			for (int j = 0; j < allAnagrams.get(i).size(); j++) {
				System.out.print(allAnagrams.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}
	
	/** https://leetcode.com/problems/subsets/ */
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> subsets = new ArrayList<>();
		int index = 0;
		ArrayList<Integer> currentArrayList = new ArrayList<Integer>();
		subsetMainFunct(index, nums, currentArrayList, subsets);
		return subsets;
	}

	public void subsetMainFunct(int index, int[] arr, ArrayList<Integer> currentArrayList, List<List<Integer>> subsets) {
		
		// Add copy of current subset
		subsets.add(new ArrayList<>(currentArrayList));
		
		for(int i = index; i < arr.length; i++) {
			// add current
			currentArrayList.add(arr[i]);
			subsetMainFunct(i+1, arr, currentArrayList, subsets);
			// after we added and it returns, we need to remove it from current
			currentArrayList.remove(currentArrayList.size()-1);
		}
	}
}
