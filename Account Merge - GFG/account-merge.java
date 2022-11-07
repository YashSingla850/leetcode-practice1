//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      List<List<String>> accounts=new ArrayList<>();
      for (int i = 0; i < n; i++)
       {
        ArrayList<String> temp=new ArrayList<>();
        int x=sc.nextInt();
        for(int j = 0; j < x; j++)
           {
             String s1=sc.next();
             temp.add(s1);
           }
        accounts.add(temp);
       }
      Solution obj = new Solution();
      List<List<String>> res = obj.accountsMerge(accounts);
      Collections.sort(res, new Comparator<List<String>>() {
                @Override   public int compare(List<String> a,
                                              List<String> b) {
                    int al = a.size();
                    int bl = b.size();
                    int min = Math.min(al, bl);
                    for (int i = 0; i < min; i++) {
                        String xx=a.get(i);
                        String yy=b.get(i);
                        if (xx.compareTo(yy)<0)
                            return -1;
                        else if (xx.compareTo(yy)>0)
                            return 1;
                    }
                    if (al < bl)
                        return -1;
                    else if (al > bl)
                        return 1;
                    return -1;
                }
            });
      System.out.print("[");
      for (int i = 0; i < res.size(); ++i)
        {
          System.out.print("[");
          for (int j = 0; j < res.get(i).size(); j++)
             {
                if (j != res.get(i).size() - 1)
                     System.out.print(res.get(i).get(j)+", ");
                else
                     System.out.print(res.get(i).get(j));
             }
          if (i != res.size() - 1)
             System.out.println("], ");
          else
             System.out.print("]");
        }
       System.out.println("]");
    }
  }
}

// } Driver Code Ends


//User function Template for Java
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
  static List<List<String>> accountsMerge(List<List<String>> accounts) {
    // code here
       int n = accounts.size();
       disJointSet ds = new disJointSet(n);
       HashMap<String , Integer>map = new HashMap<>();
       for(int i =0 ; i<n ; i++){
           for(int j =1 ; j<accounts.get(i).size();j++){
               String mail = accounts.get(i).get(j);
               if(map.containsKey(mail)==false){
                   map.put(mail , i);
               }else{
                   ds.unionRank(map.get(mail) , i);
               }
           }
       }
       ArrayList<String>[] mergedArr = new ArrayList [n];
       for(int i =0 ;i<n ; i++){
           mergedArr[i] = new ArrayList<>();
       }
       for(String key: map.keySet()){
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
     