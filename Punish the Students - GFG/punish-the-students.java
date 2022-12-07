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
            double avg = sc.nextDouble ();
            int[] roll = new int[n];
            int[] marks = new int[n];
            
            for (int i = 0; i < n; ++i)
                roll[i] = sc.nextInt ();
                
            for (int i = 0; i < n; ++i)
                marks[i] = sc.nextInt ();

    		System.out.println (new Solution().shouldPunish (roll, marks, n, avg));
        }
        
    }
}

// Contributed By: Pranay Bansal
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static int shouldPunish (int roll[], int marks[], int n, double avg)
    {
        // your code here
        int count = 0;
        for(int i =1 ; i<n ; i++){
            for(int j = 0 ; j<n-i ;j++){
                if(roll[j]>roll[i]){
                    count+=2;
                    swap(roll[j] , roll[i]);
                }
            }
        }
        int sum =0;
         for(int val:marks){
             sum+=val;
         }
         sum =  sum-count;
          double nAvg = sum/n;
          if(nAvg>=avg)return 1;
          return 0;
    }
    
    public static void swap(int a , int b){
        int temp = a;
        a = b;
        b  = temp;
    }
}