//{ Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().distinctCount(arr, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java




class Solution {
    int distinctCount(int[] arr, int n) {
        // code here
        int left = 0 , right = n-1 ; 
        int count =0;
        int prev = Integer.MIN_VALUE;
        int next = Integer.MAX_VALUE;
        while(left<=right){
            int val1 = Math.abs(arr[left]);
            int val2 = Math.abs(arr[right]);
            if(val1<val2){
                if(next!=val2){
                count++;
              }
              next =  val2;
                right--;
            }else if(val1==val2){
                if(val1!=prev && val2!=next){
                count++;
              }
              prev = val1;
              next  = val2;
                left++;
                right--;
            }else{
                if(val1!=prev){
                count++;
                }
                prev = val1;
                left++;
            }
        }
        return count;
    }
}
