

/** Base Class */
class Parent { 
	void show() { 
		System.out.println("Parent's show()"); 
	} 
} 

/** Inherited class */
class Child extends Parent { 
	
	// This method overrides show() of Parent 
	@Override
	void show() {
		super.show();
		System.out.println("Child's show()"); 
	} 
} 

/** Driver class */
class OverridingDemo {
	
	public static void main(String[] args) {
		
		// If a Parent type reference refers 
		// to a Parent object, then Parent's 
		// show is called 
		Parent obj1 = new Parent(); 
		obj1.show(); 

		System.out.println();
		
		// If a Parent type reference refers 
		// to a Child object Child's show() 
		// is called. This is called RUN TIME 
		// POLYMORPHISM. 
		Child obj2 = new Child(); 
		obj2.show(); 
	} 
}
