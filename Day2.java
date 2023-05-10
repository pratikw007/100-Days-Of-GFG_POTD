// Day 2:-    Total Cuts   (10/05/2023)

// Finding a high paying job is easier than today's problem! Attend Job Fair 2023
 

// You are given an array A of N integers and an integer K, and your task is to find the total number of cuts that you can make such that for each cut these two conditions are satisfied
// 1. A cut divides an array into two parts equal or unequal length (non-zero).
// 2. Sum of the largest element in the left part and the smallest element in the right part is greater than or equal to K.

// Example 1:

// Input:
// N=3
// K=3
// A[]={1,2,3}
// Output:
// 2
// Explanation:
// Two ways in which array is divided to satisfy above conditions are:
// {1} and {2,3} -> 1+2>=3(satisfies the condition)
// {1,2} and {3} -> 2+3>=3(satisfies the condition)


class Solution {
         
    public static int totalCuts(int N, int K, int[] A) {
          // code here
          int left[]=new int[N];
          int right[]=new int[N];
          left[0]=A[0];
          for(int i=1;i<N;i++){
              left[i]=Math.max(left[i-1],A[i]);
          }
          right[N-1]=A[N-1];
          for(int i=N-2;i>=0;i--){
              right[i]=Math.min(right[i+1],A[i]);
          }
          int ans=0;
          for(int i=1;i<N;i++){
              if(left[i-1]+right[i]>=K)ans++;
          }
          return ans;
      }
      
  }