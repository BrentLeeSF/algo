
import java.util.*;

class Roots {

    public final double x1, x2;

    public Roots(double x1, double x2) {
        this.x1 = x1;
        this.x2 = x2;
    }
}

class ReturnSum {

    int index;
    int totalSum;
    ArrayList<Integer> list;

    public ReturnSum(int index, int totalSum, ArrayList<Integer> list) {
        this.index = index;
        this.totalSum = totalSum;
        this.list = list;
    }
}

public class StringArray {

    String uniqueStringTest = "afg456362989";
    String uniqueStringTest2 = "abcdefg123567";

    int[] sortThis = {3, 4, 61, 6, 8, 9, 2, 55, 7, 0, 93, 34, 5};
    int[] lonelyIntArr = {1, 2, 3, 4, 3, 2, 1, -1, -2, -3, -4, -3, -2, -1};

    String compressString = "aaabbccddddeeefff";
    String compressString2 = "abcdef";
    String reverseCompress = "a3b2c2d4e3f3";
    String compressString3 = "cdefg";

    int[] primes = {2, 4, 7, 6, 9, 11, 12, 15, 16, 17, 18, 19, 21, 22, 23};

    int[] combinationArray = {1, 2, 3, 4, 5};

    String longestSub1 = "hithereyoungfella";
    String longestSub2 = "abcdabdyereyotw";
    String longestCommonSub1 = "abcdefghi";
    String longestCommonSub2 = "aaabccccddddeeeei";

