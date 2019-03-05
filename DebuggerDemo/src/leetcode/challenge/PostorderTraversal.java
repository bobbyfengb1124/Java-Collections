package leetcode.challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class PostorderTraversal {

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		n1.left = n2;
		TreeNode n3 = new TreeNode(3);
		n1.right = n3;
		TreeNode n4 = new TreeNode(4);
		n2.left = n4;
		TreeNode n5 = new TreeNode(5);
		n2.right = n5;
		TreeNode n6 = new TreeNode(6);
		n3.left = n6;
		TreeNode n7 = new TreeNode(7);
		n3.right = n7;
		List<Integer> list = postorderTraversal(n1);
		for (Integer i : list) {
			System.out.println(i);
		}

	}

	public static List<Integer> postorderTraversal(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> ret = new ArrayList<>();

		if (root != null) {
			stack.push(root);
		}
		else {
			return ret;
		}

		while (!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			ret.add(cur.val);
			if (cur.left != null) {
				stack.push(cur.left);
			}
			if (cur.right != null) {
				stack.push(cur.right);
			}

		}

		Collections.reverse(ret);

		return ret;

	}

}
