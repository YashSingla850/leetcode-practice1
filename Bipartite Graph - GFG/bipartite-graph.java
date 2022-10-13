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
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, adj);
            if(ans)
                System.out.println("1");
            else System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution
{
    class pair{
        int v;
        int color;
        pair(int v , int color){
            this.v  = v;
            this.color  = color;
        }
    }
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        int visited[] = new int[V];
       for(int i =0 ; i<V ;i++){
           if(visited[i]==0){
               boolean ans = helper(adj , visited , i);
               if(ans==false){
                   return false;
               }
           }
       }
       return true;
    }
    
    public boolean helper(ArrayList<ArrayList<Integer>> list , int[]visited , int i){
       Queue<pair>q = new ArrayDeque<>();
       q.add(new pair(i,1));
       while(q.size()>0){
           pair temp = q.remove();
           if(visited[temp.v]!=0){
               int oc = visited[temp.v];
               int nc = temp.color;
               if(oc==nc){
                   continue;
               }
               return false;
           }
           visited[temp.v]=temp.color;
           for(int nbr : list.get(temp.v)){
               if(visited[nbr]==0){
                   q.add(new pair(nbr , temp.color*-1));
               }
           }
       }
       return true;
    }
}