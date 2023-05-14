// Maximum subset sum
// Finding a high paying job is easier than today's problem! Attend Job Fair 2023
 

// Given an array A of size N. Find the maximum subset-sum of elements that you can make from the given array such that for every two consecutive elements in the array, at least one of the elements is present in our subset. 

// Example 1:

// Input: 
// N = 4
// A[] = {1, -1, 3, 4}
// Output: 8
// Explanation: 
// We can choose 0th,2nd & 3rd index(0 based 
// Index),so that it can satisfy the 
// condition & can make maximum sum 8. 
// Example 2:

// Input: 
// N = 3
// A[] =  {0, 2, 0};
// Output: 2
// Explanation: 
// We can choose 1st index. Here the 
// maximum possible sum is 2.



class Solution {     
    static long help(int n,int[] arr,int index,int indication,long dp[][]){
           if(index==n)return 0;
           if(dp[index][indication]!=-1)return dp[index][indication];
           long a=Integer.MIN_VALUE,b=Integer.MIN_VALUE;
           if(indication==1){
               b=help(n,arr,index+1,0,dp);
           }
           a=arr[index]+help(n,arr,index+1,1,dp);
           return dp[index][indication]=Math.max(a,b);
       }
       public static long findMaxSubsetSum(int N, int[] A) {
           // code here
           long dp[][] = new long[N][2];
           for(long []temp:dp){
               Arrays.fill(temp,-1);
           }
           return help(N,A,0,1,dp);
       }
   }