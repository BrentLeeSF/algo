import java.util.*;

public class ArrayStuff {
    public static void main(String[] args) {
        int[] maxSumArray = {2, 1, -5, 4, -3, 1, -3, 4, -1}; //{-3, 1, -3, 4, -1, 2, 1, -5, 4};
        ArrayStuff ar = new ArrayStuff();
        System.out.println("Original Array = "+ Arrays.toString(maxSumArray));
        int[] returnedArr = ar.maxSumCircularSubarray(maxSumArray);
        int thisTotal = 0;
        for(int i = 0; i < returnedArr.length; i++) {
            thisTotal += returnedArr[i];
            System.out.print(returnedArr[i]+", ");
        }
        System.out.println("Final total = "+thisTotal);

    }

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