    public static void main(String[] args) {

        StringArray strArr = new StringArray();

        System.out.println(
                "5%1 = 0 - " + 5 % 1 + ", 5%2 = 1 - " + 5 % 2 + ", 5%3 = 2 - " + 5 % 3 + ", 5%4 = 1 - " + 5 % 4);

        System.out.println(
                "Unique String of: " + strArr.uniqueStringTest + " is " + strArr.uniqueString(strArr.uniqueStringTest));
        System.out.println("Unique String of: " + strArr.uniqueStringTest2 + " is "
                + strArr.uniqueString(strArr.uniqueStringTest2));

        System.out.println("Sort " + Arrays.toString(strArr.sortThis) + " is: "
                + Arrays.toString(strArr.selectionSort(strArr.sortThis)));

        System.out.println("\nlonely int of " + Arrays.toString(strArr.lonelyIntArr) + " = "
                + strArr.lonelyInt(strArr.lonelyIntArr));

        System.out.println(
                "\nCompress " + strArr.compressString + " = " + strArr.stringCompression(strArr.compressString));
        System.out.println(
                "Compress " + strArr.compressString2 + " = " + strArr.stringCompression(strArr.compressString2));
        System.out.println("Reverse Compress " + strArr.reverseCompress + " = "
                + strArr.reverseStringCompression(strArr.reverseCompress));

        System.out.println("Is " + strArr.compressString2 + " a substring of " + strArr.compressString + " "
                + strArr.isSubString(strArr.compressString, strArr.compressString2));

        System.out.print("\nPrime numbers of " + Arrays.toString(strArr.primes) + " is\n");
        ArrayList<Integer> primeNums = strArr.countPrimeNumbers(strArr.primes);
        for (int i = 0; i < primeNums.size(); i++) {
            System.out.print(primeNums.get(i) + ", ");
        }
        System.out.println();

        String[] names1 = new String[]{"Ava", "Emma", "Olivia"};
        String[] names2 = new String[]{"Olivia", "Sophia", "Emma"};
        String[] huh = strArr.uniqueNames(names1, names2); // should print Ava, Emma, Olivia, Sophia
        System.out.println();
        for (int k = 0; k < huh.length; k++) {
            System.out.print(huh[k] + ", ");
        }
        System.out.println("\n");

        Roots roots = strArr.findQuadraticRoots(2, 10, 8);
        System.out.println("\nRoots: " + roots.x1 + ", " + roots.x2);

        int squareRootNum = 17;
        System.out.println("\nFind Square roots of " + squareRootNum + " = " + strArr.findSquareRoot(squareRootNum));

        int[] students = {4, 73, 67, 38, 33};
        System.out.println("\nStudents problem");
        strArr.gradingStudents(students);

        System.out.println("4^3 = " + strArr.power(4, 3) + "\n");

        System.out.println("Longest SubString LENGTH of " + strArr.longestSub1 + " and " + strArr.longestSub2 + " is "
                + strArr.longestSubString(strArr.longestSub1, strArr.longestSub2));

        System.out
                .println("Longest common sub array of " + strArr.longestCommonSub1 + " and " + strArr.longestCommonSub2
                        + " is " + strArr.longestCommonSub(strArr.longestCommonSub1, strArr.longestCommonSub2));

        String stringCharAndWordCount = "Abracadabra       Alakazam!!  i  ";
        System.out.println("\nIn Order Character and Word Count of: " + stringCharAndWordCount);
        printCharWithFreq(stringCharAndWordCount);

        // stock prices on consecutive days
        int stockPrices[] = {695, 100, 180, 260, 310, 535, 40};
        System.out.println(Arrays.toString(stockPrices));
        strArr.stockBuySell(stockPrices);

        int[] largestSum = {-3, 6, -1, -2, -3, 5, 1, -5, 8, -1};
        System.out.println(
                "The largest sum of " + Arrays.toString(largestSum) + ", is " + strArr.returnLargestSum(largestSum));

        // int[] binSearch = { 2, 3, 4, 10, 40 };
        int[] binSearch = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Binary Search from 0-10 = " + strArr.binarySearch(binSearch, 3));

        String reverseThis = "Reverse This String";
        System.out.println("\nreverse of: " + reverseThis + " = " + strArr.reverseString(reverseThis));

        String letterChange = "ExchangeZ Lettersz";
        System.out.println("ExchangeZ lettersz: " + letterChange + " = " + strArr.letterExchange(letterChange));

        int power1 = 64;
        int power2 = 63;
        System.out.println("is " + power1 + " a power of 2? = " + strArr.powerOfTwo(power2));

        System.out.println(strArr.FirstReverseString("INPUT HERE"));
        System.out.println(strArr.FirstReverseString("Input Here"));
        System.out.println(strArr.increaseLetterByOne("INPUT HERE"));
        System.out.println(strArr.increaseLetterByOne("input herez"));

        int[] nums1MergeArray = {1, 2, 3, 0, 0, 0};
        int[] nums2MergeArray = {2, 5, 6, 2, 4, 1};
        strArr.mergeTwoArraysInOrder(nums1MergeArray, nums2MergeArray);

        int largestSumArr[] = {1, 2, 3, 1, 3, 2, 5, 0, 1, 2};
        int arraySize = 8;

        ReturnSum finalTest = strArr.returnLargestSumFromArray(largestSumArr, arraySize, new ArrayList<Integer>());

        if (finalTest != null) {
            System.out.println("Largest sum starting from index = " + finalTest.index + ", Total sum = " + finalTest.totalSum + " list size = " + finalTest.list.size());
            for (int i = 0; i < finalTest.list.size(); i++) {
                System.out.print(finalTest.list.get(i) + ", ");
            }

        } else {
            System.out.println("Please enter a valid array and/or number to search from the array");
        }

        int[] maxAreaArray = {1,5,2,8,6,2,4,8,3,7};
        System.out.println("Max area from "+Arrays.toString(maxAreaArray)+" = "+strArr.maxArea(maxAreaArray));

        String palindromePermutationString = "raceCars aree ears";
        System.out.println("Is "+palindromePermutationString+" a palindrome Permutation? = "+strArr.palindromePermutation(palindromePermutationString));

        String rotateString = "watterbottles";
        String rotateThisString = "ottleswatterb";
        System.out.println("Is "+rotateString+" a rotation of "+rotateThisString+" = "+strArr.rotateThisString(rotateString, rotateThisString));
        
        String romanNumeralThree = "III";
        System.out.println("Roman Numeral of  "+romanNumeralThree+" = "+strArr.romanToInt(romanNumeralThree));
        String romanNumeralNine = "IX";
        System.out.println("Roman Numeral of  "+romanNumeralNine+" = "+strArr.romanToInt(romanNumeralNine));
        String romanNumeralFourNineNine = "CDXCIX";
        System.out.println("Roman Numeral of  "+romanNumeralFourNineNine+" = "+strArr.romanToInt(romanNumeralFourNineNine));
        String romanNumeralOneNineNineFour = "MCMXCIV";
        System.out.println("Roman Numeral of  "+romanNumeralOneNineNineFour+" = "+strArr.romanToInt(romanNumeralOneNineNineFour));
        
        String longestPalindromeOne = "babad";
        String longestPalindromeTwo = "cbbd";
        System.out.println("longest Palindrome of "+longestPalindromeOne+" = "+strArr.longestPalindromicSubstring(longestPalindromeOne));
        System.out.println("longest Palindrome of "+longestPalindromeTwo+" = "+strArr.longestPalindromicSubstring(longestPalindromeTwo));
        
        System.out.println("Does this string have all unique characters - "+strArr.uniqueStringTest+" - "+strArr.doesStringHaveAllUniqueCharacters(strArr.uniqueStringTest));
        System.out.println("Does this string have all unique characters - "+strArr.uniqueStringTest2+" - "+strArr.doesStringHaveAllUniqueCharacters(strArr.uniqueStringTest2));
        String permString1 = "abcd";
        String permString2 = "adcb";
        System.out.println("is "+permString1+" a permutation of "+permString2+" - "+strArr.areTheseStringsPermutations(permString1, permString2));
    }
    
