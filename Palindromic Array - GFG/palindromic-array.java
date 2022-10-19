//{ Driver Code Starts
import java.util.*;
class PalindromicArray{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
			int n = sc.nextInt();
			int[] a = new int[n];
			for(int i = 0 ;i < n; i++)
				a[i]=sc.nextInt();
			GfG g = new GfG();
			System.out.println(g.palinArray(a , n));
		}
	}
}
// } Driver Code Ends


/*Complete the Function below*/
class GfG
{
	public static int palinArray(int[] a, int n)
           {
                  //add code here
                  for(int i =0 ; i<a.length;  i++){
                       boolean helper = isPallindrome(a[i]);
                       if(helper==false){
                           return 0;
                       }
                  }
                 return 1;
           }
           
           public static boolean isPallindrome(int val){
               String s = Integer.toString(val);
               char []arr = s.toCharArray();
               int i = 0 , j = arr.length-1;
               while(i<j){
                   if(arr[i]!=arr[j]){
                       return false;
                   }
                   i++;
                   j--;
               }
               return true;
           }
}