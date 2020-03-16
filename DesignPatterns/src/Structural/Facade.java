package Structural;

/**
 * A single class that represents an entire subsystem. Hides complexities.
 * Facade pattern hides the complexities of the system and provides an interface
 * to the client using which the client can access the system.
 */
/** https://www.tutorialspoint.com/design_pattern/facade_pattern.htm */

interface FacadeShape {
	void draw();
}

class FacadeRectangle implements FacadeShape {

	@Override
	public void draw() {
		System.out.println("Rectangle::draw()");
	}
}

class FacadeSquare implements FacadeShape {

	@Override
	public void draw() {
		System.out.println("Square::draw()");
	}
}

class FacadeCircle implements FacadeShape {

	@Override
	public void draw() {
		System.out.println("Circle::draw()");
	}
}

class ShapeMaker {

	private FacadeShape circle;
	private FacadeShape rectangle;
	private FacadeShape square;

	public ShapeMaker() {

		circle = new FacadeCircle();
		rectangle = new FacadeRectangle();
		square = new FacadeSquare();
	}

	public void drawCircle() {
		circle.draw();
	}

	public void drawRectangle() {
		rectangle.draw();
	}

	public void drawSquare() {
		square.draw();
	}
}

public class Facade {

	public static void main(String[] args) {

		ShapeMaker shapeMaker = new ShapeMaker();

		shapeMaker.drawCircle();
		shapeMaker.drawRectangle();
		shapeMaker.drawSquare();
	}

}
