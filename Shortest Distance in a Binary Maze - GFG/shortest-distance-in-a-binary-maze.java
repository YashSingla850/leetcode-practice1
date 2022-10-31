//{ Driver Code Starts
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
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class pair{
    int row ,col , dist;
    pair(int row ,int col , int dist){
        this.row =row ;
        this.col = col;
        this.dist = dist;
    }
}

class Solution {

    int shortestPath(int[][] grid, int[] source, int[] destination) {

        // Your code here
        if(source[0]==destination[0] && source[1]==destination[1])return 0;
        int n = grid.length;
        int m = grid[0].length;
        int [][]arr = new int[n][m];
        for(int i =0 ; i<n ; i++){
            for(int j =0 ; j<m ; j++){
                arr[i][j] = (int)1e9;
            }
        }
        
        Queue<pair>q = new ArrayDeque<>();
        
        arr[source[0]][source[1]] = 0;
        q.add(new pair(source[0] , source[1] , 0));
        int dir[][] = {{-1, 0} , {0 , -1} , {1 ,0} , {0,1}};
        while(q.size()>0){
            pair temp  = q.remove();
            int tempRow=  temp.row;
            int tempCol = temp.col;
            int tempDist = temp.dist;
            
            for(int d =0 ; d<dir.length; d++){
                int r = tempRow + dir[d][0];
                int c = tempCol + dir[d][1];
                if(r>=0 && c>=0 && r<n && c<m && grid[r][c]==1 && arr[r][c]>tempDist+1){
                    arr[r][c] = tempDist+1;
                    if(r==destination[0] && c == destination[1])return tempDist+1;
                    q.add(new pair(r , c, tempDist+1));
                }
            }
        }
        return -1;
  
    }
}
