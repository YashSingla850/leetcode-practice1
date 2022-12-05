//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]arr,int N,int M)
    {
        int sum  =0 , max = -(int)1e9;
        if(M>arr.length)return -1;
        for(int val:arr){
            sum+=val;
            max = Math.max(max , val);
        }
        int lo = max , hi = sum , page = -(int)1e9;
        while(lo<=hi){
            int mid = lo +(hi-lo)/2;
            if(helper(mid , M , arr)==true){
                page = mid;
                hi  = mid-1;
            }else{
                lo = mid+1;
            }
        }
        return page;
    }
    public static boolean helper(int mid , int m , int[]arr){
        int st= 1;
        int sum =0;
        for(int val:arr){
            sum+=val;
            if(sum>mid){
                st++;
                sum = val;
            }
        }
        return st<=m;
    }
};