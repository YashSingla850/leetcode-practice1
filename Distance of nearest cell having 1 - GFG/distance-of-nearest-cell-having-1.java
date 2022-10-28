//{ Driver Code Starts
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
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


class pair{
    int row ;
    int col ;
    int step;
    pair(int row , int col , int step){
        this.row = row;
        this.col =  col;
        this.step  = step;
    }
}

class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid){
        int n = grid.length ,m = grid[0].length;
      boolean visited[][]  = new boolean[n][m];
      int ans [][] = new int[n][m];
      Queue<pair>q = new ArrayDeque<>();
      for(int i =0 ; i<n ; i++){
          for(int j=0 ; j<m ; j++){
              if(visited[i][j]==false && grid[i][j]==1){
                  q.add(new pair(i , j ,0));
              }
          }
      }
      
    //   direction array
    int [][]dir = {{-1 ,0} , {0, -1} , {1,0} , {0,1}};
      
      
      while(q.size()>0){
          pair temp = q.remove();
          int row = temp.row;
          int col = temp.col;
          int step = temp.step;
          if(visited[row][col]==true){
              continue;
          }
          visited[row][col] = true;
          ans[row][col] = step;
          for(int d= 0 ; d<dir.length ; d++){
              int i = row+dir[d][0];
              int j = col+dir[d][1];
              if(i>=0&& j>=0 && i<n && j<m&& visited[i][j]==false){
                  q.add(new pair(i , j , step+1));
              }
          }
      }
      
      
      
      
      
      return ans;
    }
}