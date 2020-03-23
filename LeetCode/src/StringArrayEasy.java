
public class StringArrayEasy {

	public static void main(String[] args) {
		
		StringArrayEasy strE = new StringArrayEasy();
		
		int reverseIntNum1 = -321;
		System.out.println("Reverse " + reverseIntNum1 + " is " + strE.reverseInteger(reverseIntNum1));
	}

	public int reverseInteger(int x) {

		String thisString = Integer.toString(x);
		int length = thisString.length();
		StringBuilder str = new StringBuilder();
		int a = 0;
		boolean negative = false;

		if (thisString.charAt(0) == 45) {
			str.append("-");
			negative = true;
		}
		for (int i = length - 1; i >= 0; i--) {
			if (i == 0 && negative) {
				continue;
			}
			a = thisString.charAt(i) - 48;
			str.append(Integer.valueOf(a));
		}
		return Integer.parseInt(str.toString());

		/**
		 * Also works // int result = 0;
		 * 
		 * while (x != 0) { int tail = x % 10; int newResult = result * 10 + tail; if
		 * ((newResult - tail) / 10 != result) { return 0; } result = newResult; x = x /
		 * 10; }
		 * 
		 * return result;
		 */
	}
}
