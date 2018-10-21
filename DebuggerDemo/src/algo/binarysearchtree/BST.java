package algo.binarysearchtree;

import java.util.ArrayList;
import java.util.Stack;


public class BST {

	private BSTNode root;
	private int depth = 0;

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

	public void displayTree1() {
		System.out.println("......................................");
		depth = getDepth(root, 1);
		// System.out.println(depth);

		if (root != null) {
			printBlank(getNumberOfBlank(depth));
			System.out.println(root.key);
		}
		printTwoChildren(root, 2, depth);

		// System.out.println(getNumberOfElementBasedOnDepth(depth));

		System.out.println("......................................");

	}

	private String printTwoChildren(BSTNode root, int j, int k) {

		ArrayList<BSTNode> currentLine = new ArrayList<>();
		ArrayList<BSTNode> parentLine = new ArrayList<BSTNode>();
		int treeColumnWidth = 2 * getNumberOfElementBasedOnDepth(depth) - 1;
		int[][] treeKeyMatrix = new int[depth][treeColumnWidth];
		if (root != null) {
			treeKeyMatrix[0][0] = root.key;
		}
		parentLine.add(root);
		for (int i = j; i <= k; i++) {
			currentLine.clear();
			int l = 0;
			for (BSTNode c : parentLine) {
				if ((c.key != 0) && (c.leftChild != null)) {
					currentLine.add(c.leftChild);
					treeKeyMatrix[i - 1][l++] = c.leftChild.key;
					if (l < treeColumnWidth) {
						treeKeyMatrix[i - 1][l++] = -1;
					}
					System.out.print(c.leftChild.key + " ");

				}
				if (c.key == 0 || c.leftChild == null) {
					currentLine.add(new BSTNode(0, "Empty"));
					treeKeyMatrix[i - 1][l++] = 0;
					if (l < treeColumnWidth) {
						treeKeyMatrix[i - 1][l++] = -1;
					}
					System.out.print("--" + " ");
				}
				if (c.key != 0 && c.rightChild != null) {
					currentLine.add(c.rightChild);
					treeKeyMatrix[i - 1][l++] = c.rightChild.key;
					if (l < treeColumnWidth) {
						treeKeyMatrix[i - 1][l++] = -1;
					}
					System.out.print(c.rightChild.key + " ");

				}
				if (c.key == 0 || c.rightChild == null) {
					currentLine.add(new BSTNode(0, "Empty"));
					treeKeyMatrix[i - 1][l++] = 0;
					if (l < treeColumnWidth) {
						treeKeyMatrix[i - 1][l++] = -1;
					}
					System.out.print("--" + " ");

				}
			}
			System.out.println("");
			parentLine.clear();
			parentLine.addAll(currentLine);
		}

		printTreeMatrix(treeKeyMatrix, depth, treeColumnWidth);

		rearrangePosition(treeKeyMatrix, depth, getNumberOfElementBasedOnDepth(k));

		return "";

	}

	private int[][] rearrangePosition(int[][] treeKeyMatrix, int depth2, int numberOfElementBasedOnDepth) {

		int[][] ret = new int[depth2][numberOfElementBasedOnDepth];
		ret[depth2 - 1] = treeKeyMatrix[depth2 - 1].clone();

		for (int i = depth2 - 2; i >= 0; i--) {
			ret[i] = moveElementsBasedOnTheChildPosition(treeKeyMatrix[i + 1], treeKeyMatrix[i]);
		}

		return ret;

	}

	private int[] moveElementsBasedOnTheChildPosition(int[] is, int[] treeKeyMatrix) {

		int previous = 0;

		// find and record the index of each element
		int[] indexArrayForChild = new int[(is.length + 1) / 2];
		int j = 0;
		for (int i = 0; i < is.length; i++) {
			if (is[i] >= 0) {
				if (j < indexArrayForChild.length) {
					indexArrayForChild[j++] = i;
				}
			}
		}
		// find and record the index of each element

		// calculate the inde position for the elements in parent row
		int[] indexArrayForParent = new int[(indexArrayForChild.length) / 2];
		j = 0;
		for (int i = 1; i < indexArrayForChild.length; i++) {
			indexArrayForParent[j++] = (indexArrayForChild[i] + indexArrayForChild[i - 1]) / 2;
			i++;
		}
		// calculate the inde position for the elements in parent row

		// put backup the parent row
		int[] backup = treeKeyMatrix.clone();
		// clear the parent row and make it all blank space
		treeKeyMatrix = new int[treeKeyMatrix.length];
		for (int i = 0; i < treeKeyMatrix.length; i++) {
			treeKeyMatrix[i] = -1;
		}

		// clear the parent row and make it all blank space

		// override the parent row
		j = 0;
		for (int i = 0; (i < backup.length); i++) {
			if (backup[i] >= 0) {
				if (j < indexArrayForParent.length) {
					treeKeyMatrix[indexArrayForParent[j++]] = backup[i];
				}
			}
		}

		return treeKeyMatrix;
	}

	private void printTreeMatrix(int[][] treeKeyMatrix, int row, int column) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				System.out.print(treeKeyMatrix[i][j]);
			}
			System.out.println("");
		}

	}

	private void printBlank(int numberOfBlank) {
		for (int i = 0; i < numberOfBlank; i++) {
			System.out.print(i);
		}

	}

	private int getNumberOfBlank(int i) {

		return (getNumberOfElementBasedOnDepth(depth) / (getNumberOfElementBasedOnDepth(i) + 1)) - 1;
	}

	private int getNumberOfElementBasedOnDepth(int depth) {
		int elements = 2;
		if (depth == 1) {
			return 1;
		}

		for (int i = 2; i <= depth - 1; i++) {
			elements = elements * 2;
		}

		return elements;

	}

	private int getDepth(BSTNode root2, int i) {
		while (root2.leftChild != null || root2.rightChild != null) {
			i++;
			int leftDepth = i;
			int rightDepth = i;
			if (root2.leftChild != null) {
				leftDepth = getDepth(root2.leftChild, i);
			}
			if (root2.rightChild != null) {
				rightDepth = getDepth(root2.rightChild, i);
			}
			if (leftDepth >= rightDepth) {
				return leftDepth;
			} else {
				return rightDepth;
			}
		}

		return i;
	}

	public void displayTree() {
		Stack globalStack = new Stack();
		globalStack.push(root);
		int nBlanks = 32;
		boolean isRowEmpty = false;
		System.out.println("......................................................");

		while (isRowEmpty == false) {
			Stack localStack = new Stack();
			isRowEmpty = true;
			for (int j = 0; j < nBlanks; j++) {
				System.out.print(" ");
			}

			while (globalStack.isEmpty() == false) {
				BSTNode temp = (BSTNode) globalStack.pop();
				if (temp != null) {
					System.out.print(temp.key);
					localStack.push(temp.leftChild);
					localStack.push(temp.rightChild);
					if (temp.leftChild != null || temp.rightChild != null) {
						isRowEmpty = false;
					}
				} else {
					System.out.print("--");
					localStack.push(null);
					localStack.push(null);
				}

				for (int j = 0; j < nBlanks * 2 - 2; j++) {
					System.out.print(" ");
				}
			}

			System.out.println();
			nBlanks = nBlanks / 2;

			while (localStack.isEmpty() == false)
				globalStack.push(localStack.pop());
		}
		System.out.println("......................................................");

	}

}
