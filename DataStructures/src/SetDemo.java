import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

class SetNode {

	String setKey;
	int setValue;

	public SetNode(String setKey, int setValue) {
		this.setKey = setKey;
		this.setValue = setValue;
	}

}

public class SetDemo {

	public static void main(String[] args) {

		SetDemo setDem = new SetDemo();
		String[] arr = { "a", "b", "c", "b", "d", "e", "b", "c", "f", "a" };

		HashSet<String> hashSetin = new HashSet<String>();

		/**
		 * LinkedHashSet - is an ordered version of HashSet that maintains a
		 * doubly-linked List across all elements.
		 */
		LinkedHashSet<SetNode> linkedHashSet = new LinkedHashSet<SetNode>();
		setDem.linkhashset(linkedHashSet, arr);

		TreeSet<String> treeSettin = new TreeSet<String>();
	}

	public void linkhashset(LinkedHashSet<SetNode> linkhashset, String[] arr) {

		for (int i = 0; i < arr.length; i++) {
			if (!linkhashset.contains(arr[i])) {

			}
		}
	}
}
