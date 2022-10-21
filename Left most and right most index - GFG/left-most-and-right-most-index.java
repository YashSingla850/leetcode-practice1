//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class pair  {  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            long k = Long.parseLong(br.readLine().trim());
            
            Solution obj = new Solution();
            pair ans = obj.indexes(a, k);
            if (ans.first == -1 && ans.second == -1)
                System.out.println(-1);
            else
                System.out.println(ans.first+" "+ans.second);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java

/*
class pair  {  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}
*/

class Solution {
    
    public pair indexes(long v[], long x)
    {
        long val1 = (long)firstocc(v , x);
        long val2 = (long)lastocc(v, x); 
        pair p = new pair(val1 , val2);
        // p.first = val1;
        // p.second = val2;
        return p;
    }
    public long firstocc(long [] v , long x){
    int s =0;
    int e = v.length-1;
    long ans = -1;
    while(s<=e){
        int mid = s+ (e-s)/2;
         if(v[mid]==x){
             ans =(long) mid;
             e = mid-1;
         }else if(v[mid]>x){
             e = mid-1;
         }else if(v[mid]<x){
             s = mid+1;
         }
         
    }
    return ans;
  }
      public long lastocc(long [] v , long x){
    int s =0;
    int e = v.length-1;
    long ans = -1;
    while(s<=e){
        int mid = s+ (e-s)/2;
         if(v[mid]==x){
             ans = (long)mid;
             s = mid+1;
         }else if(v[mid]>x){
             e = mid-1;
         }else if(v[mid]<x){
             s = mid+1;
         }
        
    }
     return ans;
  }
  
  
  
  
  
  
}