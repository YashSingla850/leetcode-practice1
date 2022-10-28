//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.numberOfEnclaves(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int numberOfEnclaves(int[][] grid) {
        int n= grid.length , m = grid[0].length;
        
        boolean visited[][] = new boolean[n][m];
        for(int i =0 ; i<n ; i++){
            for(int j =0 ; j<m ;j++){
                if(i==0 || j==0 || i==n-1 || j==m-1){
                    if(visited[i][j]==false && grid[i][j]==1){
                        dfs(i , j , visited ,grid);
                    }
                }
            }
        }
        int count =0;
        for(int i =0 ; i<n ; i++){
            for(int j =0 ; j< m;j++){
                if(grid[i][j]==1){
                    count++;
                }
            }
        }
        return count;
    }
    int dir[][] = {{-1 ,0} , {0,-1} ,{1,0}, {0,1}};
    public void dfs(int i  , int j , boolean visited [][] , int[][]grid){
        visited[i][j]=true;
        grid[i][j] =0;
        for(int d= 0 ; d<dir.length ;d++){
            int r= i+dir[d][0];
            int c= j+dir[d][1];
            if(r>=0 && c>=0 && r<grid.length && c<grid[0].length && grid[r][c]==1 && visited[r][c]==false){
                dfs(r,c,visited ,grid);
            }
        }
 
    }
}