
class Node {
	
	Node head, tail, next;
	int data;
	
	public Node() {
		head = tail = next = null;
	}
	
	public Node(int data) {
		this.data = data;
	}
}


public class LinkListin {
	
	Node list = null;
	
	public LinkListin() {
		list = new Node();
	}
	

	public static void main(String[] args) {
		
		LinkListin ls = new LinkListin();
		int[] arr = { 3,6,8,1,3,0,5,3};
		for(int i = 0; i < arr.length; i++) {
			ls.createList(arr[i]);
		}
		ls.print("Create List");
		ls.deleteData(5);
		ls.print("Delete Data 5");
		ls.removeDuplicates();
		ls.print("Remove Duplicates");
		ls.addAtEnd(5);
		ls.print("Add 5 at end");
		ls.addAtFront(2);
		ls.print("Add 2 at front");
		ls.addAfterIndex(3, 9);
		ls.print("Insert 9 after 3rd index");
		ls.reverse();
		ls.print("Reverse Linked List");
		ls.reverse();
		ls.print("Reverse Linked List");
	}
	
	
	public void createList(int thisData) {
		Node thisNode = new Node(thisData);
		if(list.head == null) {
			list.head = thisNode;
			list.tail = thisNode;
			return;
		} 
		list.tail.next = thisNode;
		list.tail = thisNode;
	}
	
	
	public void deleteData(int thisData) {
		Node thisNode = list.head;
		if(thisNode.data == thisData) {
			list.head = thisNode.next;
			return;
		}
		while(thisNode.next.data != thisData) {
			thisNode = thisNode.next;
		}
		thisNode.next = thisNode.next.next;
	}
	
	
	public void removeDuplicates() {
		
		Node current = list.head;
		
		while(current != null) {
			Node temp = current;
			
			while(temp.next != null) {
				if(temp.next.data == current.data) {
					temp.next = temp.next.next;
				} else {
					temp = temp.next;
				}
			}
			current = current.next;
		}
	}
	
	
	public void addAtEnd(int data) {
		Node current = list.head;
		while(current.next != null) {
			current = current.next;
		}
		Node newNode = new Node(data);
		current.next = newNode;
	}
	
	
	public void addAtFront(int data) {
		Node newFront = new Node(data);
		newFront.next = list.head;
		list.head = newFront;
		/*Node current = list.head;
		Node newFront = new Node(data);
		Node temp = current;
		list.head = newFront;
		list.head.next = temp;*/
	}
	
	
	public void addAfterIndex(int index, int data) {
		
		Node newNode = new Node(data);
		Node current = list.head;
		int count = 0;
		
		while(index != count) {
			current = current.next;
			count++;
		}
		if(index == count) {
			Node next = current.next;
			current.next = newNode;
			newNode.next = next;
		}
	}
	
	
	public void reverse() {
		Node current = list.head;
		Node next = null;
		Node prev = null;
		while(current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		list.head = prev;
	}
	
	
	public void print(String message) {
		System.out.println(message);
		Node current = list.head;
		while(current != null) {
			System.out.print(current.data+", ");
			current = current.next;
		}
		System.out.println();
		System.out.println();
	}

}
