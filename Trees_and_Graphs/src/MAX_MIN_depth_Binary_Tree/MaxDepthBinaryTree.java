package MAX_MIN_depth_Binary_Tree;

import java.util.LinkedList;
import java.util.Queue;
import TreeNode.TreeNode;


public class MaxDepthBinaryTree {

	public static void main(String[] args) {
		
		// [3,9,20,null,null,15,7]
	  //         3
	 //         / \
	 //        9  20
	 //          /  \
	 ///        15   7
	
	TreeNode root = new TreeNode(3);
	root.left = new TreeNode(9);
	root.right = new TreeNode(20);
	root.right.right = new TreeNode(7);
	root.right.left = new TreeNode(15);
	
	//System.out.println(maxDepth(root));
//	System.out.println(minDepth(root));
	reverse(123);
	
	}
	
	public static void reverse(int number) {
		
		int result = 0;
		while(number != 0) {
			int x = number %10;
			result = result * 10 + x;
			number = number / 10;
		}
		System.out.println(result);
		
	}
/**
 * 104. Maximum Depth of Binary Tree
 * 
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest 
 * path from the root node down to the farthest leaf node.
 * @param TreeNode root
 * @return Max depth of binary tree
 */
public static int maxDepth(TreeNode root) {

        if(root == null) return 0;

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int n = q.size();
        int depth = 0;
        
        while(!q.isEmpty()) {
            while(n > 0) {
                TreeNode cur = q.remove();
                if(cur.right != null) {
                    q.add(cur.right);
                }
                if(cur.left != null) {
                    q.add(cur.left);
                }
                n--;
            }
            n = q.size();
            depth+=1;
        }
        return depth;
        
    }

/**
 * 111. Minimum Depth of Binary Tree
 * 
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest
 * path from the root node down to the nearest leaf node.
 * @param TreeNode root
 * @return min depth of binary tree
 */
public static int minDepth(TreeNode root) {
    
    if(root == null) return 0;
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    int d = 1;
    int n = q.size();
    
    while(!q.isEmpty()) {
        
        while(n > 0) {
            TreeNode cur = q.remove();
            if(cur.left == null && cur.right == null) return d;
            if(cur.left != null) q.add(cur.left);
            if(cur.right != null) q.add(cur.right);
            n--;
        }
        n = q.size();
        d++;
    }
    return d;
}




}
