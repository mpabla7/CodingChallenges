package ConstructBinaryTreeFromPreorderAndInorderTraversal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import TreeNode.TreeNode;


public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] preorder = new int[] {3,9,20,15,7};
//		int[] inorder = new int[] {9,3,15,20,7};
		int[] preorder = new int[] {1,2,4,8,9,10,11,5,3,6,7};
		int[] inorder = new int[] {8,4,10,9,11,2,5,1,6,3,7};
		
		buildTree(preorder, inorder);
	}
	 private static ArrayList<Integer> tree = new ArrayList<>();
	 private static TreeNode root1 = null;
	 private static TreeNode cur1 = root1;
	 
	 public static TreeNode buildTree(int[] preorder, int[] inorder) {
		 
		 //if(preorder.length != inorder.length || preorder.length == 0) return null;
		 int[] visited = new int[inorder.length];
	     int[] leftSubTree;
	     int[] rightSubTree;
	     TreeNode root = new TreeNode(preorder[0]); 
	     tree.add(preorder[0]);
	     TreeNode cur = root;
	     
	     // keys = in-order values, values = indices 
		 HashMap<Integer, Integer> map = new HashMap<>();
		 for(int i =0;i < inorder.length; i++) {
			 map.put(inorder[i], i);
		 }
		 
		 for(int i =0 ; i < preorder.length; i++) {
			 
			 int curRoot = preorder[i];  // walk thru the pre-order array one value at a time
			 int curIndex = map.get(curRoot);  // index of coresponding element in in-order array
			 int nonZeroIndex = 0;
			
			 visited[curIndex]++;
			 
			 int leftStart = 0, leftStop = 0;
			 
			 for(int j =0; j < curIndex; j++) {
				 if(visited[j]==0) {
					 leftStart = j;
					 leftStop = curIndex;
				 }
			 }
			 
			 int rightStart = 0, rightStop = 0;
			 
			 ArrayList<Integer> list = new ArrayList<>();
			 for(int j = preorder.length - 1;  j > curIndex; j--) {
				 
				 if(visited[j] == 0) {
					 list.add(inorder[j]);
				 } else {
					 list = new ArrayList<>();
					 break;
				 }
				
			 }
			 
			 leftSubTree = Arrays.copyOfRange(inorder, leftStart, leftStop);
			 rightSubTree = list.stream().mapToInt(ii -> ii).toArray(); 
			 
			 int leftNode = findLeast(preorder, leftSubTree); 
			 int rightNode = findLeast(preorder, rightSubTree);
			 
//			 System.out.println("----------------");
//			// System.out.println("length of leftSubtree = " + leftSubTree.length);
//			 System.out.println("left sub tree least amount: " + leftNode );
//			 for(int r : leftSubTree) System.out.println(r);
//			 System.out.println("right sub tree least amount: " + rightNode);
//			 for(int r : rightSubTree) System.out.println(r);
//			 System.out.println("----------------");
			 
//			 if(leftNode != -1 ) {
//				 tree.add(leftNode);
//			 } else {
//				 tree.add(null);
//			 }
//			 
//			 if(rightNode != -1) {
//				 tree.add(rightNode);
//			 } else {
//				 tree.add(null);
//			 }
			 tree.add(leftNode);
			 tree.add(rightNode);
			 
			 
		 }
		 
//		 TreeNode root1 = null;
//		 TreeNode cur1 = root1;
		 
		 for(int i : tree) {
			 //if(i == -1) continue;
			 int index = tree.indexOf(i);
			 int level = (int) Math.floor((Math.sqrt(index + 1))) - 1;
			 int levelOfChildren = level + 1;
			 
			 int parentOffset = index - (int) (Math.pow(2, level)-1);
			 int childOffset = parentOffset*2 -1;
			 
			 int childIndex = (int) Math.pow(2, levelOfChildren) + childOffset ;
			 
//			 if(cur1==null) {
//				 cur1 = new TreeNode(i);
//			 } 
//			 
//			 if(cur1.left.val == -1) cur1.left = null;
//			 else cur1.left = new TreeNode(tree.get(childIndex));
//			 
//			 if(cur1.right.val == -1) cur1.right = null;
//			 else cur1.right = new TreeNode(tree.get(childIndex + 1));
//
//			 cur = cur.left;
			 //System.out.println(i + "My index: " + index +  " and my children are located at " + childIndex);
			// if(childIndex < tree.size()) {
			 System.out.println(i + "Children: " + tree.get(childIndex) + " & " + tree.get(childIndex + 1));
			// }
			// System.out.println("i= " + i);
		 }
		 
		 constructTree(root1);
	     
		 return root1;
	 }
	 
	 public static void constructTree(TreeNode cur) {
		 
		 
	 }

	 
	 //public static 
	 
	 public static int findLeast(int [] preorder, int[] subArray) {
		 
		 if(subArray.length == 1) return subArray[0];
		 
		 ArrayList<Integer> temp = new ArrayList<>();
		 
		 for(int i = 0; i < subArray.length; i++) {
			 temp.add(subArray[i]);
		 }
		 
		 for(int i =0; i < preorder.length; i++) {
			  if(temp.contains(preorder[i])) {
				  return preorder[i];
			  }
		 }
		 
		 return -1;
	 }

}
