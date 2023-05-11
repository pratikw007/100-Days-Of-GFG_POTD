// Palindrome with minimum sum  Day 03
// Given a string, S.The string can contain small case English letters or '?'. You can replace '?' with any small English letter. Now if it is possible to make the string S a palindrome after replacing all '?' then find the palindromic string with a minimum ascii sum of the absolute difference of adjacent characters. Otherwise, return -1.

// Example 1:

// Input: S = a???c??c????
// Output: 4
// Explanation:
// We can see that we can make the string
// palindrome. Now to get minimum ascii sum we should
// replace all the '?' between 'a' and 'c' with
// 'b' and all the '?' between two 'c' with 'c'.
// So after replacing all the '?' the string: 
// abbbccccbbba.
// The sum of differences of adjacent characters is 4.   

class Solution {

    static char help(String s){
           int i=0,j=s.length()-1;
           while(i<=j){
               if(s.charAt(i)!='?')return s.charAt(i);
               if(s.charAt(j)!='?')return s.charAt(j);
               i++;
               j--;
               
           }
           return '#';
       }
       public static int minimumSum(String s) {
           // code here
           int i=0,j=s.length()-1,ans=0;
           char prev = '#';
           while(i<=j){
               if(s.charAt(i)=='?' && s.charAt(j)=='?'){
                   if(prev=='#'){
                       prev = help(s);
                       if(prev=='#')return 0;
                   }
               }
               else if(s.charAt(i)=='?'){
                   if(prev!='#'){
                       ans+=2*Math.abs(prev-s.charAt(j));
                   }
                   prev=s.charAt(j);
               }
               else if(s.charAt(j)=='?'){
                   if(prev!='#'){
                       ans+=2*Math.abs(prev-s.charAt(i));
                   }
                   prev=s.charAt(i);
               }
               else if(s.charAt(i)==s.charAt(j)){
                   if(prev!='#'){
                       ans+=2*Math.abs(prev-s.charAt(i));
                   }
                   prev=s.charAt(i);
               }
               else return -1;
               i++;
               j--;
           }
           return ans;
       }
   }