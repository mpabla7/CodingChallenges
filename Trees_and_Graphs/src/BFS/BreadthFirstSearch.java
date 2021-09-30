package BFS;

import java.util.LinkedList;
import java.util.Queue;
import TreeNode.TreeNode;

public class BreadthFirstSearch {

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
	BFS(root);
	}
	
	public static void BFS(TreeNode node) {
		
		if(node == null) return;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(node);
		while(!q.isEmpty()) {
			TreeNode cur = q.remove();
			System.out.println(cur.val);
			if(cur.left != null) q.add(cur.left);
			if(cur.right != null) q.add(cur.right);
		}
	}

}
