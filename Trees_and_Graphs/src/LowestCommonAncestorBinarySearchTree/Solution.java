package LowestCommonAncestorBinarySearchTree;
import TreeNode.TreeNode;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//	     6
		//	    / \
		//	   2   8
		//	  / \  | \
		//	 0   4 7  9
		//      / \
		//		3  5 
 		
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(2);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(9);
		root.right.left = new TreeNode(7);
		
		root.left.right.right = new TreeNode(5);
		root.left.right.left = new TreeNode(3);
		
		// root = 6, p = 3, q = 0
		System.out.println(lowestCommonAncestor(root, root.left.right.left,root.left.left ).val); // LCA = 2
	}
	
	/*
	 * 235. Lowest Common Ancestor of a Binary Search Tree
	 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
	 *      
	 * https://www.youtube.com/watch?v=F-_1sbnPbWQ&ab_channel=VivekanandKhyade-AlgorithmEveryDay
	 */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null || root == p || q == root) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        System.out.println(left);
        System.out.println(right);
        if(left == null) {
            return right;
        } else if (right == null) {
            return left;
        }
        return root;
    }

}
