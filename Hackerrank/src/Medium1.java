import java.math.BigInteger;

public class Medium1 {

	public static void main(String[] args) {
		
		Medium1 med = new Medium1();
		
		int[] rankingArrOne = {100,100,50,40,40,20,10};
		int[] rankingArrTwo = {5,25,50,120};
		printRankings(rankingArrOne, rankingArrTwo);
	
		String encryptionString = "if man was meant to stay on the ground god would have given us roots";
		String feed = "feedthedog";
		encryptString(feed);
		
		veryLongFactorial(25);
	}
		
	
	/** return ranking of scores based off two arrays. Do not count duplicates
	 * Ex. 
	 * Arr1 = 100,100,50,40,40,20,10
	 * Arr2 = 5,25,50,120
	 * Returns 5=6, 25=4, 50=2, 120=1
	 * 
	 * https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem */
	public static void printRankings(int[] scores, int[] alice) {
		
        for(int i = 0; i < alice.length; i++) {
            System.out.print(returnCount(scores, alice[i])+", ");
        }
        System.out.println("\n");
    }

    public static int returnCount(int[] scores, int num) {
    	
        int save = 0, newSave = 0, count = 0;
        
        for(int i = 0; i < scores.length; i++) {
        	
            newSave = scores[i];
            
            if(newSave == save) {
               continue;
            }
            count++;
            
            if(num > newSave || num == newSave) {
                return count;
            }
            save = newSave;
            
        }
        return count+1;
    }
    
    /** Print very long factorial n*n-1*n-2*n-3, etc*/
    public static void veryLongFactorial(int num) {
    	
    	BigInteger factorial = new BigInteger("1");
 
    	for(int i = 2; i <= num; i++) {
    		BigInteger multiplier = new BigInteger(String.valueOf(i));
            factorial = factorial.multiply(multiplier);
    	}
    	System.out.println(factorial);
    	System.out.println("\n");
    }
    
    /** Hackerrank Encryption https://www.hackerrank.com/challenges/encryption/problem 
     * Get square root of string length, return new string with length of square root
     * of index of each letter in word.
     * Ex. String 'feed the dog' -> feedthedog with length of 10. 
     * square root of 10 is between 3 & 4. 
     * first letter between 3 & 4 from 'feed the dog' -> fto ehg ee dd */
    public static void encryptString(String str) {
    	
    	int sqr = (int) Math.sqrt((str.length()));
    	int count = 0;
    	StringBuilder sb = new StringBuilder();
    	
    	for(int i = 0; i < str.length(); i++) {
    		if(count >= sqr) {
    			count = 0;
    			sb.append(str.charAt(i)+" ");

    		} else {
    			sb.append(str.charAt(i));
    			count++;
    		}
    	}
    	
    	String newString = sb.toString();
    	String[] newStringArr = newString.split(" ");
  
    	StringBuilder sb2 = new StringBuilder();
    	int count2 = 0;
    	
    	for(int k = 0; k < newString.length(); k++) {
    		
    		for(int j = 0; j < newStringArr.length; j++) {
    			
    			if(count2 < newStringArr[j].length()) {
    				sb2.append(newStringArr[j].charAt(count2));
    			}
        	}
    		sb2.append(" ");
    		count2++;
    	}
    	
    	System.out.println(sb2.toString());
    }
}
