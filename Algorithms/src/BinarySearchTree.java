

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
		
		int[] arr = {5,3,7,8,4,6,9, 2, 1, 0};
		
		for(int i = 0; i < arr.length; i++) {
			thisRoot = bst.insert(arr[i], thisRoot);
		}
		bst.printInOrder(thisRoot);
		System.out.println("\n");
		bst.printInOrder(thisRoot, 1);
		
		BSTNode foundNode = bst.findNode(thisRoot, 5);
		System.out.println("\nFound node = "+foundNode.data);
		
		System.out.println("\nHeight = "+bst.height(thisRoot));
		
		System.out.println("\nBalanced? = "+bst.balance(thisRoot));

	}
	
	
	public BSTNode insert(int num, BSTNode curr) {
		if(curr == null) {
			BSTNode thisNode = new BSTNode(num);
			return thisNode;
		}
		if(num <= curr.data) {
			curr.left = insert(num, curr.left);
			return curr;
		} else {
			curr.right = insert(num, curr.right);
			return curr;
		}
	}
	
	
	public void printInOrder(BSTNode curr) {
		if(curr != null) {
			printInOrder(curr.left);
			System.out.print(curr.data+", ");
			printInOrder(curr.right);
		}
	}
	
	
	public void printInOrder(BSTNode curr, int indent) {
		if(curr != null) {
			for(int i = 0; i < indent; i++) {
				System.out.print(" ");
			}
			printInOrder(curr.left, indent+1);
			System.out.println(curr.data);
			printInOrder(curr.right, indent+1);
		}
	}
	
	
	public BSTNode findNode(BSTNode curr, int num) {
		if(curr.data == num) {
			return curr;
		}
		if(curr.data > num) {
			return findNode(curr.left, num);
		}
		return findNode(curr.right, num);
	}
	
	
	public int height(BSTNode thisRoot) {
		if(thisRoot == null)
			return 0;
		return 1 + Math.max(height(thisRoot.left), height(thisRoot.right));
	}
	
	
	public boolean balance(BSTNode thisRoot) {
		int left = height(thisRoot.left);
		int right = height(thisRoot.right);
		System.out.println("Left = "+left+", right = "+right);
		return height(thisRoot.left) == height(thisRoot.right);
	}

}
