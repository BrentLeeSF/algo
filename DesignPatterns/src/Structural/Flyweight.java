package Structural;

import java.util.HashMap;

/**
 * Flyweight - Used to reduce the number of objects created and to decrease
 * memory footprint and increase performance
 * https://www.tutorialspoint.com/design_pattern/flyweight_pattern.htm
 */

interface FlyweightShape {
	void draw();
}

class FlyweightCircle implements FlyweightShape {
	
	private String color;
	private int x;
	private int y;
	private int radius;

	public FlyweightCircle(String color) {
		this.color = color;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public void draw() {
		System.out.println("Circle: Draw() [Color : " + color + ", x : " + x + ", y :" + y + ", radius :" + radius);
	}
}

class FlyweightShapeFactory {

	// Uncomment the compiler directive line and
	// javac *.java will compile properly.
	// @SuppressWarnings("unchecked")
	private static final HashMap circleMap = new HashMap();

	public static FlyweightShape getCircle(String color) {
		
		FlyweightCircle circle = (FlyweightCircle) circleMap.get(color);

		if (circle == null) {
			
			circle = new FlyweightCircle(color);
			circleMap.put(color, circle);
			System.out.println("Creating circle of color : " + color);
		}
		
		return circle;
	}
}

public class Flyweight {
	
	private static final String colors[] = { "Red", "Green", "Blue", "White", "Black" };

	public static void main(String[] args) {

		for (int i = 0; i < 20; ++i) {
			
			FlyweightCircle circle = (FlyweightCircle) FlyweightShapeFactory.getCircle(getRandomColor());
			
			circle.setX(getRandomX());
			circle.setY(getRandomY());
			
			circle.setRadius(100);
			circle.draw();
		}
	}

	private static String getRandomColor() {
		return colors[(int) (Math.random() * colors.length)];
	}

	private static int getRandomX() {
		return (int) (Math.random() * 100);
	}

	private static int getRandomY() {
		return (int) (Math.random() * 100);
	}
}
