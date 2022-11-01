//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
// Position this line where user code will be pasted.

class GFG {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j < 3; j++) {
                    int x = sc.nextInt();
                    temp.add(x);
                }
                adj.add(temp);
            }

            Solution obj = new Solution();
            System.out.println(obj.countPaths(n, adj));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class pair{
    int src , weight;
    pair(int src , int weight){
        this.src = src;
        this.weight = weight;
    }
}

class Solution {

    static int countPaths(int n, List<List<Integer>> roads) {
        // Your code her
        List<List<pair>>adj = new ArrayList<>();
        for(int i =0 ; i<n ;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0 ; i<roads.size();i++){
            adj.get(roads.get(i).get(0)).add(new pair(roads.get(i).get(1) , roads.get(i).get(2)));
            adj.get(roads.get(i).get(1)).add(new pair(roads.get(i).get(0) , roads.get(i).get(2)));
        }
        int dist[] = new int[n];
        int ways [] = new int[n];
        for(int i =0 ; i<n ; i++){
            dist[i] = (int)1e9;
            ways[i] = 0;
        }
        int mod = (int)(1e9+7);
        PriorityQueue<pair>pq = new PriorityQueue<>((x,y)->x.weight -y.weight);
        pq.add(new pair(0 , 1));
        dist[0] = 0;
        ways[0] = 1;
        while(pq.size()>0){
            pair temp = pq.remove();
            int tempSrc = temp.src;
            int tempWeight = temp.weight;
            for(pair nbr : adj.get(tempSrc)){
                int nbrSrc = nbr.src;
                int nbrWeight = nbr.weight;
               if(tempWeight+nbrWeight<dist[nbrSrc]){
                   dist[nbrSrc] = tempWeight+nbrWeight;
                   pq.add(new pair(nbrSrc , tempWeight+nbrWeight));
                   ways[nbrSrc] = ways[tempSrc];
               }else if(tempWeight+nbrWeight==dist[nbrSrc]){
                   ways[nbrSrc]  = (ways[nbrSrc]+ways[tempSrc])%mod;
               }
            }
        }
       return (ways[n-1])%mod;
    }
}
