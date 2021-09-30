package OddEvenLL;
/*
 * Problem: 
 * https://leetcode.com/problems/odd-even-linked-list/submissions/
 * 
 * Level:
 * Medium 
 * 
 * Solve Time/Date:
 * (did not record myself) 
 * 4/30/20
 * 
 * Note: Given a linked list,  group all odd nodes together followed by the even nodes. You should try to do it in place. 
 * 
 * Input: 1->2->3->4->5->NULL
   Output: 1->3->5->2->4->NULL
 */
import java.util.LinkedList;
import java.util.Queue;

public class oddEvenLinkedList {
	public static void main(String[] args) {
		System.out.println("");
	}
}

class Solution {
	public ListNode oddEvenList(ListNode head) {

    	Queue<ListNode> q = new LinkedList<>();   	
    	ListNode ptr = head; 
    	ListNode list = head;
    	
        if(head == null || head.next == null) return head;
        
    	while(ptr.next.next != null) {

    		q.add(ptr.next);
            //System.out.println("----- " + ptr.next.val + " curIndex " + curIndex);
    		ListNode temp = ptr.next;
    		ptr.next = null;
    		ptr.next = temp.next;
    		temp.next = null;
    		ptr=ptr.next;
    	    
            if(ptr.next == null) break;
    	}

    	if(ptr.next != null) {
    		q.add(ptr.next);
    		ptr.next=null;
    	}
       
    	while(!q.isEmpty()) {
    		ptr.next = q.remove();
    		ptr=ptr.next;
            
    	}
    
    	
    	return list;
	}
    
    class ListNode {
    	int val;
    	ListNode next; 
    	ListNode(int x) {val = x;}
    }
}

