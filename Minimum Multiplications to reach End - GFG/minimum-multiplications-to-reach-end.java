//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class pair{
    int src , steps;
    pair(int src , int steps){
        this.src = src;
        this.steps = steps;
    }
}

class Solution {
    
    int minimumMultiplications(int[] arr, int start, int end) {
             int mod = 100000;
        Queue<pair>q =new ArrayDeque<>();
        int []dist = new int[100000];
        for(int i =0 ; i< 100000 ;i++){
            dist[i] = (int)1e9;
        }
        q.add(new pair(start , 0));
        dist[start] =0;
        while(q.size()>0){
            pair temp = q.remove();
            int tempSrc = temp.src;
            int tempSteps = temp.steps;
            
            for(int i =0 ; i<arr.length ;i++){
                int val = (tempSrc*arr[i])%mod;
                if(tempSteps+1<dist[val]){
                    dist[val] = tempSteps+1;
                    if(val==end)return tempSteps+1;
                    q.add(new pair(val , tempSteps+1));
                }
            }
        }
        return -1;
    }
}
