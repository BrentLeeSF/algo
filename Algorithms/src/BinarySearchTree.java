

public class BinarySearchTree {
	
	BSTNode root;
	
	public BinarySearchTree() {
		this.root = null;
	}

	public static void main(String[] args) {
		
		BinarySearchTree bst = new BinarySearchTree();
		BSTNode thisRoot = bst.root;
		
		int[] arr = {5,3,7,1,4,0,6,9,2,8};
		
		for(int i = 0; i < arr.length; i++) {
			thisRoot = bst.insert(arr[i], thisRoot);
		}
		bst.printInOrder(thisRoot);
		System.out.println();
		bst.printInOrder(thisRoot, 1);
		
		BSTNode foundNode = bst.findNode(thisRoot, 5);
		System.out.println("\nFound node = "+foundNode.data);
		
		System.out.println("\nHeight = "+bst.height(thisRoot));
		
		System.out.println("\nBalanced? = "+bst.balance(thisRoot));
		
		System.out.println("Smallest Node = "+bst.smallestNode(thisRoot));

		System.out.println("After deleting 5");
		BSTNode newestRoot = bst.delete(thisRoot, 5);
		System.out.println("The Root node is: "+newestRoot.data);
		bst.printInOrder(newestRoot);
		System.out.println();
		bst.printInOrder(newestRoot, 1);
		
		System.out.println("Count Nodes = "+bst.countNodes(newestRoot));
		
		

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
	
	
	public int smallestNode(BSTNode thisRoot) {
		if(thisRoot.left == null) {
			return thisRoot.data;
		}
		return smallestNode(thisRoot.left);
	}
	
	
	public BSTNode delete(BSTNode thisNode, int data) {
		
		// if null
		if(thisNode == null) {
			return thisNode;
		}
		
		// delete node date == data
		if(thisNode.data == data) {
			
			if(thisNode.left == null) {
				return thisNode.right;
				
			} else if(thisNode.right == null) {
				return thisNode.left;
			}
			else {
				if(thisNode.right.left == null) {
					thisNode.data = thisNode.right.data;
					thisNode.right = thisNode.right.right;
					
				} else {
					thisNode.data = smallestNode(thisNode.right);
					return thisNode;
				}
			}
		}
		
		// if delete node data < || > data
		if(thisNode.data > data) {
			thisNode.left = delete(thisNode.left, data);
		} else if(thisNode.data < data) {
			thisNode.right = delete(thisNode.right, data);
		}
				
		return thisNode;
	}
	
	
	public int countNodes(BSTNode thisNode) {
		if(thisNode == null) {
			return 0;
		}
		return (countNodes(thisNode.left) + 1 + countNodes(thisNode.right));
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
