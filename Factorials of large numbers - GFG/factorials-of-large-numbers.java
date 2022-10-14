//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int N = sc.nextInt();
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.factorial(N);
            for (Integer val: ans) 
                System.out.print(val); 
            System.out.println();
        }   
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static ArrayList<Integer> factorial(int N){
        //code here
       ArrayList<Integer>list = new ArrayList<>();
       list.add(1);
       for(int i = 1 ; i<=N;i++){
           int  k = 0;
           int carry = 0;
           while(k<list.size()){
               int temp = list.get(k)*i+carry;
               list.set(k ,temp%10);
               carry = temp/10;
               k++;
           }
           while(carry!=0){
               list.add(carry%10);
               carry = carry/10;
           }
       }
       ArrayList<Integer>ans = new ArrayList<>();
       for(int i = list.size()-1 ; i>=0 ; i--){
           ans.add(list.get(i));
       }
       return ans;
    }
}