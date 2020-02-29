package Behavioral;

/**
 * A way to access the elements of a collection object in sequential manner
 * without any need to know its underlying representation
 * https://www.tutorialspoint.com/design_pattern/iterator_pattern.htm
 */
interface IteratorDemo {
	public boolean hasNext();

	public Object next();
}

interface Container {
	public IteratorDemo getIterator();
}

class NameRepository implements Container {

	public String names[] = { "Robert", "John", "Julie", "Lora" };

	@Override
	public IteratorDemo getIterator() {
		return new NameIterator();
	}

	private class NameIterator implements IteratorDemo {

		int index;

		@Override
		public boolean hasNext() {

			if (index < names.length) {
				return true;
			}
			return false;
		}

		@Override
		public Object next() {

			if (this.hasNext()) {
				return names[index++];
			}
			return null;
		}
	}
}

public class IteratorPattern {

	public static void main(String[] args) {

		NameRepository namesRepository = new NameRepository();

		for (IteratorDemo iter = namesRepository.getIterator(); iter.hasNext();) {

			String name = (String) iter.next();
			System.out.println("Name : " + name);
		}
	}

}
