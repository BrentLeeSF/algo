package Behavioral;

/**
 * A way to evaluate language grammar or expression. */
/**
 * Involves implementing an expression interface which tells to interpret a
 * particular context. This pattern is used in SQL parsing, symbol processing
 * engine etc.
 */
/** https://www.geeksforgeeks.org/interpreter-design-pattern/ */

/** Check the interpreter. */
interface InterpreterExpression {
	boolean interpreter(String con);
}

/** Checks if the data is same as the interpreter data. */
class TerminalExpressionInt implements InterpreterExpression {

	String data;

	public TerminalExpressionInt(String data) {
		this.data = data;
	}

	public boolean interpreter(String con) {

		if (con.contains(data)) {
			return true;
		} else {
			return false;
		}

	}
}

/** Returns the or condition of the data is same as the interpreter data. */
class OrExpressionInt implements InterpreterExpression {

	InterpreterExpression expr1;
	InterpreterExpression expr2;

	public OrExpressionInt(InterpreterExpression expr1, InterpreterExpression expr2) {
		this.expr1 = expr1;
		this.expr2 = expr2;
	}

	public boolean interpreter(String con) {
		return expr1.interpreter(con) || expr2.interpreter(con);
	}
}

/** Returns the And condition of the data is same as the interpreter data. */
class AndExpressionInt implements InterpreterExpression {

	InterpreterExpression expr1;
	InterpreterExpression expr2;

	public AndExpressionInt(InterpreterExpression expr1, InterpreterExpression expr2) {
		this.expr1 = expr1;
		this.expr2 = expr2;
	}

	public boolean interpreter(String con) {
		return expr1.interpreter(con) && expr2.interpreter(con);
	}
}

public class InterpreterTwo {

	public static void main(String[] args) {

		InterpreterExpression person1 = new TerminalExpressionInt("Brent");
		InterpreterExpression person2 = new TerminalExpressionInt("Steve");
		InterpreterExpression isSingle = new OrExpressionInt(person1, person2);

		InterpreterExpression Homeless = new TerminalExpressionInt("Homeless");
		InterpreterExpression committed = new TerminalExpressionInt("Committed");
		InterpreterExpression isCommitted = new AndExpressionInt(Homeless, committed);

		System.out.println(isSingle.interpreter("Brent"));
		System.out.println(isSingle.interpreter("Steve"));
		System.out.println(isSingle.interpreter("Achint"));

		System.out.println(isCommitted.interpreter("Committed, Homeless"));
		System.out.println(isCommitted.interpreter("Single, Homeless"));

	}
}