    /**
     * Determine if string has all unique characters
     */
    public boolean doesStringHaveAllUniqueCharacters(String s) {
    	HashMap<Integer, Integer> uniqueMap = new HashMap<Integer, Integer>();
    	for(int i = 0; i < s.length(); i++) {
    		if (uniqueMap.get((int)s.charAt(i)) != null) {
    			return false;
    		}
    		uniqueMap.put((int)s.charAt(i), 1);
    	}
    	return true;
    }
    
    /**
     * Determine if 2 strings are permutations of each other
     * WITHOUT datastructures
     */
    public boolean areTheseStringsPermutations(String s1, String s2) {
    	if (s1.length() != s2.length()) {
    		return false;
    	}
    	char[] chars = s1.trim().toCharArray();
        Arrays.sort(chars);
        String sorted1 = new String(chars);
        
        char[] chars2 = s2.trim().toCharArray();
        Arrays.sort(chars2);
        String sorted2 = new String(chars2);
    	return sorted1.equals(sorted2);
    }
    
    /**
     * 5. Longest Palindromic Substring
	 * https://leetcode.com/problems/longest-palindromic-substring/
	 * return longest palindrone of substring (reads same forwards and backwards)
     */
    public String longestPalindromicSubstring(String s) {
    	
    	StringBuilder sbFirst = new StringBuilder();
        StringBuilder sbLast = new StringBuilder();
        
        char first = 'a', last = 'b';
        boolean isOdd = (s.length()-1)%2 == 0 ? true : false;
        char mid = s.charAt(s.length()/2);
        
        for(int i = 0; i < s.length()/2; i++) {
            first = s.charAt(i);
            last = s.charAt(s.length()-i-1);
            if (first == last) {
                sbFirst.append(first);
                sbLast.append(last);
            }
            else {
                sbFirst = new StringBuilder();
                sbLast = new StringBuilder();
            }
        }
        if (isOdd) {
        	sbFirst.append(mid);
        }
        if (sbLast != null) {
            sbLast.reverse();
        }
        return sbFirst.toString()+sbLast.toString();
    }
    
    /**
     * Roman Numerals to Integer
     * https://leetcode.com/problems/roman-to-integer/
     * @param s Roman Numeral String
     * @return Number converted from roman numerals
     */
    public int romanToInt(String s) {
        int numberToReturn = 0;
        HashMap<String, Integer> romanMap = new HashMap<String, Integer>();
        romanMap.put("I",1);
        romanMap.put("V",5);
        romanMap.put("X",10);
        romanMap.put("L",50);
        romanMap.put("C",100);
        romanMap.put("D",500);
        romanMap.put("M",1000);
        for(int i = 0; i < s.length(); i++) {
        	if (
        		(s.charAt(i) == 'I' && i+1 < s.length() && s.charAt(i+1) == 'V') ||
        		(s.charAt(i) == 'I' && i+1 < s.length() && s.charAt(i+1) == 'X') ||
        		(s.charAt(i) == 'X' && i+1 < s.length() && s.charAt(i+1) == 'L') ||
        		(s.charAt(i) == 'X' && i+1 < s.length() && s.charAt(i+1) == 'C') ||
        		(s.charAt(i) == 'X' && i+1 < s.length() && s.charAt(i+1) == 'C') ||
        		(s.charAt(i) == 'C' && i+1 < s.length() && s.charAt(i+1) == 'D') ||
        		(s.charAt(i) == 'C' && i+1 < s.length() && s.charAt(i+1) == 'M')
        	) {
        		numberToReturn += romanMap.get(String.valueOf(s.charAt(i+1))) - romanMap.get(String.valueOf(s.charAt(i)));
                i++;
            }
            else {
            	numberToReturn += romanMap.get(String.valueOf(s.charAt(i)));
            }
            
        }
        return numberToReturn;
    }

