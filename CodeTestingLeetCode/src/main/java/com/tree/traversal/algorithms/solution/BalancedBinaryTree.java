package com.tree.traversal.algorithms.solution;

public class BalancedBinaryTree {
	
	/* public boolean isBalanced(TreeNode root) {
		if(root == null) return true;
		return Math.abs(maxDepth(root.left) - maxDepth(root.right) <=1 && isBalanced(root.left) && isBalanced(root.right));
	}
	
	private int  maxDepth(TreeNode root) {
		if(root == null) return 0;
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}                               
*/
	
	
	//// Another way approach
	
	public boolean isBalancedCheck(TreeNode root) {
		if(root == null) 
			return true;
		return height(root) > 0;
	}
	
	private int height(TreeNode root) {
		if (root == null ) {
			return 0;
		}
		int left = height(root.left);
		int right = height(root.right);
		if (left < 0 || right < 0 || Math.abs(left - right) > 1) {
			return -1;
		}
		return Math.max(left, right)+1;
	}
	
}
