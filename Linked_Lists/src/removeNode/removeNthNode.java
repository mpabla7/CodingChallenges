package removeNode;
/*
 * Problem: 
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * 
 * Level:
 * Medium 
 * 
 * Solve Time/Date:
 * 51 minutes 
 * 4/4/20
 * 
 * Note: Given a linked list, remove the n-th node from the end of list and return its head.
 */
public class removeNthNode {}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        int listLen = 0;
        for(ListNode temp = head; temp != null; temp = temp.next) {
            listLen++;
        }
        
        if(listLen == 1) return null;
        else if (listLen == 2) {
            if(n==1){
                head.next = null;
                return head;
            }
        }
        if (listLen == n) return head.next;
      
        int rmIndex = (listLen + 1) - n;
        int curIndex = 1;
        
        for(ListNode c = head; curIndex != rmIndex; c = c.next, curIndex++) {
            if(curIndex+1 == rmIndex) {
                ListNode del = c.next;
                c.next = del.next;
                del.next = null;
                break;
            }
        }   
        return head;
        
    }
}

class ListNode {
	int val;
	ListNode next; 
	ListNode(int x) {val = x;}
}