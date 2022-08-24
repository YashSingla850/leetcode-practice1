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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int arr[][] = new int[m][n];
        for(int d[]:arr)Arrays.fill(d,-1);
        int size = size(head);
    int minc = 0;
        int minr = 0;
        int maxr = m-1;
        int maxc = n-1;
        int count =0;
        ListNode dummy  = head;
        while(count<size){
        // up
            for(int i = minc ; i<=maxc && count<size;i++){
                if(dummy==null){
                    break;
                }
                arr[minr][i] = dummy.val;
                dummy = dummy.next;
                count++;
            }
            minr++;
       // right
            for(int i = minr ; i<=maxr && count<size ; i++){
                    if(dummy==null){
                    break;
                }
                arr[i][maxc] = dummy.val;
                dummy = dummy.next;
                count++;
            }
            maxc--;
        //bottom
    for(int i = maxc ; i>=minc&&count<size ;i--){
            if(dummy==null){
                    break;
             }
            arr[maxr][i] = dummy.val;
            dummy = dummy.next;
           count++;
      }
            maxr--;
      //left
            for(int i = maxr ; i>=minr&&count<size;i--){
                 if(dummy==null){
                    break;
             }
                arr[i][minc]=dummy.val;
                  dummy = dummy.next;
                count++;
                
            }
            minc++;
            
        }
        return  arr;
    }
    public int size(ListNode head){
        int count =0;
        ListNode dummy =head;
        while(dummy!=null){
            count++;
            dummy=  dummy.next;
        }
        return count;
    }
}