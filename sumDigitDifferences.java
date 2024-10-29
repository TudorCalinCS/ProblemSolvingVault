import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
/*
 You are given an array nums consisting of positive integers where all integers have the same number of digits.

The digit difference between two integers is the count of different digits that are in the same position in the two integers.

Return the sum of the digit differences between all pairs of integers in nums.

 

Example 1:

Input: nums = [13,23,12]

Output: 4

Explanation:
We have the following:
- The digit difference between 13 and 23 is 1.
- The digit difference between 13 and 12 is 1.
- The digit difference between 23 and 12 is 2.
So the total sum of digit differences between all pairs of integers is 1 + 1 + 2 = 4.

Example 2:

Input: nums = [10,10,10,10]

Output: 0

Explanation:
All the integers in the array are the same. So the total sum of digit differences between all pairs of integers will be 0.

 

Constraints:

2 <= nums.length <= 105
1 <= nums[i] < 109
All integers in nums have the same number of digits.
 */
class Solution {
    public long sumDigitDifferences(int[] nums) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int n : nums) {
            int c = 1;
            while (n > 0) {
                List<Integer> list = new ArrayList<>();
                if (map.containsKey(c))
                    list = map.get(c);
                list.add(n % 10);
                map.put(c, list);
                n /= 10;
                c++;
            }
        }

        List<List<Integer>> list = new ArrayList<List<Integer>>(map.values());
        long sum = 0;

        for (List<Integer> l : list) {
            int[] count = new int[10];
            for (int digit : l)
                count[digit]++;
            Collections.sort(l);
            int totalNumbers = l.size();
            int maxDigit = Collections.max(l);
            for (int digit = maxDigit - 1; digit >= 0; digit--) {

                int freq = count[digit];
                if (freq > 0) {
                    sum += (long) freq * (totalNumbers - freq);
                    totalNumbers -= freq;
                }
            }
        }

        return sum;
    }
}
