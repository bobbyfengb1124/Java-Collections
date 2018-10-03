package algo.binarysearchtree;

public class BST {

	private BSTNode root;

	public void insert(int key, String value) {
		BSTNode newNode = new BSTNode(key, value);

		if (root == null) {
			root = newNode;
		} else {
			BSTNode current = root;
			BSTNode parent;

			while (true) {
				parent = current;
				if (key < current.key) {
					current = current.leftChild;
					if (current == null) { // it's parent is the leaf node
						parent.leftChild = newNode;
						return;
					}
				} else {
					current = current.rightChild;
					if (current == null) {
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}

	}

	public boolean remove(int key) {

		BSTNode current = root;
		BSTNode parent = root;

		boolean isLeftChild = false;

		// searching to find the node with the key to delete
		while (current.key != key) {
			parent = current;
			if (current.key > key) {
				isLeftChild = true;
				current = current.leftChild;
			} else {
				current = current.rightChild;
				isLeftChild = false;
			}
			if (current == null) {
				return false;
			}
		}

		// found the node
		BSTNode nodeToDelete = current;

		// if node is a leaf
		if (nodeToDelete.leftChild == null && nodeToDelete.rightChild == null) {
			if (nodeToDelete == root) {
				root = null;
			} else if (isLeftChild) {
				parent.leftChild = null;
			} else {
				parent.rightChild = null;
			}
		}
		// if node has a child is on the left
		else if (nodeToDelete.rightChild == null) {
			if (nodeToDelete == root) {
				root = nodeToDelete.leftChild;
			} else if (isLeftChild) {
				parent.leftChild = nodeToDelete.leftChild;
			} else {
				parent.rightChild = nodeToDelete.leftChild;
			}
		}
		// if node has one child that is on the right
		else if (nodeToDelete.leftChild == null) {
			if (nodeToDelete == root) {
				root = nodeToDelete.rightChild;
			} else if (isLeftChild) {
				parent.leftChild = nodeToDelete.rightChild;
			} else {
				parent = nodeToDelete.rightChild;
			}
		}
		// if node has 2 children
		else {
			BSTNode successor = getSuccessor(nodeToDelete);
			// connect parent of nodeToDelete to successor instead
			if (nodeToDelete == root) {
				root = successor;
			} else if (isLeftChild) {
				parent.leftChild = successor;
			} else {
				parent.rightChild = successor;
			}

			successor.leftChild = nodeToDelete.leftChild;
		}

		return true;
	}

	private BSTNode getSuccessor(BSTNode nodeToDelete) {

		BSTNode successorParent = nodeToDelete;
		BSTNode successor = nodeToDelete;

		BSTNode current = nodeToDelete.rightChild; // go to the right child
		while (current != null) { // start going left down the tree until node has no left child
			successorParent = successor;
			successor = current;
			current = current.leftChild;
		}
		// if successor not a right child
		if (successor != nodeToDelete.rightChild) {
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = nodeToDelete.rightChild;
		}

		return successor;
	}

	public BSTNode findMin() {
		BSTNode current = root;
		BSTNode last = null;

		while (current != null) {
			last = current;
			current = current.leftChild;
		}
		return last;
	}

	public BSTNode findMax() {
		BSTNode current = root;
		BSTNode last = null;

		while (current != null) {
			last = current;
			current = current.rightChild;
		}
		return last;
	}

}
