#include <vector>
using namespace std;

/*
Given an integer array nums, return the length of the longest strictly increasing 
subsequence
.

 

Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1
 

Constraints:

1 <= nums.length <= 2500
-104 <= nums[i] <= 104
*/
class Solution
{
public:
    int lengthOfLIS(vector<int> &nums)
    {
        int lengths[2500] = {1};
        for (int i = 1; i < nums.size(); i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (nums[j] < nums[i])
                {
                    lengths[i] = max(lengths[i], lengths[j] + 1);
                }
            }
        }
        int max_length = 1;
        for (int i = 0; i < nums.size(); i++)
        {
            if (lengths[i] > max_length)
            {
                max_length = lengths[i];
            }
        }
        return max_length;
    }
};