package Creational;

import java.util.HashMap;
import java.util.Map;

/** https://sourcemaking.com/design_patterns/prototype/java/1 */
interface ProtypePerson {

	ProtypePerson clone();
	
}

class Tom implements ProtypePerson {

	private final String NAME = "Tom";

	@Override
	public ProtypePerson clone() {
		return new Tom();
	}

	@Override
	public String toString() {
		return NAME;
	}
}

class Dick implements ProtypePerson {

	private final String NAME = "Dick";

	@Override
	public ProtypePerson clone() {
		return new Dick();
	}

	@Override
	public String toString() {
		return NAME;
	}
}

class Harry implements ProtypePerson {

	private final String NAME = "Harry";

	@Override
	public ProtypePerson clone() {
		return new Harry();
	}

	@Override
	public String toString() {
		return NAME;
	}
}

class PrototypeFactory {

	private static final Map<String, ProtypePerson> prototypes = new HashMap<>();

	static {
		prototypes.put("tom", new Tom());
		prototypes.put("dick", new Dick());
		prototypes.put("harry", new Harry());
	}

	public static ProtypePerson getPrototype(String type) {

		try {
			return prototypes.get(type).clone();

		} catch (NullPointerException ex) {

			System.out.println("Prototype with name: " + type + ", doesn't exist");
			return null;
		}
	}
}

public class Prototype {

	public static void main(String[] args) {

		if (args.length > 0) {

			for (String type : args) {

				ProtypePerson prototype = PrototypeFactory.getPrototype(type);

				if (prototype != null) {
					System.out.println(prototype);
				}
			}

		} else {
			System.out.println("Run again with arguments of command string ");
		}
	}
}
