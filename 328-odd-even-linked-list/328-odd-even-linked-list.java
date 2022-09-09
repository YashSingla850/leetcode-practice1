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
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null)return head;
        ListNode fh = head;
        ListNode h1 = fh;
        ListNode sh = head.next;
        ListNode h2 = sh;
        ListNode forw  = null;
        while(h2!=null && h2.next!=null){
            forw = h2.next;
//             aage badne ka jugad
            h1.next = forw ;
            h2.next = forw.next;
            h1 = h1.next;
            h2 = h2.next;
        }
        h1.next = null;
        h1.next = sh;
        return fh;
        
    }
}