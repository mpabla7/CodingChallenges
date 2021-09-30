package ReverseList;
import java.util.Stack;
/*
 * Problem: 
 * https://leetcode.com/problems/reverse-linked-list/submissions/
 * 
 * Level:
 * Easy
 * 
 * Solve Time/Date:
 * 4 minutes 
 * 4/4/20
 * 
 * Note: Solved in place. Note that if you want to reverse a double linked list. It is done the same way 
 * https://www.hackerrank.com/challenges/reverse-a-doubly-linked-list/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=linked-lists
 */
public class ReverseLinkedList {}

class Solution {
    public ListNode reverseList(ListNode head) {
        
        Stack<Integer> stack = new Stack<Integer>(); 
        
        for(ListNode ptr = head; ptr != null; ptr=ptr.next){
            stack.push(ptr.val);
            System.out.println(ptr.val);
        }
        
        ListNode cur = head;
        while(cur!=null) {
            cur.val = stack.pop();
            cur=cur.next;
        }
        
        return head;
    }
}

class ListNode {
	int val;
	ListNode next; 
	ListNode(int x) {val = x;}
}