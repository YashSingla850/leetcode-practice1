//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
@SuppressWarnings("unchecked") class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int edges[][] = new int[m][3];
            for (int i = 0; i < m; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                edges[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            List<Integer> ans = obj.shortestPath(n, m, edges);
            for (int e : ans) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class pair{
    int node;
    int weight;
    pair(int node ,int weight){
        this.node =node;
        this.weight = weight;
    }
}
class Solution {
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        // code here
        List<List<pair>>adj = new ArrayList<>();
        int []parent = new int[n+1];
        int []dis = new int[n+1];
        for(int i =0 ; i<=n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int i= 0; i<m ; i++){
            adj.get(edges[i][0]).add(new pair(edges[i][1] , edges[i][2]));
            adj.get(edges[i][1]).add(new pair(edges[i][0] , edges[i][2]));
        }
         
         
         for(int i =1 ; i<=n ; i++){
             dis[i] = (int)1e9;
             parent[i] =i;
         }
        
        PriorityQueue<pair>pq = new PriorityQueue<>((x,y)->x.weight-y.weight);
        dis[1] = 0;
        pq.add(new pair(1 ,0));
        while(pq.size()>0){
            pair temp = pq.remove();
            int node = temp.node;
            int nodeWeight = temp.weight;
            
            for(pair nbr: adj.get(node)){
                int nbrNode = nbr.node;
                int nbrWeight = nbr.weight;
                if(nodeWeight+nbrWeight<dis[nbrNode]){
                    dis[nbrNode] = nodeWeight+nbrWeight;
                    pq.add(new pair(nbrNode , dis[nbrNode]));
                    parent[nbrNode] = node;
                }
                
            }
            
        }
        
        List<Integer>path = new ArrayList<>();
        if(dis[n]==1e9){
            path.add(-1);
            return path;
        }
        int node =n ;
        while(parent[node]!=node){
            path.add(node);
            node = parent[node];
        }
        path.add(1);
        Collections.reverse(path);
        return path;
        
    }
}