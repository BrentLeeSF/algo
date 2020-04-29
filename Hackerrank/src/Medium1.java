import java.math.BigInteger;

public class Medium1 {

	public static void main(String[] args) {
		
		int[] rankingArrOne = {100,100,50,40,40,20,10};
		int[] rankingArrTwo = {5,25,50,120};
		printRankings(rankingArrOne, rankingArrTwo);
		
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
            System.out.println(returnCount(scores, alice[i]));
        }   
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
    }
}
