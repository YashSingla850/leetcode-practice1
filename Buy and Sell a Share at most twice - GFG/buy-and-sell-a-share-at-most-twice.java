//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n; 
            n = Integer.parseInt(br.readLine());
            
            
            int[] price = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.maxProfit(n, price);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int maxProfit(int n, int[] price) {
        // code here
        int dp[][][] = new int[n+1][2][3];
        // for(int d[][]:dp){
        //     for(int dd[]:d){
        //         Arrays.fill(dd,-1);
        //     }
        // }
      return  helper(price , dp , 0 , 1 ,2);
    }
    // public static  int helper(int []price , int [][][]dp , int idx ,int buy , int tr){
    //     int profit = Integer.MIN_VALUE;
    //     if(idx == price.length){
    //         return 0;
    //     }
    //     if(tr==0){
    //         return 0;
    //     }
    //     if(dp[idx][buy][tr]!=-1)return dp[idx][buy][tr];
    //     if(buy==1){
    //         profit = Math.max(-price[idx]+helper(price , dp , idx+1 , 0 , tr) , helper(price , dp , idx+1 , 1 ,tr));
    //     }else {
    //         profit = Math.max(price[idx]+helper(price , dp , idx+1 , 1 , tr-1) , helper(price , dp , idx+1 , 0 , tr));
    //     }
    //     return dp[idx][buy][tr] = profit;
    // }
    
    
    public static int helper(int []price , int [][][]dp , int Idx , int Buy , int Tr){
        int n=price.length;
        for(int idx =n-1 ; idx>=0;idx--){
            for(int buy =0  ; buy<=Buy;buy++){
                for(int tr =1 ; tr<=Tr;tr++){
                    if(buy==1){
                        dp[idx][buy][tr] = Math.max(-price[idx]+dp[idx+1][0][tr] , dp[idx+1][1][tr]);
                    }else{
                        dp[idx][buy][tr] = Math.max(price[idx]+dp[idx+1][1][tr-1] , dp[idx+1][0][tr]);
                    }
                }
            }
        }
        return dp[0][1][2];
    }
}
        
