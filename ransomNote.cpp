#include <unordered_map>
#include <string>
using namespace std;
/*
Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.



Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false
Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false
Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true


Constraints:

1 <= ransomNote.length, magazine.length <= 105
ransomNote and magazine consist of lowercase English letters.
*/
class Solution
{
public:
    bool canConstruct(string ransomNote, string magazine)
    {
        unordered_map<char, int> hm;
        for (char c : magazine)
            hm.find(c) == hm.end() ? hm[c] = 1 : hm[c] += 1;

        for (char c : ransomNote)
        {
            if (hm.find(c) == hm.end() || hm[c] == 0)
                return false;
            hm[c] -= 1;
        }
        return true;
    }
};