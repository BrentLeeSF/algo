
class LinkedListNode {
	int val;
	LinkedListNode next;
	LinkedListNode(int x) { val = x; }
}

public class LinkedListMedium {
	
	public static void main(String[] args) { }
	

	public LinkedListNode addTwoNumbers(LinkedListNode l1, LinkedListNode l2) {
		
		LinkedListNode dummy = new LinkedListNode(-1);
		LinkedListNode curr = dummy;
        int thisNum = 0;

        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            
            int sum = x + y + thisNum;	
            
            thisNum = sum / 10;
            
            curr.next = new LinkedListNode(sum % 10);
            curr = curr.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (thisNum != 0) {
            curr.next = new LinkedListNode(thisNum);
        }

        return dummy.next;
        
        
		/*int currentAdd = 0, overNine = 0;
		LinkedListNode currentL1 = l1;
		LinkedListNode currentL2 = l2;
		
		LinkedListNode test = new LinkedListNode(-1);
		
		LinkedListNode curr = test;
		
		while (currentL1 != null) {
			currentAdd = currentL1.val + currentL2.val;
			if (currentAdd < 10) {
				curr.next = new LinkedListNode(currentAdd);
			} else {
				overNine = 1;
				currentAdd -= 10;
				curr.next = new LinkedListNode(currentAdd);
			}
			curr = curr.next;
			currentL1 = currentL1.next;
			currentL2 = currentL2.next;
		}
		return curr;*/
	}
}
