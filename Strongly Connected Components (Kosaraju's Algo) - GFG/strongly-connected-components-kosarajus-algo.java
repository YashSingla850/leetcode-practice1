//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find number of strongly connected components in the graph.
    public void dfs(ArrayList<ArrayList<Integer>>list ,int[]vis ,Stack<Integer>st , int node){
        vis[node] =1;
        for(int nbr: list.get(node)){
            if(vis[nbr]==0){
                dfs(list , vis  ,st , nbr);
            }
        }
        st.push(node);
    }
    public void revDfs(ArrayList<ArrayList<Integer>>list , int[]vis , int node){
        vis[node] =1;
        for(int nbr:list.get(node)){
            if(vis[nbr]==0){
                revDfs(list, vis , nbr);
            }
        }
    }
    public int kosaraju(int v, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        Stack<Integer>st = new Stack<>();
        int []vis = new int[v];
        for(int i =0 ; i<v ;i++){
            if(vis[i]==0){
                dfs(adj, vis , st , i);
            }
        }
        
        ArrayList<ArrayList<Integer>>revGraph = new ArrayList<>();
        for(int i=0 ; i<v ; i++){
            revGraph.add(new ArrayList<>());
        }
        for(int i =0 ; i<v ; i++){
            vis[i] =0;
            for(int nbr: adj.get(i)){
                revGraph.get(nbr).add(i);
            }
        }
        int count =0;
        while(st.size()>0){
            int node = st.pop();
            if(vis[node]==0){
                revDfs(revGraph , vis , node);
                 count++;
            }
           
        }
        return count;
    }
}
