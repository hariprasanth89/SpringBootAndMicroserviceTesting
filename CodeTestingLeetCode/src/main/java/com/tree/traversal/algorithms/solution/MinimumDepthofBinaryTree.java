package com.tree.traversal.algorithms.solution;

public class MinimumDepthofBinaryTree {
	
	public int minDepth(TreeNode root) {   /// Approach one 
		if (root == null) {
			return 0;
		}
		if (root.left == null) {
			return minDepth(root.right)+1;
		}
		if (root.right == null) {
			return minDepth(root.left)+1;
		}
		return Math.min(minDepth(root.left), minDepth(root.right))+1;
	}
	

	
/*	public int minDepthApproach2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>()<TreeNode>();
        q.add(root);
        int count = 0;
        while (q.size() > 0) {
            //int n = q.size();
            count ++;
            boolean end = false;
            for (int i = 0; i < q.size(); i ++) {
                TreeNode node = q.remove();
                if (node.left == null && node.right == null) {
                    end = true;
                }
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            if (end == true) {
                break;
            }
        }
        return count;
    } */
	
}
