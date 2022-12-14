//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;


class Array {

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		  
		    //size of array
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    //adding elements to the array
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    Solution obj = new Solution();
		    
		    //calling trappingWater() function
		    System.out.println(obj.trappingWater(arr, n));
		}
	}
}


// } Driver Code Ends


class Solution{
    
    // arr: input array
    // n: size of array
    // Function to find the trapped water between the blocks.
    static long trappingWater(int arr[], int n) { 
        int left = 0 , right = n-1;
        long sum = 0;
        int leftmax =0;
        int rightmax = 0;
        while(left<right){
        leftmax =  Math.max(leftmax , arr[left]);
        rightmax =  Math.max(rightmax , arr[right]);
        
        if(leftmax<=rightmax){
            sum+= leftmax-arr[left];
            left++;
        }else{
            sum+=rightmax-arr[right];
            right--;
          }
        }
        return sum;
    } 
}



// class Solution{
    
//     // arr: input array
//     // n: size of array
//     // Function to find the trapped water between the blocks.
//     static long trappingWater(int arr[], int n) { 
//         // Your code here
//       long maxLeft []  = new long[n];
//       long  maxRight []  = new long[n];
//         long maxl =arr[0] , maxr =arr[n-1] , sum =0;
//         maxLeft[0] = arr[0];
//         maxRight[n-1] = arr[n-1];
//         for(int i =1 ; i<n ;i++){
//             maxl = Math.max(arr[i], maxl);
//             maxLeft[i] = maxl;
//             maxr = Math.max(arr[n-1-i] , maxr);
//             maxRight[n-1-i] = maxr;
//         }
//         for(int i =0 ; i<n ; i++){
//             sum+=Math.min(maxLeft[i], maxRight[i]) -arr[i];
//         }
//         return sum;
//     } 
// }
