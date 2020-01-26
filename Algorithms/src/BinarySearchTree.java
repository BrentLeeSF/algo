import java.util.Stack;

/*
-----------------------------------------------------------------------------
  date:                       12/16/2019
  file:                       BinarySearchTree.java
-----------------------------------------------------------------------------
  compile:                    javac BinarySearchTree.java
  run:                        java -cp . BinarySearchTree
  debug:                      javac -Xlint BinarySearchTree.java
  jvm version:                javap -verbose BinarySearchTree | grep "major"
-----------------------------------------------------------------------------
*/

public class BinarySearchTree {

	BSTNode root;

	public BinarySearchTree() {
		this.root = null;
	}

	public static void main(String[] args) {

		BinarySearchTree bst = new BinarySearchTree();
		BSTNode thisRoot = bst.root;

		int[] arr = { 5, 3, 7, 1, 4, 0, 6, 9, 2, 8 };

		for (int i = 0; i < arr.length; i++) {
			thisRoot = bst.insert(arr[i], thisRoot);
		}

		System.out.println("In Order");
		bst.printInOrder(thisRoot);
		System.out.println();

		System.out.println("Pre Order");
		bst.printPreOrder(thisRoot);
		System.out.println();

		System.out.println("Post Order");
		bst.printPostOrder(thisRoot);
		System.out.println();

		System.out.println("In Order");
		bst.printInOrder(thisRoot, 1);
		System.out.println();

		BSTNode foundNode = bst.findNode(thisRoot, 5);
		System.out.println("Found node = " + foundNode.data);

		System.out.println("\nHeight = " + bst.height(thisRoot));

		System.out.println("\nBalanced? = " + bst.balance(thisRoot));

		System.out.println("Smallest Node = " + bst.smallestNode(thisRoot));

		System.out.println("After deleting 5");
		BSTNode newestRoot = bst.delete(thisRoot, 5);
		System.out.println("The Root node is: " + newestRoot.data);
		bst.printInOrder(newestRoot);
		System.out.println();
		bst.printInOrder(newestRoot, 1);

		System.out.println("Count Nodes = " + bst.countNodes(newestRoot));

		System.out.println("Is this a Binary Search Tree? = " + bst.balance(newestRoot));

		System.out.println("\nTop View");
		bst.top_view(newestRoot);

		BSTNode curr = bst.LowestCommonAncestor(newestRoot, 0, 2);
		System.out.println("\n\nLowest Common Ancestor is " + curr.data);
		
		
		/**
		 * Serialize and Deserialize Tree
		 * https://www.programcreek.com/2014/05/leetcode-serialize-and-deserialize-binary-tree-java/
		 */
	}

