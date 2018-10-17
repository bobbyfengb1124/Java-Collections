package algo.heap;

public class Heap {

	private HeapNode[] heapArray;
	private int maxSize; // size of the array
	private int currentSize; // number of nodes in the array

	public Heap(int size) {
		this.maxSize = size;
		currentSize = 0;
		heapArray = new HeapNode[size]; // actually creates the array
	}

	public int getSize() {
		return currentSize;
	}

	public boolean isEmpty() {
		return (currentSize == 0);
	}

	public HeapNode remove() {

		HeapNode root = heapArray[0];

		if (this.isEmpty()) {
			return null;
		}

		heapArray[0] = heapArray[currentSize];
		trickleDown(0);
		currentSize--;

		return root;
	}

	private void trickleDown(int i) {
		int indx = i;
		int largerChildIdx;

		HeapNode top = heapArray[indx];
		while (indx < currentSize / 2) {
			int leftChild = indx * 2 + 1;
			int rightChild = indx * 2 + 2;

			// figure out which child is larger
			if (rightChild < currentSize && heapArray[leftChild].getKey() < heapArray[rightChild].getKey()) {
				largerChildIdx = rightChild;
			} else {
				largerChildIdx = leftChild;
			}
			if (top.getKey() >= heapArray[largerChildIdx].getKey()) {
				// Successfully mode root the largest key
				break;
			}

			heapArray[indx] = heapArray[largerChildIdx];
			indx = largerChildIdx;
		}
		heapArray[indx] = top;

	}

	public boolean insert(int key) {
		if (currentSize == maxSize) {// array is full
			return false;
		}

		HeapNode newNode = new HeapNode(key);
		heapArray[currentSize] = newNode;

		trickleUp(currentSize);

		currentSize++;
		displayHeap1();

		return true;
	}

	private void trickleUp(int idx) {
		int parentIdx = (idx - 1) / 2;
		HeapNode nodeToInsert = heapArray[idx];

		// loop as long as we haven't reached the root and key of idx's parent is less
		// than new node
		while (idx > 0 && heapArray[parentIdx].getKey() < nodeToInsert.getKey()) {
			heapArray[idx] = heapArray[parentIdx]; // move parent down
			idx = parentIdx;
			parentIdx = (parentIdx - 1) / 2;
		}
		heapArray[idx] = nodeToInsert;

	}

	public void displayHeap1() {
		System.out.println("Heap Array: ");
		for (int m = 0; m < currentSize; m++) {
			if (heapArray[m] != null) {
				System.out.print(heapArray[m].getKey() + " ");
			}
			System.out.println();

			int nBlanks = 32;
			int itemsPerRow = 1;
			int column = 0;
			int j = 0; // current item

			String dots = "...............................";
			System.out.println(dots + dots);
			while (currentSize > 0) {
				if (column == 0) {
					for (int k = 0; k < nBlanks; k++) {
						System.out.print(" ");
					}
				}
				System.out.print(heapArray[j].getKey());
				j++;
				if (j == currentSize) {
					break;
				}

				column++;
				// end of row
				if (column == itemsPerRow) {
					nBlanks = nBlanks / 2; // half the blanks
					itemsPerRow = itemsPerRow * 2; // twice the items
					column = 0;
					System.out.println();
				} else {
					for (int k = 0; k < nBlanks * 2; k++) {
						System.out.print(" ");
					}
				}

			}
			System.out.println("\n" + dots + dots);
		}

	}

	public void displayHeap() {
		int depth = getDepth(currentSize);
		System.out.println("depth: " + depth);

		printTreeWithKeyOnly(currentSize, depth);

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

	private void printTreeWithKeyOnly(int currentSize2, int depth) {
		int currentIdx = currentSize2 - 1;
		int parentIdx = (currentIdx - 1) / 2;
		int lastRowLength = getLastRowLength(depth);

		for (int i = 1; i <= depth; i++) {
			int spaceNumber = lastRowLength / (getNumberOfElementBasedOnDepth(i) + 1);

			int numOfElements = getNumberOfElementBasedOnDepth(i);
			int startIdx = getStartIdxBasedOnDepth(i);
			for (int j = startIdx; j < (startIdx + numOfElements) && (j < heapArray.length); j++) {
				printSpace(spaceNumber);
				if (heapArray[j] != null && j < heapArray.length) {
					System.out.print(heapArray[j].getKey() + " ");
				}
			}
			System.out.println();
		}

	}

	private void printSpace(int number) {
		for (int i = 0; i < number; i++) {
			System.out.print(" ");
		}

	}

	private int getStartIdxBasedOnDepth(int depth) {
		int startIndex = 0;
		for (int i = 2; i <= depth; i++) {
			startIndex = startIndex + getNumberOfElementBasedOnDepth(i - 1);
		}
		return startIndex;
	}

	private int getLastRowLength(int depth) {
		return getNumberOfElementBasedOnDepth(depth) * 2 - 1;
	}

	private int getDepth(int idx) {
		int currentIdx = idx - 1;
		int parentIdx = (currentIdx - 1) / 2;
		int depth = 0;
		boolean hasParent = false;

		if (currentSize == 0) {
			return depth;
		} else {
			depth = 1;
		}

		if (currentIdx > 0)
			hasParent = true;

		while (hasParent) {
			depth++;
			currentIdx = parentIdx;
			parentIdx = (parentIdx - 1) / 2;
			if (currentIdx > 0)
				hasParent = true;
			else
				hasParent = false;
		}

		return depth;
	}
}
