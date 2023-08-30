
class Animal {
	void run() {
	  System.out.println("Animal runs...");
	}
}

class Dog extends Animal {
	void run() {
		System.out.println("Dog runs faster than goat");
	}
	void bark() {
		System.out.println("Dog is barking...");
	}
	void work() {
		super.run();
		bark();
		run();
	}
}

class TestSuper {
	public static void main(String args[]){
		Dog d = new Dog();
		d.work();
	}
}
