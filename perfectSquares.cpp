#include <vector>
using namespace std;
/*
Given an integer n, return the least number of perfect square numbers that sum to n.

A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.

 

Example 1:

Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.
 

Constraints:

1 <= n <= 104
""
*/
class Solution {
public:
  int minNumbersToAdd(int target, const vector<int>& numbers) {
    vector<int> dp(target+1,INT_MAX);
    dp[0]=0;
    for(int i=1;i<=target;i++){
        for(int nr:numbers){
            if(i>=nr&&dp[i-nr]!=INT_MAX)
                dp[i]=min(dp[i],dp[i-nr]+1);
        }
    }

    return dp[target];
}
    int numSquares(int n) {
        vector<int> squares;
        for(int i=1;i*i<=n;i++){
            squares.push_back(i*i);
        }
        return minNumbersToAdd(n,squares);
    }
};