    /** 
     * Determines if string can be a permutation. Ex aab can be a perm of aba
     * */
    public  boolean palindromePermutation(String str) {

        HashMap<Character, Integer> mappin = new HashMap<>();
        String ignoreSpace = str.trim();
        boolean odd = ignoreSpace.length()%2 == 0 ? false : true;
        int oddCount = 0;
        String hey = str.toLowerCase();
        for (int i = 0; i < hey.length(); i++) {
            if(!mappin.containsKey(hey.charAt(i))) {
                mappin.put(hey.charAt(i),1);
            } else {
                mappin.put(hey.charAt(i), mappin.get(hey.charAt(i))+1);
            }
        }
        for(Character a : mappin.keySet()) {
            if(a != ' ' && (mappin.get(a)%2 != 0 || odd)) {
                oddCount++;
            }
        }
        if(oddCount > 1 && odd) { return false; }
        if(oddCount >= 1 && !odd) { return false; }
        return  true;
    }

    public ReturnSum returnLargestSumFromArray(int[] arr, int num, ArrayList<Integer> finalList) {

        int currentSum = 0, largestSum = 0, index = 0;
        int currentIndex = 0, currentIndexCount = 0;

        if (arr.length + 1 < num) {
            return null;
        }

        for (int i = 0; i < arr.length + 1 - num; i++) {
            currentSum = 0;
            currentIndex = i;
            currentIndexCount = 0;

            while (currentIndexCount < num) {
                currentSum += arr[currentIndex];
                currentIndexCount++;
                currentIndex++;
            }
            if (currentSum > largestSum) {

                largestSum = currentSum;
                index = i;
                currentSum = 0;
                currentIndex = i;
                currentIndexCount = 0;

                while (currentIndexCount < num) {
                    currentSum += arr[currentIndex];
                    if (finalList.size() < num) {
                        finalList.add(arr[currentIndex]);
                    } else {
                        finalList.set(currentIndexCount, arr[currentIndex]);
                    }
                    currentIndexCount++;
                    currentIndex++;
                }
            }
        }
        return new ReturnSum(index, largestSum, finalList);
    }

    public void mergeTwoArraysInOrder(int[] arrayA, int[] arrayB) {

        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        int[] resultArray = new int[arrayA.length + arrayB.length];
        int arrayACount = 0, arrayBCount = 0, resultArrayCount = 0;

        while (arrayACount < arrayA.length && arrayBCount < arrayB.length) {
            if (arrayA[arrayACount] <= arrayB[arrayBCount]) {
                resultArray[resultArrayCount] = arrayA[arrayACount];
                arrayACount += 1;
                resultArrayCount += 1;
            } else {
                resultArray[resultArrayCount] = arrayB[arrayBCount];
                arrayBCount += 1;
                resultArrayCount += 1;
            }
        }

        // Merging remaining
        while (arrayACount < arrayA.length) {
            resultArray[resultArrayCount] = arrayA[arrayACount];
            arrayACount += 1;
            resultArrayCount += 1;
        }
        while (arrayBCount < arrayB.length) {
            resultArray[resultArrayCount] = arrayB[arrayBCount];
            arrayBCount += 1;
            resultArrayCount += 1;
        }
        System.out.println("Two arrays merged in order");
        for (int i = 0; i < resultArray.length; i++) {
            System.out.print(resultArray[i]);
        }
        System.out.println();
    }

    public String FirstReverseString(String str) {

        StringBuilder sb = new StringBuilder();
        int length = str.length() - 1;
        char letter = 'a';

        for (int i = 0; i < str.length(); i++) {

            letter = str.charAt(length - i);

            if (letter == 'A') {
                sb.append('Z');
            } else {
                sb.append(letter);
            }
        }
        return sb.toString();
    }

    public String increaseLetterByOne(String str) {

        StringBuilder sb = new StringBuilder();
        int ascii = 0;
        char[] str2 = new char[str.length()];

        for (int i = 0; i < str.length(); i++) {

            str2[i] = str.charAt(i);
            ascii = str2[i];

            if (ascii == 32) {
                sb.append((char) ascii);

            } else {
                ascii++;
                if (ascii == 97 || ascii == 101 || ascii == 105 || ascii == 111 || ascii == 117) {
                    ascii -= 32;
                }
                sb.append((char) ascii);
            }

        }
        return sb.toString();
    }

