package algo.binarysearchtree;

public class App {

	public static void main(String[] args) {

		BST tree = new BST();
		tree.insert(10, "Ten");
		tree.insert(4, "Four");
		tree.insert(20, "twenty");
		tree.insert(2, "Two");
		tree.insert(5, "Five");
		tree.insert(8, "Eight");
		tree.insert(9, "Nine");
		tree.insert(18, "Eighteen");
		tree.insert(22, "Tweenty Two");
		tree.insert(17, "Seventeen");
		tree.insert(19, "Nineteen");
		tree.insert(21, "TwentyOne");
		tree.insert(24, "TwentyFour");
		tree.insert(33, "ThirdtyThree");
		tree.insert(6, "ThirdtyThree");
		tree.insert(7, "ThirdtyThree");
		tree.insert(34, "ThirdtyThree");
		tree.insert(23, "ThirdtyThree");
		tree.insert(35, "ThirdtyThree");
		tree.insert(36, "ThirdtyThree");
		
		System.out.println(tree.findMin().key);
		System.out.println(tree.findMax().key);
		
		System.out.println(tree.remove(10));
		
		System.out.println(tree.findMin().key);
		
		tree.displayTree();
	}

}
