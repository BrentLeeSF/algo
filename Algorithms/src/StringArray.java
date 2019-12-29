
import java.util.ArrayList;
import java.util.Arrays;

public class StringArray {
	
	String uniqueStringTest = "afg456362989";
	String uniqueStringTest2 = "abcdefg123567";
	
	int[] sortThis = {3,4,61,6,8,9,2,55,7,0,93,34,5};
	int[] lonelyIntArr = {1,2,3,4,3,2,1};
	
	String compressString = "aaabbccddddeeefff";
	String compressString2 = "abcdef";
	String reverseCompress = "a3b2c2d4e3f3";
	String compressString3 = "cdefg";
	
	int[] primes = {2,4,7,6,9,11,12,15,16,17,18,19,21,22,23};

	public static void main(String[] args) {
		
		StringArray strArr = new StringArray();
		
		System.out.println("Unique String of: "+strArr.uniqueStringTest+" is "+strArr.uniqueString(strArr.uniqueStringTest));
		System.out.println("Unique String of: "+strArr.uniqueStringTest2+" is "+strArr.uniqueString(strArr.uniqueStringTest2));
		
		System.out.println("Sort "+Arrays.toString(strArr.sortThis)+ " is: "+Arrays.toString(strArr.selectionSort(strArr.sortThis)));
		
		System.out.println("lonely int = "+strArr.lonelyInt(strArr.lonelyIntArr));
		
		System.out.println("Compress "+strArr.compressString+" = "+strArr.stringCompression(strArr.compressString));
		System.out.println("Compress "+strArr.compressString2+" = "+strArr.stringCompression(strArr.compressString2));
		System.out.println("Reverse Compress "+strArr.reverseCompress+" = "+strArr.reverseStringCompression(strArr.reverseCompress));
		
		System.out.println("Is "+strArr.compressString2+" a substring of "+strArr.compressString+" "+strArr.isSubString(strArr.compressString, strArr.compressString2));
		
		System.out.print("Prime numbers: ");
		ArrayList<Integer> primeNums = strArr.countPrimeNumbers(strArr.primes);
		for(int i = 0; i < primeNums.size(); i++) {
			System.out.print(primeNums.get(i)+", ");
		}
		System.out.println();
	}
	
	
	/** Returns true if every character in string is unique */
	public boolean uniqueString(String thisUnique) {
		
		char[] testUniqueChar = new char[128];
		int thisChar = 0;
		
		for(int i = 0; i < thisUnique.length(); i++) {
			thisChar = thisUnique.charAt(i);
			if(testUniqueChar[thisChar] > 0) { 
				return false;
			}
			testUniqueChar[thisChar]++;
		}
		return true;
	}
	
	
	/** Sorts array with selection sort */
	public int[] selectionSort(int[] arr) {
		
		for(int i = 0; i < arr.length; i++) {
			int min = i;
			for(int j = i+1; j < arr.length; j++) {
				if(arr[j] < arr[min]) {
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
	public int lonelyInt(int[] arr) {
		int[] newArr = new int[arr.length];
		int save = 0;

		for(int i = 0; i < arr.length; i++) {
			save = arr[i];
			newArr[save]++;
		}
		for(int i = 0; i < newArr.length; i++) {
			if(newArr[i] == 1) {
				return i;
			}
		}
		return 0;
	}
	
	
	/** Compresses string ex. aaabbcccc -> a3b2c4 */
	public String stringCompression(String compressThis) {
		
		StringBuilder str = new StringBuilder();
		char thisChar = 'a';
		int count = 0;
		for(int i = 0; i < compressThis.length(); i++) {
			thisChar = compressThis.charAt(i);
			count = 1;
			while(i+1 < compressThis.length() && thisChar == compressThis.charAt(i+1)) {
				count++;
				i++;
			}
			str.append(thisChar);
			str.append(count);
			count = 0;
		}
		return str.length() < compressThis.length() ? str.toString() : compressThis;
	}
	
	
	/** Reveres compressed string to regular string
	 * ex. a3b2c4 -> aaabbcccc  */
	public String reverseStringCompression(String compressThis) {
		
		StringBuilder str = new StringBuilder();
		char letter = 'a';
		int count = 1;
		
		for(int i = 0; i < compressThis.length(); i++) {
			
			letter = compressThis.charAt(i);
			
			if(i+1 < compressThis.length()) {
				i++;
				count = compressThis.charAt(i) - '0';
				count--;
				str.append(letter);
				
				while(count > 0) {
					str.append(letter);
					count--;
				}
			}
		}
		return str.toString();
	}
	
	
	/**check if both a1 and b2 are not empty 
	 * loop through a1,
	 * get first a1 index and
	 * while a1 index and b2 index are same, loop through both*/
	public boolean isSubString(String a1, String b2) {
		
		if(a1.isEmpty() || b2.isEmpty()) {
			return false;
		}
		
		int countB = 0;
		char b = 'b';
		for(int i = 0; i < a1.length(); i++) {
			char a = a1.charAt(i);	
			if(countB < b2.length()) {
				b = b2.charAt(countB);
			}
			while(a != b && i < a1.length() && countB < b2.length()) {
				a = a1.charAt(i);
				i++;
			}
			if(a == b) {
				countB++;
			}
		}
		return countB-1 == b2.length();
	}
	
	
	/** Returns an ArrayList of all prime numbers */
	public ArrayList<Integer> countPrimeNumbers(int[] arr) {
		
		ArrayList<Integer> allPrimes = new ArrayList<Integer>();
		int count = 0, prime = 0, divide = 0;
		
		for(int i = 0; i< arr.length; i++) {
			
			prime = arr[i];
			divide = prime-1;
			count = 0;
			
			while(divide > 1) {
				if(prime%divide == 0) {
					count++;
				}
				divide--;
			}
			if(count == 0) {
				allPrimes.add(prime);
			}
		}
		return allPrimes;
	}
	
}
