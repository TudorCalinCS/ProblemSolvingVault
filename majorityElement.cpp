#include <vector>
#include <unordered_map>

using namespace std;

/*
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.



Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2


Constraints:

n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109
*/
class Solution
{
public:
    int majorityElement(vector<int> &nums)
    {
        unordered_map<int, int> map;
        for (int nr : nums)
        {
            auto it = map.find(nr);
            if (it == map.end())
                map[nr] = 1;
            else
                it->second++;
        }
        int max = 0;
        int el = 0;
        for (auto it : map)
        {
            if (it.second > max)
            {
                max = it.second;
                el = it.first;
            }
        }
        return el;
    }
};