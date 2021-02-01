import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class Medium {

    public static void main(String[] args) {

        Medium med = new Medium();

        int[] subsetArray = {1, 2, 3};
        List<List<Integer>> hey = med.subsets(subsetArray);
        for (int i = 0; i < hey.size(); i++) {
            for (int j = 0; j < hey.get(i).size(); j++) {
                System.out.print(hey.get(i).get(j) + ", ");
            }
            System.out.println();
        }
        System.out.println();

        String[] anagrams = {"eat", "tea", "tan", "ate", "nat", "bat"};
        med.printAnagrams(anagrams);

        int[] arr = {0, 1, 0, 1, 0, 1, 99};
        System.out.println("Single number = " + med.singleNumber(arr));

        int[] closetSumArray = {-1, 2, 1, -4};
        int closestSumTarget = 1;
        System.out.println("Closest target = " + med.threeSumClosest(closetSumArray, closestSumTarget));

        int[] maxProductSubArray = {2,-3,5,1,-4};
        System.out.println("Max product of "+Arrays.toString(maxProductSubArray)+" = "+med.maximumProductSubArray(maxProductSubArray));

        int nUniquePaths = 7, mUniquePaths = 3;
        System.out.println("Unique Paths of "+nUniquePaths+", and "+mUniquePaths+" = "+med.uniquePaths(mUniquePaths,nUniquePaths));

        int[] robberArray = {2,1,1,2};
        System.out.println("Max of "+Arrays.toString(robberArray)+" = "+ med.houseRobber(robberArray));

        int powerN = -3;
        double powerX = 3.0;
        System.out.println("Power of "+powerX+" to the power of "+powerN+" = "+med.powerReturn(powerX, powerN));

        int[] containerWithMostWaterArray = {1,8,6,2,5,4,8,3,7};
        System.out.println("Container with most water from "+Arrays.toString(containerWithMostWaterArray)+" = "+med.containerWithMostWater(containerWithMostWaterArray));
    }

    /** https://leetcode.com/problems/container-with-most-water/ */
    public int containerWithMostWater(int[] height) {
        int end = height.length-1, start = 0, min = 0, total = 0, diff = 0;
        for(int i = 0; i < height.length; i++) {
            min = Math.min(height[start], height[end]);
            diff = min*(end-start);
            if(diff > total) {
                total = diff;
            }
            if(height[end] > height[start]) {
                start++;
            } else {
                end--;
            }
        }
        return total;
    }

    public double powerReturn(double x, int n) {
        double num = x;
        if(n < 0) {
            int newNum = n;
            while(newNum < -2) {
                x /= (double)num;
                newNum++;
            }
            return x;
        } else {
            while(n > 2) {
                x *= num;
                n--;
            }
            return x;
        }
    }

    /* https://leetcode.com/problems/house-robber/ */
    public int houseRobber(int[] nums) {
        if(nums == null || nums.length == 0) { return 0; }
        if(nums.length == 1) { return nums[0]; }
        if(nums.length == 2) { return Math.max(nums[0],nums[1]); }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        }
        return dp[nums.length-1];
    }

    /* https://leetcode.com/problems/unique-paths/ */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int j = 0; j < n; j++)
            dp[0][j] = 1;
        for(int i = 0;i < m; i++)
            dp[i][0] = 1;
        // add up all
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n ; j++){
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                System.out.print(dp[i][j]+", ");
            }
            System.out.println();
        }
        return dp[m-1][n-1];
    }


    /** https://leetcode.com/problems/maximum-product-subarray/ */
	public int maximumProductSubArray(int[] nums) {
		if(nums == null || nums.length == 0) return 0;
		if(nums.length == 1) return nums[0];

		int global_max = nums[0];
		int global_min = nums[0];
		int res = nums[0];
		for(int i=1; i<nums.length; i++){
			int max = global_max;
			int min = global_min;
			global_min = Math.min(Math.min(nums[i], nums[i]*min),nums[i]*max);
			global_max = Math.max(Math.max(nums[i], nums[i]*min),nums[i]*max);
			res = Math.max(res, global_max);
		}
		return res;
	}

    /**
     * https://leetcode.com/problems/3sum-closest/
     */
    public int threeSumClosest(int[] nums, int target) {
    	int sum = 0, currentSum = 0;
        Arrays.sort(nums);
        if (nums.length < 3) {
            return -1;
        }
       	sum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                currentSum = nums[i] + nums[left] + nums[right];
                if (Math.abs(target - currentSum) < Math.abs(target - sum)) {
                    sum = currentSum;
                    if (sum == target) {
                        return sum;
                    }
                } else if (target > currentSum) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return sum;
    }

    /**
     * Return only single number https://leetcode.com/problems/single-number-ii/
     */
    public int singleNumber(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
            } else {
                map.put(arr[i], map.get(arr[i]) + 1);
            }
        }
        for (Integer val : map.keySet()) {
            if (map.get(val) == 1) {
                return val;
            }
        }
        return -1;
    }

    /**
     * Print anagrams as sets. https://leetcode.com/problems/group-anagrams/
     * Ex "eat", "tea", "tan", "ate", "nat", "bat" ->
     * eat, tea, ate && tan, nat, && bat
     */
    public void printAnagrams(String[] anagrams) {

        HashMap<String, List<String>> hashin = new HashMap<>();
        List<List<String>> allAnagrams = new ArrayList<>();

        for (int i = 0; i < anagrams.length; i++) {

            char[] newString = anagrams[i].toCharArray();
            Arrays.sort(newString);
            String sorted = new String(newString);

            if (!hashin.containsKey(sorted)) {
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

    /**
     * https://leetcode.com/problems/subsets/
     */
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

        for (int i = index; i < arr.length; i++) {
            // add current
            currentArrayList.add(arr[i]);
            subsetMainFunct(i + 1, arr, currentArrayList, subsets);
            // after we added and it returns, we need to remove it from current
            currentArrayList.remove(currentArrayList.size() - 1);
        }
    }
}
