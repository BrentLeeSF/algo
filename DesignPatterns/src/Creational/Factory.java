package Creational;

/**
 * Define an interface for creating an object, but let subclasses decide which
 * class to instantiate.
 * https://www.tutorialspoint.com/design_pattern/factory_pattern.htm
 */
interface FactoryShape {
	void draw();
}

class FactoryRectangle implements FactoryShape {

	@Override
	public void draw() {
		System.out.println("Inside FactoryRectangle::draw() method.");
	}
}

class FactorySquare implements FactoryShape {

	@Override
	public void draw() {
		System.out.println("Inside FactorySquare::draw() method.");
	}
}

class FactoryCircle implements FactoryShape {

	@Override
	public void draw() {
		System.out.println("Inside FactoryCircle::draw() method.");
	}
}

class FactoryShapeFactory {

	/** use getFactoryShape method to get object of type FactoryShape */
	public FactoryShape getFactoryShape(String FactoryShapeType) {

		if (FactoryShapeType == null) {
			return null;
		}

		if (FactoryShapeType.equalsIgnoreCase("FactoryCircle")) {
			return new FactoryCircle();

		} else if (FactoryShapeType.equalsIgnoreCase("FactoryRectangle")) {
			return new FactoryRectangle();

		} else if (FactoryShapeType.equalsIgnoreCase("FactorySquare")) {
			return new FactorySquare();
		}

		return null;
	}
}

public class Factory {

	public static void main(String[] args) {

		FactoryShapeFactory FactoryShapeFactory = new FactoryShapeFactory();

		/** get an object of FactoryCircle and call its draw method. */
		FactoryShape FactoryShape1 = FactoryShapeFactory.getFactoryShape("FactoryCircle");

		/** call draw method of FactoryCircle */
		FactoryShape1.draw();

		/** get an object of FactoryRectangle and call its draw method. */
		FactoryShape FactoryShape2 = FactoryShapeFactory.getFactoryShape("FactoryRectangle");

		/** call draw method of FactoryRectangle */
		FactoryShape2.draw();

		/** get an object of FactorySquare and call its draw method. */
		FactoryShape FactoryShape3 = FactoryShapeFactory.getFactoryShape("FactorySquare");

		/** call draw method of FactorySquare */
		FactoryShape3.draw();
	}
}
