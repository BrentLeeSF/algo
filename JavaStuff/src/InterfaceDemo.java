// Java program to illustrate the 


import java.io.*; 


interface ShapeInterfaceDemo { 
	/** abstract method */
	void draw(); 
	double area(); 
} 


class RectangleInterfaceDemo implements ShapeInterfaceDemo {
	
	int length, width;
	
	RectangleInterfaceDemo(int length, int width) { 
		this.length = length; 
		this.width = width; 
	} 
	
	
	@Override
	public void draw() { 
		System.out.println("Rectangle has been drawn "); 
	}
	
	
	@Override
	public double area() { 
		return (double)(length*width); 
	} 
} 


class CircleInterfaceDemo implements ShapeInterfaceDemo { 
	
	double pi = 3.14; 
	int radius; 
	
	CircleInterfaceDemo(int radius) { 
		this.radius = radius; 
	}
	
	
	@Override
	public void draw() { 
		System.out.println("Circle has been drawn "); 
	} 
	
	
	@Override
	public double area() { 
		
		return (double)((pi*radius*radius)/2); 
	}
} 


class InterfaceDemo {
	
	public static void main (String[] args) { 
	

		ShapeInterfaceDemo rect = new RectangleInterfaceDemo(2,3); 
		System.out.println("Area of rectangle: " + rect.area()); 

		ShapeInterfaceDemo circle = new CircleInterfaceDemo(2); 
		System.out.println("Area of circle: " + circle.area()); 
	} 
} 
