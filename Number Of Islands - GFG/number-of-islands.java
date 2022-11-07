//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java
class disJointSet{
    List<Integer>rank = new ArrayList<>();
    List<Integer>parent = new ArrayList<>();
      disJointSet(int n){
          for(int i =0 ;i<n ;i++){
              rank.add(0);
              parent.add(i);
          }
      }
     public int findPar(int node){
         if(node==parent.get(node)){
             return node;
         }
         int ulp = findPar(parent.get(node));
         parent.set(node , ulp);
         return parent.get(node);
     }
     void unionRank(int u , int v){
         int parU = parent.get(u);
         int parV = parent.get(v);
         if(parU==parV)return ;
         if(rank.get(parU)<rank.get(parV)){
             parent.set(parU , parV);
         }else if(rank.get(parV)<rank.get(parU)){
             parent.set(parV , parU);
         }else{
             parent.set(parV , parU);
             int rankU = rank.get(parU);
             rank.set(parU , rankU+1);
         }
     }
}
   
class Solution {
    
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        //Your code here
        int n = rows , m = cols;
        disJointSet ds = new disJointSet(n*m);
        boolean vis [][] = new boolean[n][m];
        List<Integer>ans = new ArrayList<>();
        int count =0;
        int[][]dir = {{-1,0} , {0,-1} , {1,0},{0,1}};
        int len= operators.length;
        for(int i =0 ; i<len ;i++){
            int row = operators[i][0];
            int col = operators[i][1];
             
             if(vis[row][col]==true){
                 ans.add(count);
                 continue;
             }
             vis[row][col] = true;
             count++;
             for(int d =0 ; d<dir.length ;d++){
                 int r = row+dir[d][0];
                 int c = col+dir[d][1];
                 if(isValid(r , c ,n , m)==true){
                     if(vis[r][c]==true){
                         int node = row*m+col;
                         int nbrNode = r*m +c;
                         if(ds.findPar(node)!=ds.findPar(nbrNode)){
                             count--;
                             ds.unionRank(node , nbrNode);
                         }
                     }
                 }
             }
             ans.add(count);
        }
        return ans;
        
    }
    public boolean isValid(int row , int col , int n , int m){
      if(row >=0 && col>=0 && row<n && col<m){
          return true;
      }
      return false;
 }
    
}

//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int  k= sc.nextInt();
            int[][] a = new int[k][2];
            for(int i=0;i<k;i++){
            
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            
            Solution obj = new Solution();
            List<Integer> ans = obj.numOfIslands(n,m,a);
           
            for(int i:ans){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends