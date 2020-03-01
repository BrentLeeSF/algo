package Structural;

/**
 * Decorator pattern allows a user to add new functionality to an existing
 * object without altering its structure.
 * https://www.tutorialspoint.com/design_pattern/decorator_pattern.htm
 */

interface DecoratorShape {
	void draw();
}

class DecoratorRectangle implements DecoratorShape {

	@Override
	public void draw() {
		System.out.println("Shape: Rectangle");
	}
}

class DecoratorCircle implements DecoratorShape {

	@Override
	public void draw() {
		System.out.println("Shape: Circle");
	}
}

abstract class DecoratorShapeAbstract implements DecoratorShape {
	
	protected DecoratorShape decoratedShape;

	public DecoratorShapeAbstract(DecoratorShape decoratedShape) {
		this.decoratedShape = decoratedShape;
	}

	public void draw() {
		decoratedShape.draw();
	}
}

class RedShapeDecorator extends DecoratorShapeAbstract {

	public RedShapeDecorator(DecoratorShape decoratedShape) {
		super(decoratedShape);
	}

	@Override
	public void draw() {
		decoratedShape.draw();
		setRedBorder(decoratedShape);
	}

	private void setRedBorder(DecoratorShape decoratedShape) {
		System.out.println("Border Color: Red");
	}
}

public class Decorator {

	public static void main(String[] args) {

		DecoratorShape circle = new DecoratorCircle();
		DecoratorShape redCircle = new RedShapeDecorator(new DecoratorCircle());
		DecoratorShape redRectangle = new RedShapeDecorator(new DecoratorRectangle());
		
		System.out.println("Circle with normal border");
		circle.draw();

		System.out.println("\nCircle of red border");
		redCircle.draw();

		System.out.println("\nRectangle of red border");
		redRectangle.draw();
	}
}
