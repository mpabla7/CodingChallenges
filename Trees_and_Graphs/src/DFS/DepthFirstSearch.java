package DFS;
import TreeNode.TreeNode;

public class DepthFirstSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
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
		preOrderDFS(root);

	}
	
	// 3 9 20 15 7   
	// Preorder  (Root, Left, Right)
	public static void preOrderDFS(TreeNode root) {
		if(root == null) { 
			//System.out.println(root);
			return;
		}
		System.out.println(root.val);
		preOrderDFS(root.left);
		preOrderDFS(root.right);
	}
	
	// (left, right, root) 
	// 9 15 7 20 3 
	public static void postOrderDFS(TreeNode root) {
		if(root == null) return;
		postOrderDFS(root.left);
		postOrderDFS(root.right);
		System.out.println(root.val);
	}
	
	// (left , root , right) 
	// 9, 3, 15, 20, 7 
	public static void inOrderDFS(TreeNode root) {
		if(root == null) return;
		inOrderDFS(root.left);
		System.out.println(root.val);
		inOrderDFS(root.right);
	}

}
