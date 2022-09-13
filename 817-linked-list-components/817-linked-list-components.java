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
    public int numComponents(ListNode head, int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int count =0;
        ListNode cur = head;
        ListNode prev = new ListNode(-1);
        while(cur!=null){
            if(set.contains(cur.val)){
                prev.next = cur;
                prev = prev.next;
                cur = cur.next;
            }else{
              if(set.contains(prev.val)){
                  count++;
              }
                prev.next = cur;
                prev = prev.next;
                cur = cur.next;
            }
            
        
        }
        if(set.contains(prev.val)){
            count++;
        }
        return count;
    }
}