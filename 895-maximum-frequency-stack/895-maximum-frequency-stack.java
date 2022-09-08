class FreqStack {
HashMap<Integer,Integer>map;
    HashMap<Integer,Stack<Integer>>map2;
    int mfreq;
    public FreqStack() {
        map =  new HashMap<>();
        map2 =   new HashMap<>();
        mfreq = 0;
    }
    
    public void push(int val) {
        int freq  = map.getOrDefault(val,0)+1;
        map.put(val,freq);
        if(freq > mfreq){
            mfreq = freq;
        }
        if(map2.containsKey(freq)==false){
            map2.put(freq , new Stack<>());
        }
         map2.get(freq).push(val);
    }
    
    public int pop() {
        int val = map2.get(mfreq).pop();
        if(map2.get(mfreq).size()==0){
            mfreq--;
        }
        map.put(val , map.get(val)-1);
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */