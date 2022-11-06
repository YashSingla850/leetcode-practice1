//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            
            Solution obj = new Solution();
            int ans = obj.Solve(n,edge);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

class disJointSet{
    List<Integer>rank = new ArrayList<>();
    List<Integer>parent = new ArrayList<>();
    disJointSet(int n){
        for(int i =0 ; i<n ; i++){
            rank.add(0);
            parent.add(i);
        }
        
    }
    public int findPar(int node){
        if(node == parent.get(node)){
            return node;
        }
        int ulp = findPar(parent.get(node));
        parent.set(node , ulp);
        return parent.get(node);
    }
    public void unionRank(int u , int v){
        int parU = findPar(u);
        int parV = findPar(v);
        if(parU == parV)return;
         if(rank.get(parU)<rank.get(parV)){
             parent.set(parU , parV);
         }else if(rank.get(parU)> rank.get(parV)){
             parent.set(parV, parU);
         }else{
             parent.set(parV , parU);
             int rankU = rank.get(parU);
             rank.set(parU , rankU+1);
         }
    }
}
class Solution {
    
    public int Solve(int n, int[][] edge) {
       disJointSet ds = new disJointSet(n);
       int component =0 ;
       int extraEdge =0;
       for(int i=0 ;i < edge.length ; i++){
           int u = edge[i][0];
           int v = edge[i][1];
           if(ds.findPar(u)==ds.findPar(v)){
               extraEdge++;
           }else{
               ds.unionRank(u,v);
           }
       }
       for(int i =0 ; i<n ; i++){
           if(ds.findPar(i)==i){
               component++;
           }
       }
       if(component-1<=extraEdge){
           return component-1;
       }
       return -1;
    }
}