//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static char[][] fill(int n, int m, char a[][])
    {
        // code here
        boolean visited[][] = new boolean[n][m];
         for(int i =0 ; i<n;i++){
             for(int j =0  ; j<m ; j++){
                 if(i==0 || j==0 || i==n-1 || j ==m-1){
                     if(a[i][j]=='O' && visited[i][j]==false){
                         dfs(i, j , visited , a);
                     }
                 }
             }
         }
         char[][]ans = new char[n][m];
         for(int i =0  ; i<n ; i++){
             for(int j =0  ; j<m;j++){
                 if(visited[i][j]==false){
                     ans[i][j]='X';
                 }else{
                     ans[i][j] = 'O';
                 }
             }
         }
       return ans;
    }
    static int [][]dir = {{-1,0} , {0,-1} ,{1,0} , {0,1}};
    public static void dfs(int i , int j ,boolean visited[][] ,char[][]a){
        visited[i][j]=true;
        for(int d = 0 ; d<dir.length ;d++){
            int r = i+dir[d][0];
            int c = j+dir[d][1];
            if(r>=0 && c>=0 && r<visited.length && c<visited[0].length && a[r][c]=='O' && visited[r][c]==false){
                dfs(r , c , visited ,a);
            }
        }
    }
}