package leetcode.challenge;

import java.util.LinkedList;

public class MinimumDepthofBinaryTree {

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(3);
		TreeNode n2 = new TreeNode(9);
		n1.left = n2;
		TreeNode n3 = new TreeNode(20);
		n1.right = n3;
		TreeNode n4 = new TreeNode(15);
		n3.left = n4;
		TreeNode n5 = new TreeNode(7);
		n3.right = n5;

//		TreeNode n6 = new TreeNode(7);
//		n2.left = n6;
//		TreeNode n7 = new TreeNode(7);
//		n2.right = n7;
//
//		TreeNode n8 = new TreeNode(7);
//		n6.left = n8;

		System.out.println(minDepth(n1));
		
		TreeNode n9 = new TreeNode(1);
		TreeNode n10 = new TreeNode(2);
		n9.left = n10;
		TreeNode n11 = new TreeNode(3);
		n9.right = n11;
		TreeNode n12 = new TreeNode(4);
		n10.left = n12;
		TreeNode n13 = new TreeNode(5);
		n11.right = n13;

		System.out.println(minDepth(n9));
	}

	public static int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int curLevel = 1;
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			for(int i=0;i<size;i++) {
				TreeNode cur = queue.poll();
				
				if(cur.left==null && cur.right==null) {
					return curLevel;
				}
				
				if(cur.left!=null) {
					queue.add(cur.left);
				}
				if(cur.right!=null) {
					queue.add(cur.right);
				}
			}
			curLevel++;
		}
		
		return curLevel;
	}

}
