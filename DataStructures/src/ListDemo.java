import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;
import java.util.Vector;

/**
 * https://docs.oracle.com/javase/8/docs/api/java/util/List.html add() get()
 * remove() or remove(index) listIterator() size()
 */

public class ListDemo {

	ArrayList<String> arList;
	LinkedList<String> linkList;
	Stack<String> stackList;
	Vector<String> vectorList;

	String[] states = { "Alabama", "Alaska", "American Samoa", "Arizona", "Arkansas", "California", "Colorado",
			"Connecticut", "Delaware", "District of Columbia", "Federated States of Micronesia", "Florida", "Georgia",
			"Guam", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine",
			"Marshall Islands", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri",
			"Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina",
			"North Dakota", "Northern Mariana Islands", "Ohio", "Oklahoma", "Oregon", "Palau", "Pennsylvania",
			"Puerto Rico", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont",
			"Virgin Island", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming" };

	public ListDemo() {
		arList = new ArrayList<String>();
		linkList = new LinkedList<String>();
		stackList = new Stack<String>();
		vectorList = new Vector<String>();
	}

	public static void main(String[] args) {

		ListDemo lists = new ListDemo();

		/** ArrayList */
		lists.arrayListDemo(lists.arList, lists.states);

		/** LinkedList */
		lists.linkListDemo(lists.linkList, lists.states);
		// lists.stackDemo(lists.stackList, lists.states);

	}

	public void arrayListDemo(ArrayList<String> arList2, String[] theseStates) {

		for (int i = 0; i < theseStates.length; i++) {
			arList2.add(theseStates[i]);
		}

		for (int j = 0; j < arList2.size(); j++) {
			if (j != 0 && j % 5 == 0) {
				arList2.remove(j);
			}
		}

		System.out.println("Array List States");
		for (int j = 0; j < arList2.size(); j++) {
			System.out.print(arList2.get(j) + ", ");
		}
		System.out.println();
	}

	public void linkListDemo(LinkedList<String> thisLinkedList, String[] theseStates) {

		for (String state : theseStates) {
			thisLinkedList.add(state);
		}

		/**
		 * https://stackoverflow.com/questions/10020212/any-advice-on-how-i-can-do-the-loop-to-remove-the-nth-element
		 */
		ListIterator<String> iter = thisLinkedList.listIterator();
		for (int i = 0; i < thisLinkedList.size(); i++) {
			iter.next();
			if (i != 0 && i % 5 == 0) {
				iter.remove();
			}
		}

		System.out.println("Linked List");
		ListIterator<String> iter2 = thisLinkedList.listIterator();
		while (iter2.hasNext()) {
			System.out.print(iter2.next() + ", ");
		}
		System.out.println();
	}

	public void stackDemo(Stack<String> thisStack, String[] theseStates) {
		for (String state : theseStates) {
			thisStack.add(state);
		}

	}

}