	/** Check if BST */
	boolean checkBST(BSTNode root) {
		return check(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	boolean check(BSTNode node, int min, int max) {
		if (node == null) {
			return true;
		}

		if (node.data < min || node.data > max) {
			return false;
		}

		return check(node.left, min, node.data - 1) && check(node.right, node.data + 1, max);
	}

	public BSTNode insert(int num, BSTNode curr) {
		if (curr == null) {
			return new BSTNode(num);
		}
		if (num <= curr.data) {
			curr.left = insert(num, curr.left);
			return curr;
		} else {
			curr.right = insert(num, curr.right);
			return curr;
		}
	}

	public void printInOrder(BSTNode curr) {
		if (curr != null) {
			printInOrder(curr.left);
			System.out.print(curr.data + ", ");
			printInOrder(curr.right);
		}
	}

	public void printPreOrder(BSTNode curr) {
		if (curr == null) {
			return;
		}
		System.out.print(curr.data + ", ");
		printPostOrder(curr.left);
		printPostOrder(curr.right);
	}

	public void printPostOrder(BSTNode curr) {
		if (curr == null) {
			return;
		}
		printPostOrder(curr.left);
		printPostOrder(curr.right);
		System.out.print(curr.data + ", ");
	}

	public void printInOrder(BSTNode curr, int indent) {
		if (curr != null) {
			for (int i = 0; i < indent; i++) {
				System.out.print(" ");
			}
			printInOrder(curr.left, indent + 1);
			System.out.println(curr.data);
			printInOrder(curr.right, indent + 1);
		}
	}

	public BSTNode findNode(BSTNode curr, int num) {
		if (curr.data == num) {
			return curr;
		}
		if (curr.data > num) {
			return findNode(curr.left, num);
			// return curr;
		}
		return findNode(curr.right, num);
		// return curr;
	}

	public int height(BSTNode thisRoot) {
		if (thisRoot == null)
			return 0;
		return 1 + Math.max(height(thisRoot.left), height(thisRoot.right));
	}

	public boolean balance(BSTNode thisRoot) {
		int left = height(thisRoot.left);
		int right = height(thisRoot.right);
		System.out.println("Left height = " + left + ", right height = " + right);
		return height(thisRoot.left) == height(thisRoot.right);
	}

	public int smallestNode(BSTNode thisRoot) {
		if (thisRoot.left == null) {
			return thisRoot.data;
		}
		// return thisRoot.data = smallestNode(thisRoot.left);
		return smallestNode(thisRoot.left);
	}

	public BSTNode LowestCommonAncestor(BSTNode root, int data1, int data2) {
		if (root == null) {
			return null;
		}
		if (data1 > data2) {
			int temp = data2;
			data2 = data1;
			data1 = temp;
		}
		while (root.data < data1 || root.data > data2) {
			if (root.data < data1) {
				root = root.right;
			} else if (root.data > data2) {
				root = root.left;
			}
		}
		return root;
	}

	public BSTNode delete(BSTNode thisNode, int data) {

		// if null
		if (thisNode == null) {
			return thisNode;
		}

		// delete node date == data
		if (thisNode.data == data) {

			if (thisNode.left == null) {
				return thisNode.right;

			} else if (thisNode.right == null) {
				return thisNode.left;
			} else {
				if (thisNode.right.left == null) {
					thisNode.data = thisNode.right.data;
					thisNode.right = thisNode.right.right;

				} else {
					thisNode.data = smallestNode(thisNode.right);
					return thisNode;
				}
			}
		}

		// if delete node data < || > data
		if (thisNode.data > data) {
			thisNode.left = delete(thisNode.left, data);
		} else if (thisNode.data < data) {
			thisNode.right = delete(thisNode.right, data);
		}

		return thisNode;
	}

	public int countNodes(BSTNode thisNode) {
		if (thisNode == null) {
			return 0;
		}
		return (countNodes(thisNode.left) + 1 + countNodes(thisNode.right));
	}

	/**
	 * Print top view of tree 1 2 3 5 4 6
	 * 
	 * Top view = 1->2->5->6
	 * 
	 * https://www.hackerrank.com/challenges/tree-top-view/forum
	 */
	public void top_view(BSTNode root) {

		BSTNode curr = root;
		Stack<BSTNode> stack = new Stack<BSTNode>();

		while (curr != null) {
			stack.push(curr);
			System.out.print(curr.data + " ");
			curr = curr.left;
		}

		while (!stack.isEmpty()) {
			BSTNode node = stack.pop();
			System.out.print(node.data + " ");
		}

		curr = root.right;
		while (curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.right;
		}
	}

	/**
	 * http://stackoverflow.com/questions/31409989/what-is-the-best-approach-binary-search-tree-lowest-common-ancestor-using-onl
	 */
	public BSTNode lowestCommonAncestor(BSTNode root, int v1, int v2) {
		if (root == null) {
			return null;
		}
		/** If both v1 and v2 are smaller than root, then LCA lies in left */
		if (root.data > v1 && root.data > v2) {
			return lowestCommonAncestor(root.left, v1, v2);
		}
		/** If both v1 and v2 are greater than root, then LCA lies in right */
		if (root.data < v1 && root.data < v2) {
			return lowestCommonAncestor(root.right, v1, v2);
		}
		return root;
	}
	
}

class BSTNode {

	BSTNode left, right, root;
	int data;

	public BSTNode() {
		this.root = null;
	}

	public BSTNode(int data) {
		this.data = data;
		left = right = null;
	}
}
