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
        if(head == null) {
            return null;
        }
        int listSize = 0;
        ListNode temp = head;
        while(temp != null) {
            listSize++;
            temp = temp.next;
        }
        temp = head;
        if(n == listSize) {
            temp = head.next;
            head.next = null;
            return temp;
        }
        for(int i = 0; i < listSize-n-1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }
}
