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
            int edge=sc.nextInt();
            int[][] adj = new int[edge][3];
            for(int i=0;i<edge;i++){
                adj[i][0]=sc.nextInt();
                adj[i][1]=sc.nextInt();
                adj[i][2]=sc.nextInt();
            }
            int src=sc.nextInt();
            int dst=sc.nextInt();
            int k=sc.nextInt();
            Solution obj = new Solution();
            int res = obj.CheapestFLight(n,adj,src,dst,k);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends

class pair{
    int nbr , weight;
    pair(int nbr , int weight){
        this.nbr = nbr;
        this.weight = weight;
    }
}
class tuple{
    int stop , src , dis;
    tuple(int stop , int src ,int dis){
        this.stop = stop;
        this.src= src;
        this.dis = dis;
    }
}
class Solution {
    
    public int CheapestFLight(int n,int flights[][],int src,int dst,int k) {
        List<List<pair>>adj = new ArrayList<>();
        for(int i = 0 ; i<n ;i++){
            adj.add(new ArrayList<>());
        }
        int m = flights.length;
        for(int i = 0 ; i<m ; i++){
            adj.get(flights[i][0]).add(new pair(flights[i][1] , flights[i][2]));
        }
        // creating dist aarray;
        int []arr = new int[n];
        for(int i =0 ; i<n ;i++){
            arr[i] = (int)1e9;
        }
        arr[src] = 0;
        Queue<tuple>q = new ArrayDeque<>();
        q.add(new tuple(0 , src , 0));
        while(q.size()>0){
            tuple temp = q.remove();
            int tempStop = temp.stop;
            int tempSrc = temp.src;
            int tempDis = temp.dis;
            if(tempStop>k)continue;
            for(pair iter : adj.get(tempSrc)){
                int iterNbr = iter.nbr;
                int iterWeight = iter.weight;
                if(tempDis+iterWeight<arr[iterNbr] && tempStop<=k){
                    arr[iterNbr]  = tempDis+iterWeight;
                    q.add(new tuple(tempStop+1 , iterNbr , tempDis+iterWeight));
                }
            }
        }
        if(arr[dst]==1e9)return -1;
        return arr[dst];
    }
}