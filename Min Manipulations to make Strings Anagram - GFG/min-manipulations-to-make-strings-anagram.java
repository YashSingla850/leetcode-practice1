//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            int N = Integer.parseInt(read.readLine().trim());
            String []input_line = read.readLine().trim().split("\\s+");
            String S1 = input_line[0];
            String S2 = input_line[1];
            Solution obj = new Solution();
            int ans = obj.minManipulation(N, S1, S2); 
            System.out.println(ans);
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    int minManipulation(int N, String S1, String S2) 
    {
        // code here
        int count=0;
        HashMap<Character , Integer>map = new HashMap<>();
        for(int i =0 ; i<S1.length() ; i++){
            char ch = S1.charAt(i);
            map.put(ch , map.getOrDefault(ch,0)+1);
        }
        for(int i =0  ; i<S2.length();i++){
            char ch = S2.charAt(i);
            if(map.containsKey(ch)==true){
            int freq = map.get(ch);
            if(freq==1){
                map.remove(ch);
            }else{
                map.put(ch,freq-1);
            }
        }else{
            count++;
        }
       
    }
     return count;
  } 
} 