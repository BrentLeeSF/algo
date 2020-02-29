package Behavioral;

import java.util.Random;

/**
 * Avoid coupling the sender of a request to its receiver by giving multiple
 * objects a chance to handle the request
 * https://sourcemaking.com/design_patterns/chain_of_responsibility
 */
interface ChainOfResponsibility_Image {
	String process();
}

class IR implements ChainOfResponsibility_Image {

	public String process() {
		return "IR";
	}

}

class LS implements ChainOfResponsibility_Image {

	public String process() {
		return "LS";
	}

}

class Processor {

	private static final Random RANDOM = new Random();
	private static int nextID = 1;
	private int id = nextID++;

	public boolean execute(ChainOfResponsibility_Image img) {

		if (RANDOM.nextInt(2) != 0) {

			System.out.println("   Processor " + id + " is busy");
			return false;
		}

		System.out.println("Processor " + id + " - " + img.process());
		return true;

	}
}

public class ChainOfResponsibility {

	public static void main(String[] args) {

		ChainOfResponsibility_Image[] inputImages = { new IR(), new IR(), new LS(), new IR(), new LS(), new LS() };
		Processor[] processors = { new Processor(), new Processor(), new Processor() };

		for (int i = 0, j; i < inputImages.length; i++) {

			System.out.println("Operation #" + (i + 1) + ":");
			j = 0;

			while (!processors[j].execute(inputImages[i])) {
				j = (j + 1) % processors.length;
			}

			System.out.println();
		}
	}
}
