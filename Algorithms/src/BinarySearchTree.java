import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
		System.out.println("\n");

		System.out.println("Pre Order");
		bst.printPreOrder(thisRoot);
		System.out.println("\n");

		System.out.println("Post Order");
		bst.printPostOrder(thisRoot);
		System.out.println("\n");

		int inOrderIndex = 0;
		System.out.println("In Order starting at index "+inOrderIndex);
		bst.printInOrder(thisRoot, inOrderIndex);
		System.out.println();
		
		System.out.println("Is this structure a BST? = "+bst.checkIfBST(thisRoot));

		int findNodeWithData = 7;
		BSTNode foundNodeData = bst.findNodeData(thisRoot, findNodeWithData);
		System.out.println("Found node = " + foundNodeData.data);

		System.out.println("\nHeight = " + bst.height(thisRoot));

		System.out.println("\nIs BST Balanced? = " + bst.isBSTBalanced(thisRoot)+"\n");

		System.out.println("Smallest Node = " + bst.returnSmallestNode(thisRoot)+"\n");

		int deleteNodeWithData = 5;
		System.out.println("After deleting node with data "+deleteNodeWithData);
		BSTNode newestRoot = bst.delete(thisRoot, deleteNodeWithData);
		bst.printInOrder(newestRoot);
		System.out.println("\n");
		System.out.println("The Root node is: " + newestRoot.data);
		bst.printInOrder(newestRoot);
		System.out.println("\n");
		bst.printInOrder(newestRoot, 1);

		System.out.println("Count Nodes = " + bst.countNodes(newestRoot));

		System.out.println("Is this a Binary Search Tree? = " + bst.isBSTBalanced(newestRoot));

		System.out.println("\nTop View");
		bst.top_view(newestRoot);

		BSTNode curr = bst.LowestCommonAncestor(newestRoot, 0, 2);
		System.out.println("\n\nLowest Common Ancestor is " + curr.data);
		
		List<Integer> inOrderTraversalList = bst.bstInorderTraversal(newestRoot);
		System.out.println("\nInorder Traversal returned list");
		for(int i = 0; i < inOrderTraversalList.size(); i++) {
			System.out.print(inOrderTraversalList.get(i)+", ");
		}
		System.out.println();
		/**
		 * Serialize and Deserialize Tree
		 * https://www.programcreek.com/2014/05/leetcode-serialize-and-deserialize-binary-tree-java/
		 */
	}
	
	public BSTNode insert(int num, BSTNode curr) {
		if (curr == null) {
			return new BSTNode(num);
		}
		if (num <= curr.data) {
			curr.left = insert(num, curr.left);
		} else {
			curr.right = insert(num, curr.right);
		}
		return curr;
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

	public List<Integer> bstInorderTraversal(BSTNode root) {
		List<Integer> thisList = new ArrayList<Integer>();
		midTraversal(root, thisList);
		return thisList;
	}

	public void midTraversal(BSTNode root, List<Integer> result) {
		if (root == null) return;
		midTraversal(root.left, result);
		result.add(root.data);
		midTraversal(root.right, result);
	}

	/** Check if BST */
	public boolean checkIfBST(BSTNode root) {
		return checkEachBSTNode(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public boolean checkEachBSTNode(BSTNode node, int min, int max) {
		if (node == null) {
			return true;
		}
		if (node.data < min || node.data > max) {
			return false;
		}
		return checkEachBSTNode(node.left, min, node.data - 1) && checkEachBSTNode(node.right, node.data + 1, max);
	}

	public BSTNode findNodeData(BSTNode curr, int num) {
		if (curr.data == num) {
			return curr;
		}
		if (curr.data > num) {
			return findNodeData(curr.left, num);
		}
		return findNodeData(curr.right, num);
	}

	public int height(BSTNode thisRoot) {
		if (thisRoot == null) {
			return 0;
		}
		return 1 + Math.max(height(thisRoot.left), height(thisRoot.right));
	}

	public boolean isBSTBalanced(BSTNode thisRoot) {
		return height(thisRoot.left) == height(thisRoot.right);
	}

	public int returnSmallestNode(BSTNode thisRoot) {
		if (thisRoot.left == null) {
			return thisRoot.data;
		}
		return returnSmallestNode(thisRoot.left);
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

		if (thisNode == null) {
			return thisNode;
		}

		if (thisNode.data == data) {
			if (thisNode.left == null) {
				return thisNode.right;
			}
			else if (thisNode.right == null) {
				return thisNode.left;
			}
			else {
				if (thisNode.right.left == null) {
					thisNode.data = thisNode.right.data;
					thisNode.right = thisNode.right.right;
					return thisNode;
				}
				else {
					thisNode.data = removeSmallestNode(thisNode.right);
					return thisNode;
				}
			}
		}
		if (thisNode.data > data) {
			thisNode.left = delete(thisNode.left, data);
		}
		else if (thisNode.data < data) {
			thisNode.right = delete(thisNode.right, data);
		}
		return thisNode;
	}
	
	public int removeSmallestNode(BSTNode nodeToRemove) {
		if (nodeToRemove.left.left == null) {
			int smallestNode = nodeToRemove.left.data;
			nodeToRemove.left = nodeToRemove.left.right;
			return smallestNode;
		}
		else {
			return removeSmallestNode(nodeToRemove.left);
		}
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


