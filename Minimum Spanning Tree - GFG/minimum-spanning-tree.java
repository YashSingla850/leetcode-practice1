//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            Solution ob = new Solution();
            
            System.out.println(ob.spanningTree(V, adj));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class disJointSet{
    List<Integer>parent = new ArrayList<>();
    List<Integer>rank = new ArrayList<>();
    public disJointSet(int n){
    for(int i =0 ; i<n ; i++){
        parent.add(i);
        rank.add(0);
    }
  }
    public int findPar(int node){
        if(node==parent.get(node)){
            return node;
        }
        int ulp  = findPar(parent.get(node));
        parent.set(node , ulp);
        return parent.get(node);
    }
    public void unionRank(int u , int v){
        int parU = findPar(u);
        int parV = findPar(v);
        if(parU==parV)return;
        
        if(rank.get(parU)<rank.get(parV)){
            parent.set(parU , parV);
            
        }else if(rank.get(parU)>rank.get(parV)){
            parent.set(parV , parU);
          
        }else{
            parent.set(parV , parU);
             int rankU = rank.get(parU);
             rank.set(parU , rankU+1);
        }
    }
}

class Edge implements Comparable<Edge>{
    int src ,dest , weight;
    Edge(int src, int dest , int weight){
        this.src = src ;
        this.dest = dest;
        this.weight = weight;
    }
    public int compareTo(Edge compareEdge){
        return this.weight - compareEdge.weight;
    }
}
class Solution
{
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        // Add your code here
        List<Edge>edges = new ArrayList<>();
        for(int i =0 ; i<V; i++){
            for(int j =0 ; j<adj.get(i).size();j++){
                int v = adj.get(i).get(j).get(0);
                int wt = adj.get(i).get(j).get(1);
                int node = i;
                Edge temp = new Edge(node, v , wt);
                edges.add(temp);
                
            }
        }
        disJointSet ds = new disJointSet(V);
        Collections.sort(edges);
        int sum =0;
        for(int i =0 ; i<edges.size();i++){
            int u = edges.get(i).src;
            int v = edges.get(i).dest;
            int wt = edges.get(i).weight;
            
            if(ds.findPar(u)!=ds.findPar(v)){
                sum+=wt;
                ds.unionRank(u , v);
            }
            
        }
        return sum;
    }
}

// 
// class pair{
//     int node ,distance ;
//     pair(int node , int distance){
//         this.node =node;
//         this.distance = distance;
//     }
// }

// class Solution
// {
//     //Function to find sum of weights of edges of the Minimum Spanning Tree.
//     static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
//     {
//         // Add your code here
//         int visited[] = new int[V];
//         PriorityQueue<pair>pq = new PriorityQueue<pair>((x,y)->x.distance - y.distance);
//         pq.add(new pair(0 , 0));
//         int sum =0;
//         while(pq.size()>0){
//           pair temp = pq.remove();
//           int tempNode = temp.node;
//           int tempDistance = temp.distance;
//           if(visited[tempNode]==1)continue;
//           visited[tempNode]=1;
//           sum+=tempDistance;
//             for(int i =0 ;  i< adj.get(tempNode).size();i++){
//                 int edw = adj.get(tempNode).get(i).get(1);
//                 int nbr = adj.get(tempNode).get(i).get(0);
//                 if(visited[nbr]==0){
//                     pq.add(new pair(nbr , edw));
//                 }
//             }
//         }
//         return sum;
//     }
// }
