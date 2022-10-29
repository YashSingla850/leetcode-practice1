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
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        List<List<Integer>>list = new ArrayList<>();
        for(int i = 0 ;i<n ; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0; i<edges.length;i++){
            list.get(edges[i][0]).add(edges[i][1]);
            list.get(edges[i][1]).add(edges[i][0]);
        }
        int []dist = new int[n];
        for(int i =0 ; i<n ; i++){
           dist[i] =(int)1e9;
        }
        dist[src] =0;
        Queue<Integer>q = new ArrayDeque<>();
        q.add(src);
        while(q.size()>0){
            int temp = q.remove();
            for(int nbr:list.get(temp)){
                if(dist[temp]+1<dist[nbr]){
                    dist[nbr] = dist[temp]+1;
                    q.add(nbr);
                }
            }
        }
        for(int i =0 ;i<n ;i++){
            if(dist[i]==1e9){
                dist[i] =-1;
            }
        }
        return dist;
    }
}