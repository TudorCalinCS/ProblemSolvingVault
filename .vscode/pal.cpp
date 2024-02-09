#include <string>
using namespace std;
/*
Given an integer x, return true if x is a 
palindrome
, and false otherwise.

 

Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 

Constraints:

-231 <= x <= 231 - 1
 
*/
class Solution
{
public:
    bool isPalindrome(int x)
    {
        
        long long reversed = 0;
        long long cx = x;
        while (cx > 0)
        {   int last=cx%10;
            reversed = reversed * 10 + last;
            cx /= 10;
        }
        if (x == reversed)
            return true;
        return false;
        
        /*
        string c = to_string(x);
        int n = c.length()-1;
        for (int i = 0; i < n; i++)
        {
            if (c[i] != c[n - i])
                return false;
        }
        return true;
        */
    }
};
