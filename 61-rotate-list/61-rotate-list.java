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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0){
            return head;
        }
        ListNode cur = head , prev = head;
        int count = 0;
        while(cur!=null){
            count++;
            prev = cur;
            cur = cur.next;
            
        }
        prev.next = head;
        int point  = k%count;
        int diff = count-point;
        
          while(diff!=0){
            diff--;
           prev = prev.next;
        }
       
        head = prev.next;
        prev.next = null;
        
        return head;
    }
}


// class Solution {
//     public ListNode rotateRight(ListNode head, int k) {
//         if(head==null || head.next ==null)return head;
//         int n = 0 ;
//         ListNode temp1 = head;
//         while(temp1!=null){
//             temp1 = temp1.next;
//             n++;
//         }
//         ListNode nhead = reverse(head);
//          ListNode temp = nhead;
//         ListNode ans = temp;
//         ListNode forw  =null;
//         k = k%n;
//         int count = 1;
//         while(count!=k){
//              temp = temp.next;
//             forw  = temp.next;
           
//             count++;
//         }
//         temp.next = null;
//         ListNode nhead1 = reverse(ans);
//         ListNode nhead2 = reverse(forw);
//         ListNode cur = nhead1;
//          while(cur.next!=null){
//              cur = cur.next;
//          }
//         cur.next =nhead2;
//         return nhead1;
         
//     }
//     public ListNode reverse(ListNode head){
//         if(head==null || head.next==null){
//             return head;
//         }
//         ListNode prev = null, cur = head , fast  = null;
//         while(cur!=null){
//              fast  = cur.next;
//             cur.next  = prev;
//             prev = cur;
//             cur = fast;
//         }
//         return prev;
//     }
// }