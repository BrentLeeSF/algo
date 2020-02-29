package Behavioral;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * defines a family of functionality, encapsulate each one, and make them
 * interchangeable/very similar https://www.javatpoint.com/strategy-pattern
 */

interface StrategyInterface {

	public float calculation(float a, float b);

}

class Addition implements StrategyInterface {

	@Override
	public float calculation(float a, float b) {
		return a + b;
	}

}

class Subtraction implements StrategyInterface {

	@Override
	public float calculation(float a, float b) {
		return a - b;
	}

}

class Multiplication implements StrategyInterface {

	@Override
	public float calculation(float a, float b) {
		return a * b;
	}
}

class ExecuteStrategy {

	private StrategyInterface strategy;

	public ExecuteStrategy(StrategyInterface strategy) {
		this.strategy = strategy;
	}

	public float executeStrategy(float num1, float num2) {
		return strategy.calculation(num1, num2);
	}

}

public class Strategy {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Enter the first value: ");
		float value1 = Float.parseFloat(br.readLine());

		System.out.print("Enter the second value: ");
		float value2 = Float.parseFloat(br.readLine());

		ExecuteStrategy context = new ExecuteStrategy(new Addition());
		System.out.println("Addition = " + context.executeStrategy(value1, value2));

		context = new ExecuteStrategy(new Subtraction());
		System.out.println("Subtraction = " + context.executeStrategy(value1, value2));

		context = new ExecuteStrategy(new Multiplication());
		System.out.println("Multiplication = " + context.executeStrategy(value1, value2));
	}

}
