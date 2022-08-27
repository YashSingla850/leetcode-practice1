class Solution {
    int mod = (int)1e9+7;
    public int countHousePlacements(int n) {
        long build = 1;
        long space = 1;
        for(int i =1 ;i<n ; i++){
            long nbuild = space;
            long nspace = (build+space)%mod;
            build = nbuild;
            space = nspace;
        }
        long tans = (build+space)%mod;
        long ans = (tans*tans)%mod;
        return (int)ans;
        
    }
}