

public class LinkListin {
	
	LinkNode list = null;
	
	public LinkListin() {
		list = new LinkNode();
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
		LinkNode thisLinkNode = new LinkNode(thisData);
		if(list.head == null) {
			list.head = thisLinkNode;
			list.tail = thisLinkNode;
			return;
		} 
		list.tail.next = thisLinkNode;
		list.tail = thisLinkNode;
	}
	
	
	public void deleteData(int thisData) {
		LinkNode thisLinkNode = list.head;
		if(thisLinkNode.data == thisData) {
			list.head = thisLinkNode.next;
			return;
		}
		while(thisLinkNode.next.data != thisData) {
			thisLinkNode = thisLinkNode.next;
		}
		thisLinkNode.next = thisLinkNode.next.next;
	}
	
	
	public void removeDuplicates() {
		
		LinkNode current = list.head;
		
		while(current != null) {
			LinkNode temp = current;
			
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
		LinkNode current = list.head;
		while(current.next != null) {
			current = current.next;
		}
		LinkNode newLinkNode = new LinkNode(data);
		current.next = newLinkNode;
	}
	
	
	public void addAtFront(int data) {
		LinkNode newFront = new LinkNode(data);
		newFront.next = list.head;
		list.head = newFront;
		/*LinkNode current = list.head;
		LinkNode newFront = new LinkNode(data);
		LinkNode temp = current;
		list.head = newFront;
		list.head.next = temp;*/
	}
	
	
	public void addAfterIndex(int index, int data) {
		
		LinkNode newLinkNode = new LinkNode(data);
		LinkNode current = list.head;
		int count = 0;
		
		while(index != count) {
			current = current.next;
			count++;
		}
		if(index == count) {
			LinkNode next = current.next;
			current.next = newLinkNode;
			newLinkNode.next = next;
		}
	}
	
	
	public void reverse() {
		LinkNode current = list.head;
		LinkNode next = null;
		LinkNode prev = null;
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
		LinkNode current = list.head;
		while(current != null) {
			System.out.print(current.data+", ");
			current = current.next;
		}
		System.out.println();
		System.out.println();
	}
}

class LinkNode {
	
	LinkNode head, tail, next;
	int data;
	
	public LinkNode() {
		head = tail = next = null;
	}
	
	public LinkNode(int data) {
		this.data = data;
	}
}