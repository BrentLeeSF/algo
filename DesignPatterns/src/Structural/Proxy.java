package Structural;

/**
 * Provide a surrogate or placeholder for another object to control access to
 * it. https://www.tutorialspoint.com/design_pattern/proxy_pattern.htm
 */

interface ProxyImageInterface {
	void display();
}

class RealImage implements ProxyImageInterface {

	private String fileName;

	public RealImage(String fileName) {
		this.fileName = fileName;
		loadFromDisk(fileName);
	}

	@Override
	public void display() {
		System.out.println("Displaying " + fileName);
	}

	private void loadFromDisk(String fileName) {
		System.out.println("Loading " + fileName);
	}
}

class ProxyImage implements ProxyImageInterface {

	private RealImage realImage;
	private String fileName;

	public ProxyImage(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public void display() {
		
		if (realImage == null) {
			realImage = new RealImage(fileName);
		}
		
		realImage.display();
	}
	
}

public class Proxy {

	public static void main(String[] args) {

		ProxyImageInterface image = new ProxyImage("test_10mb.jpg");

		/** image will be loaded from disk */
		image.display();
		System.out.println("");

		/** image will not be loaded from disk */
		image.display();
	}
}
