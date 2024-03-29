
class LinkNodeTwo {
	
	LinkNodeTwo next, head;
	int data;
	
	public LinkNodeTwo() {this.head = null;}
	
	public LinkNodeTwo(int data) {
		this.data = data;
		this.next = null;
	}
}


public class LinkinTwo {
	
	LinkNodeTwo list = null;

	public LinkinTwo() {
		list = new LinkNodeTwo();
	}

	public static void main(String[] args) {
		
		LinkinTwo l2 = new LinkinTwo();
		int[] arr = {3,6,7,8,1,4};
		
		for(int i = 0; i < arr.length; i++) {
			l2.add(arr[i]);
		}
		l2.print();
		l2.removeAtIndex(3);
		l2.print();
	}
	
	public void add(int num) {
		
		LinkNodeTwo thisNode = list.head;

		if(thisNode == null) {
			thisNode = new LinkNodeTwo(num);
			list.head = thisNode;
		}

		LinkNodeTwo current = thisNode;

		while(current.next != null) {
			current = current.next;
		}
		current.next = new LinkNodeTwo(num);
	}
	
	public void print() {
		LinkNodeTwo current = list.head;
		while(current != null) {
			System.out.print(current.data+", ");
			current = current.next;
		}
		System.out.println();
	}
	
	public void removeAtIndex(int index) {

		LinkNodeTwo current = list.head;
		int count = 0;
		if (index == count) {
			list.head = current.next;
		}

		while (count < index) {
			System.out.println("- " + current.data);
			current = current.next.next;
			count++;
		}
		if (index == count) {
			current = current;
		}
	}
}
