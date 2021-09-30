package RemoveDuplicatesFromSortedList;
import java.util.ArrayList;


public class Solution {
	
	/**
	 * 83. Remove Duplicates from Sorted List 
	 * 
	 * Given the head of a sorted linked list, delete all duplicates such that each element 
	 * appears only once. Return the linked list sorted as well.
	 * 
	 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
	 * @param head
	 * @return
	 */
    public ListNode deleteDuplicates(ListNode head) {
        
        if(head == null || head.next == null) return head;
        ListNode cur = head;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(cur.val);
        
        while(cur.next != null) {
            if(list.contains(cur.next.val)) {
                if(cur.next.next != null) {
                   // ListNode del = cur.next; // ptr to node to delete
                    cur.next = cur.next.next;
                   // del.next = null;
                } else {
                    cur.next = null;
                }
            } else {
                list.add(cur.next.val);
                cur = cur.next;
            }            
        }
        
        return head;
    }
    
    class ListNode {
    	int val;
    	ListNode next; 
    	ListNode(int x) {val = x;}
    }

}
