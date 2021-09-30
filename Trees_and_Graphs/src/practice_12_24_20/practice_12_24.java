package practice_12_24_20;
import java.util.LinkedList;
import java.util.Queue;

import TreeNode.TreeNode;
/**
 * Today's goal is just to review binary tree algos 
 * 
 * 
 * @author mandeeppabla
 *
 */

public class practice_12_24 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  //         3
		 //         / \
		 //        9  20
		 //          /  \
		 ///        15   7
		//              /
		//             21
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.right = new TreeNode(7);
		root.right.left = new TreeNode(15);
		root.right.right.left = new TreeNode(21);
		
		dfs_pre_order(root);

	}
	/**
	 *  Just a BFS algo
	 * @param root
	 */
	public static void BFS(TreeNode root) {	
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
			TreeNode cur = q.remove();
			System.out.println(cur.val);
			if(cur.left != null) q.add(cur.left);
			if(cur.right != null) q.add(cur.right);
		}	
	}
	
	// DFS -> pre-order: root, left, right
	// DFS -> post-order: left, right, root
	/**
	 * Just a dfs (PRE-ORDER algo)
	 * 
	 * @param root
	 */
	public static void dfs_pre_order(TreeNode root) {
		
		if(root == null) return; 
		// visit(root)
		System.out.println(root.val);
		dfs_pre_order(root.left);
		dfs_pre_order(root.right);
		
	}
	
	/**
	 *     104. Maximum Depth of Binary Tree
	 *     Solve time: 4:23 mins 
	 */
    public int maxDepth(TreeNode root) {
        
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int depth = 0; 
        int size = q.size();
        
        while(!q.isEmpty()) {
            while(size > 0) {
                TreeNode cur = q.remove();
                if(cur.left != null) q.add(cur.left);
                if(cur.right != null) q.add(cur.right);
                size--;
            }
            size = q.size();
            depth+=1; 
        }
        return depth;   
    }
}
