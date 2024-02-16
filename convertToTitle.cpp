#include <string>
#include <stack>
using namespace std;
/*
Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.

For example:

A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28 
...
 

Example 1:

Input: columnNumber = 1
Output: "A"
Example 2:

Input: columnNumber = 28
Output: "AB"
Example 3:

Input: columnNumber = 701
Output: "ZY"
 

Constraints:

1 <= columnNumber <= 231 - 1
*/
class Solution
{
public:
    string convertToTitle(int columnNumber)
    {
        int c = columnNumber;
        stack<char> letters;
        while (c > 0)
        {
            if (c / 26 > 0 && c % 26 == 0)
            {
                letters.push('Z');
                c = (c / 26) - 1;
            }
            else
            {
                int n = (c - 1) % 26;
                string let = "ABCDEFGHIJKLMNOPQRSTUVWXY";
                letters.push(let[n]);
                c = (c / 26);
            }
        }

        string result;
        while (letters.size() > 0)
        {
            result += letters.top();
            letters.pop();
        }
        return result;
    }
};
