class NumArray {
    class fenwick{
        int []farr;
       fenwick(int[]nums){
            this.farr = new int[nums.length+1];
        }
        int sum(int pos){
            int res =0;
            while(pos>0){
                res+=farr[pos];
                pos = pos-rsb(pos);
            }
            return res;
        }
        void update(int pos , int delta){
//  agar hume 5 ko update karna hai to wo un sb jgha pe hoga jhaa use contain kar rakha hoga to wo sari jgha pta lagane ke liye ye loop hai....
            while (pos<farr.length){
                farr[pos]+=delta;
                pos = pos+rsb(pos);
            }
        }
        private int rsb(int x){
            return x&-x;
        }
    }
    fenwick ft;
    int []oarr;
    

    public NumArray(int[] nums) {
        ft = new fenwick(nums);
        oarr = nums;
        for(int i =0 ; i<nums.length;i++){
            int pos = i+1;
            int val = nums[i];
            ft.update(pos, val);
        }
    }
    
    public void update(int index, int val) {
     int delta = val-oarr[index];
        int pos = index+1;
        ft.update(pos , delta);
        oarr[index] = val;
    }
    
    public int sumRange(int left, int right) {
        int lpos = left+1;
        int rpos = right+1;
        int sumBeforeLeft = ft.sum(lpos-1);
        int sumTillRight = ft.sum(rpos);
        return sumTillRight-sumBeforeLeft;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */