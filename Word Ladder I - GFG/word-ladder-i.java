//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            int ans = obj.wordLadderLength(startWord, targetWord, wordList);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends

class pair{
    String first;
    int second;
    pair(String first , int second){
        this.first = first;
        this.second = second;
    }
}
class Solution
{
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        // Code here
        HashSet<String>set = new HashSet<>();
        for(int i =0 ; i<wordList.length;i++){
            set.add(wordList[i]);
        }
        set.remove(startWord);
        Queue<pair>q =  new ArrayDeque<>();
        q.add(new pair(startWord , 1));
        while(q.size()>0){
            pair temp = q.remove();
            String word = temp.first;
            int step = temp.second;
            if(word.equals(targetWord)){
                return step;
            }
            for(int i =0 ; i<word.length();i++){
                char arr[] = word.toCharArray();
                for(char c = 'a' ; c<='z'; c++){
                    arr[i] = c;
                    String newString = new String(arr);
                     if(set.contains(newString)==true){
                         set.remove(newString);
                         q.add(new pair(newString , step+1));
                     }
                }
            }
        }
        return 0;
    }
}