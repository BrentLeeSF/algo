
public class Easy {

	public static void main(String[] args) {
		Easy es = new Easy();
		int[] stocks = {7,1,5,3,6,4};
		System.out.println(es.buySellStocks(stocks));
		
		String heyWorld = "Hello Worldss   ";
		System.out.println("length of last string of "+heyWorld+" is "+es.lengthLastWord(heyWorld));
	}
	
	public int buySellStocks(int[] prices) {
		
		int max = 0, min = Integer.MAX_VALUE;
		
		for(int i = 0; i < prices.length; i++) {
			if(prices[i] < min) {
				min = prices[i];
			} else {
				max = Math.max(max, prices[i]-min);
			}
		}
		return max;
	}
	
	public int lengthLastWord(String s) {
		String[] splited = s.split("\\s+");
        String hey = splited[splited.length - 1];
        if(hey.equals(" ")) { return 1; }
        return hey.length() > 0 ? hey.length() : 0;
	}
}
