class Solution {
    public boolean isPalindrome(int x) {
        List<Integer>list = new ArrayList<>();
        if(x<0)return false;
          // x = Math.abs(x);
        helper(x , list);
        return isPallindrome(list);
    }
    public void helper(int x, List<Integer>list){
        while(x>0){
            int d = x%10;
            list.add(d);
            x = x/10;
        }
    }
        public boolean isPallindrome(List<Integer>list){
            int n = list.size();
            int i  = 0  ,j = n-1;
            while(i<=j){
                if(list.get(i)!=list.get(j)){
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }
    
}