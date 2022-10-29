//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
		while(t>0)
		{
		    int N = sc.nextInt();
		    int P = sc.nextInt();
		    int prerequisites[][] = new int[P][2];
		    for(int i=0;i<P;i++)
		    {
		        for(int j=0;j<2;j++)
		        {
		            prerequisites[i][j] = sc.nextInt();
		        }
		    }
			Solution ob = new Solution();
			if(ob.isPossible(N,prerequisites))
			{
			    System.out.println("Yes");
			}
			else{
			    System.out.println("No");
			}
			t--;
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public boolean isPossible(int V, int[][] matrix)
    {
      List<List<Integer>>list = new ArrayList<>();
      for(int i =0 ; i<V;i++){
          list.add(new ArrayList<>());
      }
      int n = matrix.length;
      for(int i =0 ; i<n ;  i++){
          list.get(matrix[i][0]).add(matrix[i][1]);
      }
      
      int[]indegree = new  int[V];
      for(int i=0 ; i<V;i++){
          for(int nbr:list.get(i)){
              indegree[nbr]++;
          }
      }
      Queue<Integer>q = new ArrayDeque<>();
      List<Integer>ans = new ArrayList<>();
      for(int i =0 ; i<V ; i++){
          if(indegree[i]==0)q.add(i);
      }
      while(q.size()>0){
          int temp = q.remove();
          ans.add(temp);
          for(int nbr:list.get(temp)){
              indegree[nbr]--;
              if(indegree[nbr]==0){
                  q.add(nbr);
              }
          }
      }
      if(ans.size()==V)return true;
      return false;
    }
    
}