package Creational;

/**
 * Abstract Factory patterns work around a super-factory which creates other
 * factories. Abstract factory pattern implementation provides us a framework
 * that allows us to create objects that follow a general pattern.
 * 
 * Abstract Factory pattern is almost similar to Factory Pattern is considered
 * as another layer of abstraction over factory pattern.
 */

interface AbstractFactoryShape {
	void draw();
}

class AbstractFactoryRoundedRectangle implements AbstractFactoryShape {
	@Override
	public void draw() {
		System.out.println("Inside RoundedRectangle::draw() method.");
	}
}

class AbstractFactoryRoundedSquare implements AbstractFactoryShape {
	@Override
	public void draw() {
		System.out.println("Inside RoundedSquare::draw() method.");
	}
}

class AbstractFactoryRectangle implements AbstractFactoryShape {
	@Override
	public void draw() {
		System.out.println("Inside Rectangle::draw() method.");
	}
}

abstract class AbstractFactory {
	abstract AbstractFactoryShape getShape(String shapeType);
}

class AbstractFactoryShapeFactory extends AbstractFactory {

	@Override
	public AbstractFactoryShape getShape(String shapeType) {

		if (shapeType.equalsIgnoreCase("RECTANGLE")) {
			return new AbstractFactoryRectangle();
		} else if (shapeType.equalsIgnoreCase("SQUARE")) {
			return new AbstractFactoryRoundedSquare();
		}
		return null;
	}
}

class RoundedShapeFactory extends AbstractFactory {

	@Override
	public AbstractFactoryShape getShape(String shapeType) {
		if (shapeType.equalsIgnoreCase("RECTANGLE")) {
			return new AbstractFactoryRoundedRectangle();
		} else if (shapeType.equalsIgnoreCase("SQUARE")) {
			return new AbstractFactoryRoundedSquare();
		}
		return null;
	}
}

class FactoryProducer {

	public static AbstractFactory getFactory(boolean rounded) {
		if (rounded) {
			return new RoundedShapeFactory();
		} else {
			return new AbstractFactoryShapeFactory();
		}
	}
}

public class AbstractFactoryDemo {

	public static void main(String[] args) {

		/** get rounded shape factory */
		AbstractFactory shapeFactory = FactoryProducer.getFactory(false);

		/** get an object of Shape Rounded Rectangle */
		AbstractFactoryShape shape1 = shapeFactory.getShape("RECTANGLE");

		/** call draw method of Shape Rectangle */
		shape1.draw();

		/** get an object of Shape Rounded Square */
		AbstractFactoryShape shape2 = shapeFactory.getShape("SQUARE");
		/** call draw method of Shape Square */
		shape2.draw();

		/** get rounded shape factory */
		AbstractFactory shapeFactory1 = FactoryProducer.getFactory(true);

		/** get an object of Shape Rectangle */
		AbstractFactoryShape shape3 = shapeFactory1.getShape("RECTANGLE");
		/** call draw method of Shape Rectangle */
		shape3.draw();

		/** get an object of Shape Square */
		AbstractFactoryShape shape4 = shapeFactory1.getShape("SQUARE");
		/** call draw method of Shape Square */
		shape4.draw();

	}
}
