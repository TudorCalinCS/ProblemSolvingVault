#include <string>
#include <stack>
using namespace std;
/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
*/
class Solution
{
public:
    bool isValid(string s)
    {
        if (s.size() < 2)
            return false;
        stack<char> parantheses;
        string openingParantheses = "([{";
        for (char c : s)
        {
            if (openingParantheses.find(c) < openingParantheses.length())
                parantheses.push(c);
            else
            {
                if (parantheses.size() == 0)
                    return false;
                char topStack = parantheses.top();
                parantheses.pop();
                if (c == ')' && topStack != '(')
                    return false;
                else if (c == ']' && topStack != '[')
                    return false;
                else if (c == '}' && topStack != '{')
                    return false;
            }
        }
        if (parantheses.size() > 0)
            return false;
        return true;
    }
};