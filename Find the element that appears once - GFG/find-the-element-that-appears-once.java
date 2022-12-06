//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int[] arr = new int[n];
            
            for (int i = 0; i < n; ++i)
                arr[i] = sc.nextInt ();

    		System.out.println (new Sol().search (arr, n));
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Sol
{
    public static int search(int arr[], int n)
    {
        // your code here
        if(n==1)return arr[0];
        if(arr[0]!=arr[1])return arr[0];
        if(arr[n-1]!=arr[n-2])return arr[n-1];
        int lo = 0 , hi = arr.length-1;
        while(lo<=hi){
            int mid = (lo+hi)/2;
            if(arr[mid]!=arr[mid-1]&& arr[mid]!=arr[mid+1]){
                return arr[mid];
            }else if(arr[mid]==arr[mid-1]){
                int lc = mid-lo+1;
                if(lc%2==0){
                    lo = mid+1;
                }else{
                    hi = mid-2;
                }
            }else if(arr[mid]==arr[mid+1]){
                int rc = hi-mid+1;
                if(rc%2==0){
                    hi = mid-1;
                }else{
                    lo = mid+2;
                }
            }
        }
        return -1;
    }
}