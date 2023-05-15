// Count Total Setbits
// You are given a number N. Find the total number of setbits in the numbers from 1 to N. 

// Example 1:

// Input: N = 3
// Output: 4
// Explaination: 
// 1 -> 01, 2 -> 10 and 3 -> 11. 
// So total 4 setbits.
// Example 2:

// Input: N = 4
// Output: 5
// Explaination: 1 -> 01, 2 -> 10, 3 -> 11 
// and 4 -> 100. So total 5 setbits.


//{ Driver Code Starts
    import java.io.*;
    import java.util.*;
    
    class GFG {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t;
            t = Integer.parseInt(br.readLine());
            while(t-- > 0){
                
                long N;
                N = Long.parseLong(br.readLine().trim());
                
                Solution obj = new Solution();
                long res = obj.countBits(N);
                
                System.out.println(res);
                
            }
        }
    }
    
    // } Driver Code Ends
    
    
    class Solution {
           
      public static long countBits(long N) {
            // code here
            long ans = 0,i=1,n=N;
            while(n!=0){
                long temp = (N+1)/(i*2);
                ans+=temp*i;
                temp = (N+1)/i;
                if(temp%2==1)ans+=(N+1)%i;
                i*=2;
                n>>=1;
            }
            return ans;
        }
    }