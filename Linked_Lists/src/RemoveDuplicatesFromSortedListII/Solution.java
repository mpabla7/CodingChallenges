package RemoveDuplicatesFromSortedListII;

import java.util.HashMap;

public class Solution {
	
	/**
	 * Remove Duplicates from Sorted List II
	 * 
	 * Given the head of a sorted linked list, delete all nodes that have duplicate numbers, 
	 * leaving only distinct numbers from the original list. Return the linked list sorted as well.
	 * 
	 * 
	 * Input: head = [1,2,3,3,4,4,5]
	 * Output: [1,2,5]
	 * @param head
	 * @return
	 */
    public ListNode deleteDuplicates(ListNode head) {
        
        if(head == null || head.next == null) return head;
        
        // key = node.val, value = occurence of node.val
        HashMap<Integer, Integer> map = new HashMap<>();
        ListNode ptr = head;
        
        while(ptr != null) {
            
            if(map.get(ptr.val)==null) {
                map.put(ptr.val , 1);
            } else {
               int occurence = map.get(ptr.val);
               occurence+=1;
               map.put(ptr.val,occurence );
            }
            
            ptr = ptr.next;
        }
        
        ptr = head;
        boolean rm = false;
        if(map.get(ptr.val) > 1) {
            rm = true;
        }
        
       
        while(ptr.next != null) {
            
           int occurence  = map.get(ptr.next.val);
           if( occurence  > 1) {
               
               // delete node here
               if(ptr.next.next != null) {
                   ptr.next = ptr.next.next;
               } else {
                   ptr.next = null;
               }
               
               // update occurence
               occurence--;
               map.put(ptr.val, occurence);
           } else {
               ptr = ptr.next;
           }
        }
        
        if(rm) return head.next;
        
        return head;
    }
    
    class ListNode {
    	int val;
    	ListNode next; 
    	ListNode(int x) {val = x;}
    }
}
