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
    public ListNode swapNodes(ListNode head, int k) {
        List<Integer>list = new ArrayList<>();
        ListNode cur = head;
        while(cur!=null){
            list.add(cur.val);
            cur = cur.next;
        }
        int n = list.size();
         int val1 = list.get(k-1);
         int val2 = list.get(n-k);
               list.set(k-1 , val2);
                list.set(n-k , val1);
        ListNode nhead  = new ListNode(-1);
        ListNode new1 = nhead;
        for(int i = 0 ; i<n ; i++){
            ListNode emp = new ListNode(list.get(i));
              new1.next = emp;
            new1 = new1.next;
        }
        return nhead.next;
    }
}