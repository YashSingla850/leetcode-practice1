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
            int[][] arr = new int[n][2];
            for(int i=0;i<n;i++){
                arr[i][0]=sc.nextInt();
                arr[i][1]=sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.maxRemove(arr,n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class disJointSet{
    List<Integer>rank = new ArrayList<>();
    List<Integer>parent = new ArrayList<>();
    List<Integer>size = new ArrayList<>();
    disJointSet(int n){
        for(int i =0 ; i<=n ; i++){
            rank.add(0);
            parent.add(i);
            size.add(1);
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

        if(rank.get(parU)>rank.get(parV)){
            parent.set(parV , parU);
        }else if(rank.get(parV)>rank.get(parU)){
            parent.set(parU , parV);
        }else{
            parent.set(parV , parU);
            int rankU = rank.get(parU);
            rank.set(parU , rankU+1);
        }
    }
    // public void unionBySize(int u , int v){
    //     int parU = p
    // }
}
class Solution {

    int maxRemove(int[][] stones,int n) {
        //Code here
         int maxRow = 0;
        int maxCol = 0;
        for(int i =0 ; i<stones.length ; i++){
            maxRow = Math.max(maxRow , stones[i][0]);
            maxCol = Math.max(maxCol , stones[i][1]);
        }
        disJointSet ds = new disJointSet(maxRow+maxCol+1);
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int i =0 ; i<stones.length ; i++){
            int nodeRow = stones[i][0];
            int nodeCol = stones[i][1]+maxRow+1;
            ds.unionRank(nodeRow , nodeCol);
            map.put(nodeRow,1);
            map.put(nodeCol , 1);
        }
        int count =0;
        for(int key : map.keySet()){
            if(ds.findPar(key)== key){
                count++;
            }
        }
        return stones.length - count;
    }
}
