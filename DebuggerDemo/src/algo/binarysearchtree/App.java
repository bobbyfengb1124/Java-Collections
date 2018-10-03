package algo.binarysearchtree;

public class App {

	public static void main(String[] args) {

		BST tree = new BST();
		tree.insert(10, "Ten");
		tree.insert(20, "twenty");
		tree.insert(15, "fifteen");
		
		System.out.println(tree.findMin().key);
		System.out.println(tree.findMax().key);
		
		System.out.println(tree.remove(10));
		
		System.out.println(tree.findMin().key);
	}

}
