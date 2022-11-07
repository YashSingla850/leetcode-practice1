//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {

            int n = sc.nextInt();
            List<List<String>> adj = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                List<String> l = new ArrayList<>();

                String name = sc.next();
                l.add(name);

                int tmp = sc.nextInt();

                sc.nextLine();
                for (int j = 0; j < tmp; j++) {
                    String h = sc.next();

                    l.add(h);
                }

                adj.add(l);
            }

            Solution obj = new Solution();
            List<List<String>> ans = obj.mergeDetails(adj);
            Collections.sort(ans,
                             (x, y)->{ return x.get(0).compareTo(y.get(0)); });

            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
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
            if(node==parent.get(node)){
                return node;
            }
            int ulp = findPar(parent.get(node));
            parent.set(node,ulp);
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
                parent.set(parV, parU);
                int rankU = rank.get(parU);
                rank.set(parU , rankU+1);
        }
    }
}
class Solution {

    public List<List<String>> mergeDetails(List<List<String>> accounts) {
        // Your code here
        int n = accounts.size();
       disJointSet ds = new disJointSet(n);
       HashMap<String , Integer>map = new HashMap<>();
    //   HashMap<String , Integer>map2 = new HashMap<>();
       for(int i =0 ; i<n ; i++){
           for(int j =1 ; j<accounts.get(i).size();j++){
               String mail = accounts.get(i).get(j);
               if(map.containsKey(mail)==false){
                   map.put(mail , i);
                   
               }else{
                  
                   ds.unionRank(map.get(mail) , i);
                   
               }
            //   map2.put(mail , map2.getOrDefault(mail,0)+1);
           }
       }
       ArrayList<String>[] mergedArr = new ArrayList [n];
       for(int i =0 ;i<n ; i++){
           mergedArr[i] = new ArrayList<>();
       }
       for(String key: map.keySet()){
        //   if(map2.get(key)==1){
           int val =ds.findPar(map.get(key));
           mergedArr[val].add(key);
       
      }
       List<List<String>>ans = new ArrayList<>();
       for(int i =0 ; i< n; i++){
           if(mergedArr[i].size()==0)continue;
           Collections.sort(mergedArr[i]);
           List<String>temp = new ArrayList<>();
           temp.add(accounts.get(i).get(0));
           for(int j =0 ; j<mergedArr[i].size();j++){
               temp.add(mergedArr[i].get(j));
           }
           ans.add(temp);
       }
       return ans;
  }
}
     
    