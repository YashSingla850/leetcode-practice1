class Solution {
    public int minBitFlips(int start, int goal) {
        int n = start^goal;
        int count = 0;
        while(n!=0){
            int rsb = n& -n;
            n = n-rsb;
            count++;
        }
        return count;
    }
}