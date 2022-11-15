//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] edges = new int[m][3];
            for(int i = 0; i < m; i++){
                String S2[] = br.readLine().trim().split(" ");
                for(int j = 0; j < 3; j++)
                    edges[i][j] = Integer.parseInt(S2[j]);
            }
            Solution obj = new Solution();
            int ans = obj.isNegativeWeightCycle(n, edges);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    public int isNegativeWeightCycle(int n, int[][] edges)
    {
      int []dist = new int[n];
      for(int i =0 ; i<n  ;i++){
          dist[i] = (int)1e9;
      }
       dist[0] = 0;
       for(int i =0 ; i<n ; i++){
           for(int[]arr: edges){
               int u = arr[0];
               int v = arr[1];
               int wt = arr[2];
               if(dist[u]!=1e9 && dist[u]+wt<dist[v]){
                   dist[v] = dist[u]+wt;
               }
           }
       }
       for(int []arr : edges){
           int u = arr[0];
           int v = arr[1];
           int wt = arr[2];
           if(dist[u]!=1e9 && dist[u]+wt<dist[v]){
               return 1;
           }
       }
       return 0;
    }
}