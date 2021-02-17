import java.util.*;

public class ArrayStuff {

    public static void main(String[] args) {

        ArrayStuff ar = new ArrayStuff();

        int[] maxSumArray = {2, 1, -5, 4, -3, 1, -3, 4, -1}; //{-3, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Original Array = "+ Arrays.toString(maxSumArray));
        int[] returnedArr = ar.maxSumCircularSubarray(maxSumArray);
        int thisTotal = 0;
        for(int i = 0; i < returnedArr.length; i++) {
            thisTotal += returnedArr[i];
            System.out.print(returnedArr[i]+", ");
        }
        System.out.println("Final total = "+thisTotal);

        String[] anagrams = {"CARS", "REPAID", "DUES", "NOSE", "SIGNED", "LANE", "PAIRED", "ARCS", "GRAB", "USED", "ONES", "BRAG", "SUED", "LEAN", "SCAR", "DESIGN"};
        ar.arrangeAnagrams(anagrams);

        String longestSubString = "abbcdafeegh";
        ar.longestDistinctSubString(longestSubString);
    }

    /* https://www.techiedelight.com/find-longest-substring-given-string-containing-distinct-characters/ */
    public void longestDistinctSubString(String str) {
        int total = 0;
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        String finalString = null;
        for(int i = 0; i < str.length(); i++) {
            if(!map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), 1);
                sb.append(str.charAt(i));
            } else {
                if(sb.toString().length() > total) {
                    finalString = sb.toString();
                    sb = new StringBuilder();
                    map = new HashMap<>();
                    total = finalString.length();
                    map.put(str.charAt(i), 1);
                    sb.append(str.charAt(i));
                }
            }
        }
        System.out.println("Longest subString of "+str+" = "+finalString);
    }

    /* https://www.techiedelight.com/group-anagrams-together-given-list-words/ */
    public void arrangeAnagrams(String[] anagrams) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        char[] arr;
        List<String> list;
        for(int i = 0; i < anagrams.length; i++) {
            arr = anagrams[i].toCharArray();
            Arrays.sort(arr);
            String newString = new String(arr);
            if(!map.containsKey(newString)) {
                list = new ArrayList<>();
                list.add(anagrams[i]);
                map.put(newString, list);
            } else {
                list = map.get(newString);
                list.add(anagrams[i]);
                map.put(newString, list);
            }
        }
        for(String thisString: map.keySet()) {
            List thisList = map.get(thisString);
            for(int j = 0; j < thisList.size(); j++) {
                System.out.print(thisList.get(j)+" ");
            }
            System.out.println();
        }
    }

    /** https://www.techiedelight.com/maximum-sum-circular-subarray/ */
    public int[] maxSumCircularSubarray(int[] arr) {
        int currentTotal = 0, maxTotal = Integer.MIN_VALUE, currentIndex = 0;
        int finalCount = arr.length*2;
        int i = 0;
        for(int thisCount = 0; thisCount < finalCount; thisCount++) {
            if(i >= arr.length) {
                i = 0;
            }
            currentTotal += arr[i];
            if(currentTotal < 0) {
                currentTotal = 0;
                currentIndex = i;
            }
            if(currentTotal > maxTotal) {
                maxTotal = currentTotal;
                currentIndex = i;
            }
            i++;
        }
        List<Integer> list = new ArrayList<>();
        while(maxTotal > 0) {
            maxTotal -= arr[currentIndex];
            list.add(arr[currentIndex]);
            currentIndex--;
            if(currentIndex < 0) {
                currentIndex = arr.length-1;
            }
        }
        int[] intArray = new int[list.size()];
        for(int j = 0; j < list.size(); j++) {
            intArray[j] = list.get(list.size()-j-1);
        }
        return intArray;
    }
}
