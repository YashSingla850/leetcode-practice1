//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		     
		    int arr [] = new int[sizeOfArray];
		    
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    int K = Integer.parseInt(br.readLine());
		    
		    Complete obj = new Complete();
		    int ans = obj.minSwap(arr, sizeOfArray, K);
		    System.out.println(ans);
		}
	}
}

// } Driver Code Ends


//User function Template for Java



class Complete{

    public static int minSwap (int arr[], int n, int k) {
        //Complete the function
        int count =0;
        for(int val: arr){
            if(val<=k){
                count++;
            }
        }
        if(count==0){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int nfav =0;
        
        for(int i =0 ;i<count-1 ; i++){
            if(arr[i]>k){
                nfav++;
            }
        }
        int j =0;
        for(int i = count-1 ; i<n ;i++){
            if(arr[i]>k){
                nfav++;
            }
            min = Math.min(min , nfav);
            if(arr[j]>k){
                nfav--;
            }
            j++;
        }
        return min;
        
    }
}
