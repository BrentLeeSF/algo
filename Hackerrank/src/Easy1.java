
public class Easy1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] kangarooArray1 = {0,3,4,2};
		int[] kangarooArray2 = {0,2,5,3};
		System.out.println("Do the kangaroos land on the same platform? = "+kangaroos(kangarooArray2));
	}
	
	/** Two kangaroos jumping. If kangaroos land at same spot return Yes, else No 
	 * https://www.hackerrank.com/challenges/kangaroo/problem */
	public static String kangaroos(int[] arr) {
		
		int roo1Index = arr[0];
		int roo1Jump = arr[1];
		int roo2Index = arr[2];
		int roo2Jump = arr[3];
		int roo1Total = 0, roo2Total = 0;
		
		for(int i = 0; i < 1000; i++) {
			if(i > 0) {
				roo1Total+= roo1Jump;
				roo2Total+= roo2Jump;
			}
			if(i == 0) {
				roo1Total = roo1Index+roo1Jump;
				roo2Total = roo2Index+roo2Jump;
			}
			if(roo1Total == roo2Total) {
				return "YES";
			}
		}
		return "NO";
	}

}
