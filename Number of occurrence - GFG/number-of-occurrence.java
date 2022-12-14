//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    int count(int[] arr, int n, int x) {
        // code here
        int val1 = firstocc(arr , n , x);
        int val2 = lastocc(arr , n , x);
       if(val1==-1 && val2==-1){
            return 0;
        }else if(val1==-1 || val2 ==-1){
            return 1;
        } 
        return val2-val1+1;
    }
    public int firstocc(int []arr , int n , int x){
        int left = 0 ;
        int right = n-1;
         int ans = -1;
        while(left<=right){
           
            int mid  = left + right-left/2;
            
            if(arr[mid]== x){
                ans = mid;
                right = mid-1;
            }else if(arr[mid]>x){
                right = mid-1;
            }else if(arr[mid]<x){
                left = mid+1;
            }
        }
        return ans;
    }
    
       public int lastocc(int []arr , int n , int x){
        int left = 0 ;
        int right = n-1;
        int ans = -1;
        while(left<=right){
            int mid  = left + right-left/2;
            if(arr[mid]== x){
             ans =  mid;
             left = mid+1;
            }else if(arr[mid]>x){
                right = mid-1;
            }else if(arr[mid]<x){
                left = mid+1;
            }
        }
        return ans;
    }
}