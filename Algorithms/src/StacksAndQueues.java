import java.util.Stack;

public class StacksAndQueues {

	public static void main(String[] args) {

		StacksAndQueues st = new StacksAndQueues();

		String parenth1 = "[{()]}";
		String parenth2 = "[{()}]";
		System.out.println("Is " + parenth1 + " a valid Sting? Ans = " + st.validParenthesis(parenth1));
		System.out.println("Is " + parenth2 + " a valid Sting? Ans = " + st.validParenthesis(parenth2));

	}

	/**
	 * When given a string of parenthesis. Check if all the parenthesis close at the
	 * right locations. Ex. (){[[]]} is valid, but (){[(])} is not
	 */
	public boolean validParenthesis(String validString) {

		Stack<Character> stack = new Stack<Character>();
		char[] c = validString.toCharArray();

		for (int i = 0; i < c.length; i++) {
			if (c[i] == '(') {
				stack.push(')');
			} else if (c[i] == '{') {
				stack.push('}');
			} else if (c[i] == '[') {
				stack.push(']');
			} else if (stack.isEmpty() || stack.pop() != c[i]) {
				return false;
			}
		}
		return stack.isEmpty();
	}

}
