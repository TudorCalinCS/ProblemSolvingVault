"""
You are given a string s.

A split is called good if you can split s into two non-empty strings sleft and sright where their concatenation is equal to s (i.e., sleft + sright = s) and the number of distinct letters in sleft and sright is the same.

Return the number of good splits you can make in s.

 

Example 1:

Input: s = "aacaba"
Output: 2
Explanation: There are 5 ways to split "aacaba" and 2 of them are good. 
("a", "acaba") Left string and right string contains 1 and 3 different letters respectively.
("aa", "caba") Left string and right string contains 1 and 3 different letters respectively.
("aac", "aba") Left string and right string contains 2 and 2 different letters respectively (good split).
("aaca", "ba") Left string and right string contains 2 and 2 different letters respectively (good split).
("aacab", "a") Left string and right string contains 3 and 1 different letters respectively.
Example 2:

Input: s = "abcd"
Output: 1
Explanation: Split the string as follows ("ab", "cd").
 

Constraints:

1 <= s.length <= 105
s consists of only lowercase English letters.
"""

class Solution(object):
    def numSplits(self, s):

        leftUnique = {}
        rightUnique = {}
        goodCombinations = 0
        
        for char in s:
            rightUnique[char] = rightUnique.get(char, 0) + 1
        
        uniqueCharsLeft = 0
        uniqueCharsRight = len(rightUnique)
        
        for char in s:
            leftUnique[char] = leftUnique.get(char, 0) + 1
            if leftUnique[char] == 1:
                uniqueCharsLeft += 1
            
            rightUnique[char] -= 1
            if rightUnique[char] == 0:
                uniqueCharsRight -= 1
            
            if uniqueCharsLeft == uniqueCharsRight:
                goodCombinations += 1
        
        return goodCombinations

"""
class Solution(object):

    def numSplits(self, s):  
     
        goodCombinations=0
        
        for i in range(1, len(s)):
            start = s[0:i]
            end = s[i:]
            set1=set(start)
            set2=set(end)
            if len(set1)==len(set2):
                goodCombinations+=1
        
        return goodCombinations        
"""
"""
class Solution(object):
    def splitter(self, s):
    
        result=[]
        for i in range(1, len(s)):
            start = s[0:i]
            end = s[i:]
            result.append([start,end])
        return result
    
    def unique(self, s):
    
        seen=[]
        for char in s:
            if char not in seen:
                seen.append(char)
        return len(seen)

    def numSplits(self, s):
    
        goodCombinations=0
        combinations = list(self.splitter(s))
        for lList in combinations:
            if self.unique(lList[0])==self.unique(lList[1]):
                goodCombinations+=1
        return goodCombinations        
        
 """