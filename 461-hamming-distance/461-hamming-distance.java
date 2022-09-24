class Solution {
    public int hammingDistance(int x, int y) {
        int val = x&y;
        int count = 0;
        int temp = val;
        while(temp!=0){
            int rsb = (temp&-temp);
            temp = temp-rsb;
            count-=2;
        }
        while(x!=0){
            int rsb = x&-x;
            x = x-rsb;
            count++;
        }
            while(y!=0){
        int rsb = y&-y;
        y = y-rsb;
        count++;
         }
        return count;
    }
}