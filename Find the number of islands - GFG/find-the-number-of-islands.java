//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // Code here
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        int count =0 ;
        for(int i =0 ; i<grid.length;i++){
            for(int j =0 ; j<grid[0].length;j++){
                if(visited[i][j]==false && grid[i][j]=='1'){
                    helper(grid , visited , i , j);
                    count++;
                }
            }
        }
        return count;
    }
    
    int [][]dir = {{-1,0} , {1,0}, {0,-1},{0,1},{-1,-1},{-1,1},{1,1},{1,-1}};
    
    public void helper(char [][]grid , boolean [][]visited , int i , int j){
         if( i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]!='1' || visited[i][j]==true){
             return;
         }
        
        visited[i][j] = true;
        
        for(int d =0 ; d<dir.length ;d++){
            int  ii= i + dir[d][0];
            int jj = j+dir[d][1];
          helper(grid , visited , ii , jj);
        }
    }
}