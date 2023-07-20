

class LinkNode {

	LinkNode head, next;
	int data;

	public LinkNode() {
		head = next = null;
	}

	public LinkNode(int data) {
		this.data = data;
	}
}

public class LinkListin {

	LinkNode list = null;

	public LinkListin() {
		list = new LinkNode();
	}

	public static void main(String[] args) {

		LinkListin ls = new LinkListin();

		int[] arr = { 3, 9, 3, 6, 8, 1, 3, 0, 5, 3 };
		for (int i = 0; i < arr.length; i++) {
			ls.createList(arr[i]);
		}
		ls.print("Create List");

		int dataValue = 9;
		ls.deleteAtData(dataValue);
		ls.print("Delete Data "+dataValue);

		int listIndex = 8;
		ls.deleteAtIndexGoingForward(listIndex);
		ls.print("Delete Going Forward At Index "+listIndex);

		LinkNode hey = ls.deleteAtIndexGoingBackward(ls.list.head, 3);
		System.out.println("Deleting Going Backward at Index 3 Where Last = 1");
		while(hey != null) {
			System.out.print(hey.data+", ");
			hey = hey.next;
		}
		System.out.println("\n");

		ls.removeDuplicates();
		ls.print("Remove Duplicates");

		int numberToAddAtEnd = 5;
		ls.addAtEnd(numberToAddAtEnd);
		ls.print("Add "+numberToAddAtEnd+" at end");

		int numberToAddAtFront = 2;
		ls.addAtFront(numberToAddAtFront);
		ls.print("Add "+numberToAddAtFront+" at front");

		int afterIndexIndex = 0;
		int afterIndexData = 9;
		ls.addAfterIndex(afterIndexIndex, afterIndexData);
		ls.print("Insert "+afterIndexData+" after "+afterIndexIndex+" index");

		ls.reverse();
		ls.print("Reverse Linked List");

		ls.reverse();
		ls.print("Reverse Linked List");

		System.out.println("Print Next Greatest Value in Linked List. If Value is Greatest Value, Print 0");
		ls.nextLargerNodes();

		ls.printMiddleIndex();
		ls.print("Print middle index");

	}

	/** LeetCode 1019. Next Greater Node In Linked List */
	public void nextLargerNodes() {

		LinkNode firstCurrent = list.head;
		int index = 0;

		while (firstCurrent != null) {
			firstCurrent = firstCurrent.next;
			index++;
		}

		int[] arr = new int[index];

		int currentVal = 0, biggestVal = 0;
		int newIndex = 0;
		LinkNode current = list.head;

		while (current != null) {

			currentVal = current.data;
			biggestVal = currentVal;
			LinkNode nextCurrent = current.next;

			while (nextCurrent != null) {

				if (nextCurrent.data > biggestVal) {
					biggestVal = nextCurrent.data;
					break;
				}
				nextCurrent = nextCurrent.next;
			}

			if (current.data == biggestVal) {
				biggestVal = 0;
				current.data = 0;
			}

			arr[newIndex] = biggestVal;
			newIndex++;
			current = current.next;
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println();
	}

	public void createList(int thisData) {

		if (list.head == null) {
			list.head = new LinkNode(thisData);
			return;
		}

		LinkNode current = list.head;

		while (current.next != null) {
			current = current.next;
		}

		current.next = new LinkNode(thisData);
	}

	public void deleteAtData(int thisData) {

		LinkNode current = list.head;

		if (current == null) {
			return;
		}

		if (current.data == thisData) {
			list.head = current.next;
			return;
		}

		while (current.next.data != thisData) {
			current = current.next;
		}

		current.next = current.next.next;
	}

	public void deleteAtIndexGoingForward(int indexToFind) {
		LinkNode current = list.head;
		int currentIndex = 0;
		if(current == null) {
			return;
		}
		if(indexToFind == 0) {
			list.head = current.next;
			return;
		}
		while(current != null && currentIndex < indexToFind-1) {
			current = current.next;
			currentIndex++;
		}
		if(current == null || current.next == null) {
			return;
		}
		current.next = current.next.next;
		return;
	}
	

	public LinkNode deleteAtIndexGoingBackward(LinkNode head, int n) {
		LinkNode dummy = new LinkNode(0);
		dummy.next = head;
		LinkNode first = dummy;
		LinkNode second = dummy;
		for (int i = 0; i < n + 1; i++ ){
			first = first.next;
		}
		while(first != null) {
			first = first.next;
			second = second.next;
		}
		second.next = second.next.next;
		return dummy.next;
	}

	public void removeDuplicates() {

		LinkNode current = list.head;

		while (current != null) {

			LinkNode temp = current;

			while (temp.next != null) {

				if (temp.next.data == current.data) {
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

		while (current.next != null) {
			current = current.next;
		}
		current.next = new LinkNode(data);
	}

	public void addAtFront(int data) {

		LinkNode newFront = new LinkNode(data);
		newFront.next = list.head;
		list.head = newFront;

		/**
		 * LinkNode current = list.head; LinkNode newFront = new LinkNode(data);
		 * LinkNode temp = current; list.head = newFront; list.head.next = temp;
		 */
	}

	public void addAfterIndex(int index, int data) {

		LinkNode newLinkNode = new LinkNode(data);
		LinkNode current = list.head;
		int IndexCount = 0;

		while (index != IndexCount) {
			current = current.next;
			IndexCount++;
		}

		if (index == IndexCount) {
			LinkNode next = current.next;
			current.next = newLinkNode;
			newLinkNode.next = next;
		}
	}
	

	public void reverse() {

		LinkNode current = list.head;
		LinkNode next = null;
		LinkNode prev = null;

		while (current != null) {

			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

		list.head = prev;
	}

	public void printMiddleIndex() {

		LinkNode slow = list.head;
		LinkNode fast = list.head;
		int count = 0;

		while (fast != null && fast.next != null) {

			slow = slow.next;
			fast = fast.next.next;
			count++;
		}

		System.out.println("\nMiddle = " + slow.data + ", at index = " + count);
	}

	public void print(String message) {

		System.out.println(message);
		LinkNode current = list.head;

		while (current != null) {
			System.out.print(current.data + ", ");
			current = current.next;
		}

		System.out.println();
		System.out.println();

	}

	/*
	 * public ListNode mergeTwoLists(ListNode l1, ListNode l2) { ListNode list = new
	 * ListNode(); ListNode l1Current = l1; ListNode l2Current = l2;
	 * 
	 * while(l1Current != null || l2Current != null) { if(l1Current.val <=
	 * l2Current.val) { if(list == null) { list = l1Current; } else { list.next =
	 * l1Current; list = list.next; } l1Current = l1Current.next; } else { if(list
	 * == null) { list = l2Current; } else { list.next = l2Current; list =
	 * list.next; } l2Current = l2Current.next; } } return list; }
	 */

}

