/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        // Length of the Linked List
        ListNode temp = head;
        int length = lengthOfList(head);
        
        length = length -n;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode temper = dummy;
        
        int count = 0;
        
        while(count!=length){
            count++;
            temper = temper.next;
        }
        
        temper.next = temper.next.next;
        
        return dummy.next;
    }
    
    public static int lengthOfList(ListNode head){
        int count = 0;
        while(head!=null){
            head = head.next;
            count++;
        }
        return count;
    }
}
