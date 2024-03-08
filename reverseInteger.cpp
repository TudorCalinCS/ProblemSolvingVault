#include <climits>
#include <stdlib.h>
#include <corecrt_math.h>
/*
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

 

Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21
 

Constraints:

-231 <= x <= 231 - 1
*/
class Solution
{
public:
    int reverse(int x)
    {
        // INT_MAX 32b
        int y;
        x < 0 ? y = -2147483648 : y = 2147483647;
        int reverse = 0;
        while (x % 10 == 0 && x > 0)
            x /= 10;
        int cx = x;
        while (cx != 0)
        {
            if (abs(y / 10) - abs(reverse) < 0)
                return 0;
            if (reverse * 10 + cx % 10 < y && y < 0 || reverse * 10 + cx % 10 > y && y >= 0)
                return 0;
            reverse = reverse * 10 + cx % 10;
            cx /= 10;
        }
        return reverse;
    }
};