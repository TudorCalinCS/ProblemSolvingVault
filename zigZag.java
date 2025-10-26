/*
 The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
 

Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I
Example 3:

Input: s = "A", numRows = 1
Output: "A"
 

Constraints:

1 <= s.length <= 1000
s consists of English letters (lower-case and upper-case), ',' and '.'.
1 <= numRows <= 1000
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        Map<Integer, List<Character>> map = new HashMap<>();
        int down = 1;
        int offset = 1;
        for (int i = 0; i < s.length(); i++) {
            map.computeIfAbsent(offset, k -> new ArrayList<>()).add(s.charAt(i));

            if (offset == numRows)
                down = -1;
            else if (offset == 1)
                down = 1;

            offset += down;

        }
        StringBuilder sBuilder = new StringBuilder(s.length());
        for (int i = 1; i <= numRows; i++) {
            List<Character> list = map.get(i);
            if (list == null)
                continue;

            for (char c : list) {
                sBuilder.append(c);
            }
        }
        return sBuilder.toString();

    }
}