    public boolean powerOfTwo(int num) {

        int total = num;

        while (total > 1) {
            total /= 2;
            if (total == 2) {
                return true;
            }
        }
        return false;
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int j = 0, biggestLength = 0;
        for (int i = 0; i < s.length(); i++) {
            j = i;
            while (j < s.length() && !map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j), 1);
                System.out.println("Char = " + s.charAt(j));
                j++;
            }
            if (map.size() > biggestLength) {
                biggestLength = map.size();
                System.out.println("Size = " + biggestLength);
            }
            map = null;
        }
        return biggestLength;
    }

    public int lengthOfLongestSubstringANSWER(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); ++i) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

    /**
     * Binary Search - Search a sorted array by repeatedly dividing the search
     * interval in half
     */
    public int binarySearch(int[] arr, int target) {

        int n = arr.length - 1, lowIndex = 0;

        while (lowIndex <= n) {

            // 0,1,2,3,4,5,6,7,8,9,10
            // index=5, index+1=6, 6=lowIndex
            // lowIndex=6, 10-6=4, 4/2=2, 2+6 = index=8
            // lowIndex=9, 10-9=1, 1/2=0, index=9
            int index = lowIndex + (n - lowIndex) / 2;

            System.out.println("Index = " + index + ", n = " + n + ", lowIndex = " + lowIndex + ", target = " + target
                    + ", divide = " + ((n - lowIndex) / 2));

            if (arr[index] == target) {
                return index;
            }
            if (arr[index] < target) {
                lowIndex = index + 1;
            } else {
                n = index - 1;
            }
        }
        return -1;
    }

    /**
     * return largest sum of array
     */
    public int returnLargestSum(int[] arr) {

        int currentTotal = 0, finalTotal = 0;

        for (int i = 0; i < arr.length; i++) {
            currentTotal += arr[i];
            if (currentTotal < 0) {
                currentTotal = 0;
            }
            if (currentTotal > finalTotal) {
                finalTotal = currentTotal;
            }
        }
        return finalTotal;
    }

    /**
     * Buy stock at lowest and sell at highest
     * https://www.geeksforgeeks.org/stock-buy-sell/
     */
    public void stockBuySell(int[] prices) {

        int maxprofit = 0, buy = 0, sell = 0;

        for (int i = 0; i < prices.length - 1; i++) {

            for (int j = i + 1; j < prices.length; j++) {

                int profit = prices[j] - prices[i];

                if (profit > maxprofit) {
                    maxprofit = profit;
                    buy = i;
                    sell = j;
                }
            }
        }
        System.out.println("Buy on " + buy + ", sell on " + sell + " for profit of " + maxprofit + "\n");
    }

    /**
     * Prints the character excluding spaces, character frequency, in order, and
     * word count
     */
    static void printCharWithFreq(String str) {

        int OUT = 0, IN = 1, state = OUT;
        int size = 128, characterCount = 0, wordCount = 0, n = str.length();

        /** 'freq[]' implemented as hash table */
        int[] freq = new int[size];

        /** accumulate frequency of each nonspace character in 'str' */
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

        /**
         * traverse 'str' if freqArr has value in order print char and value, then set
         * to 0 so same char will not be printed again
         */
        for (int i = 0; i < n; i++) {

            /** if frequency of character str.charAt(i) is not equal to 0 */
            if (freq[str.charAt(i)] != 0) {

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
        System.out.println("\nCharacter Count = " + characterCount + ", Word Count = " + wordCount);
    }

    /**
     * Longest common substring. Ex: Longest common sub array of abcdefghi and
     * aaabccccddddeeeei is abcde
     */
    public String longestCommonSub(String arr1, String arr2) {

        StringBuilder sb = new StringBuilder();
        char a = 'a', b = 'b';
        int j = 0;

        for (int i = 0; i < arr1.length(); i++) {

            a = arr1.charAt(i);
            b = arr2.charAt(j);

            if (a != b) {
                return sb.toString();
            }

            if (a == b) {
                sb.append(b);
                j++;
                while (a == arr2.charAt(j) && j < arr2.length()) {
                    j++;
                }
            }
        }
        return sb.toString();
    }

    /**
     * Returns length of longest sub string. Ex: Longest SubString LENGTH of
     * hithereyoungfella and abcdereyoabdytw is 5
     */
    public int longestSubString(String sub1, String sub2) {

        int iCount = 0, totalCount = 0;
        int countin = 0;

        for (int i = 0; i < sub1.length(); i++) {

            int jCount = 0;
            iCount = i;

            while (jCount < sub2.length() && iCount < sub1.length()) {
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

    /**
     * Power recursion
     */
    public int power(int b, int e) {
        if (e == 0) {
            return 1;
        }
        return (b * power(b, e - 1));
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
                // System.out.println("num % 5 = "+num%5+", num = "+num);
                int diff = Math.abs((num % 5) - 5);
                num += diff;
                l1.add(num);
            } else if (num > 37) {
                l1.add(num);
            }
        }
        for (int i = 0; i < l1.size(); i++) {
            System.out.print(l1.get(i) + ", ");
        }
        System.out.println();
    }

    /**
     * Find quadratic roots of given numbers
     */
    public Roots findQuadraticRoots(double a, double b, double c) {
        double r1 = (-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a);
        double r2 = (-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a);
        System.out.println("First root = " + r1);
        System.out.println("Second root = " + r2);
        Roots roo = new Roots(r1, r2);
        return roo;
    }

    /**
     * Return square root of given number
     */
    public double findSquareRoot(int number) {

        double temp;
        double squareRoot = number / 2;

        do {
            temp = squareRoot;
            squareRoot = (temp + (number / temp)) / 2;
        } while ((temp - squareRoot) != 0);

        return squareRoot;
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

    /**
     * Returns true if every character in string is unique
     */
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

    /**
     * Sorts array with selection sort
     */
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

    /**
     * Return the non duplicate value in array
     */
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

    /**
     * Compresses string ex. aaabbcccc -> a3b2c4
     */
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
     * Reverses compressed string to regular string ex. a3b2c4 -> aaabbcccc
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
     * while a1 index and b2 index are same, loop through both. Ex: Is abcdef a
     * substring of aaabbccddddeeefff
     */
    public boolean isSubString(String a1, String b2) {

        if (a1.isEmpty() || b2.isEmpty()) {
            return false;
        }

        int countB = 0;
        char a = 'a', b = 'b';

        for (int i = 0; i < a1.length(); i++) {
            a = a1.charAt(i);
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

    /**
     * Returns an ArrayList of all prime numbers
     */
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

    public String reverseString(String str) {
        StringBuilder sb = new StringBuilder();
        int length = str.length() - 1;
        char letter = 'a';

        for (int i = 0; i < str.length(); i++) {
            letter = str.charAt(length - i);
            sb.append(letter);
        }
        return sb.toString();
    }

    /**
     * Replace every letter in the string with the letter following it in the
     * alphabet (ie. c becomes d, z becomes a). Then capitalize every vowel in this
     * new string (a, e, i, o, u) and return this modified string.
     */
    public String letterExchange(String str) {

        StringBuilder sb = new StringBuilder();
        int ascii = 0;

        for (int i = 0; i < str.length(); i++) {

            ascii = (int) str.charAt(i);

            if (ascii == 32) {
                sb.append((char) ascii);
            } else {

                if (ascii == 90 || ascii == 122) {
                    sb.append('A');

                } else {

                    ascii++;
                    if (ascii == 97 || ascii == 101 || ascii == 105 || ascii == 111 || ascii == 117) {
                        ascii -= 32;
                    }
                    sb.append((char) ascii);
                }
            }

        }
        return sb.toString();
    }

    public int maxArea(int[] height) {
        int maxArea = 0, i = 0, j = height.length - 1;
        while (i < j) {
            maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
            if (height[i] < height[j]) ++i;
            else --j;
        }
        return maxArea;
    }

    public boolean rotateThisString(String str1, String str2) {
        if(str1 == null || str2 == null || str1.length() != str2.length()) {
            return false;
        }
        int str2Count = 0, bothCount = 0;
        for(int i = 0; i < str1.length(); i++) {
            while(str2Count < str2.length() && str1.charAt(i) != str2.charAt(str2Count)) {
                if(str2Count >= str2.length()) {
                    return false;
                }
                str2Count++;
            }
            if(str2Count >= str2.length()) {
                str2Count = 0;
            }
            if(str1.charAt(i) == str2.charAt(str2Count)) {
                while(i < str1.length() && str1.charAt(i) == str2.charAt(str2Count)) {
                    bothCount++;
                    str2Count++;

                    if(str2Count >= str2.length()) {
                        str2Count = 0;
                    }
                    if(i >= str1.length()) {
                        return false;
                    }
                    i++;
                }
                if(bothCount != str2.length()) {
                    return  false;
                }
            }
        }
        System.out.println("str2Count = "+bothCount);
        return bothCount == str2.length();
    }

}
