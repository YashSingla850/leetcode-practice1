class Solution {
   int []par;
    int findpar(int u){
        if(par[u]==u)return u;
        return par[u] = findpar(par[u]);
    }
        
public int makeConnected(int n, int[][] connections) {
    if(n-1>connections.length) return -1;
    par = new int[n];
    for(int i =0 ;i<n ; i++){
        par[i] =i;
    }
    for(int []conn :connections){
        int u = conn[0];
        int v = conn[1];
        int p1 = findpar(u);
        int p2 = findpar(v);
        if(p1!=p2){
            par[p2] = p1;
        }
    }
        int count =0;
    for(int i =0 ;i<n ;i++){
   int p = findpar(i);
        if(p==i)count++;
        }
    return count-1;
    }
}