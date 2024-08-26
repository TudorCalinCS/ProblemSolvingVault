#include <vector>
#include <string>
#include <algorithm>
using namespace std;

/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.



Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false


Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
*/
class Solution
{
public:
    bool isAnagram(string s, string t)
    {

        if (s.size() != t.size())
            return false;
        vector<char> vs;
        vector<char> vt;
        for (char c : s)
            vs.push_back(c);

        for (char c : t)
            vt.push_back(c);

        sort(vs.begin(), vs.end());
        sort(vt.begin(), vt.end());
        for (int i = 0; i < vs.size(); i++)
        {
            if (vt[i] != vs[i])
                return false;
        }
        return true;
    }
};