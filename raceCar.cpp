#include <vector>
#include <queue>
#include <utility>

using namespace std;
/*
Your car starts at position 0 and speed +1 on an infinite number line. Your car can go into negative positions. Your car drives automatically according to a sequence of instructions 'A' (accelerate) and 'R' (reverse):

When you get an instruction 'A', your car does the following:
position += speed
speed *= 2
When you get an instruction 'R', your car does the following:
If your speed is positive then speed = -1
otherwise speed = 1
Your position stays the same.
For example, after commands AAR, your car goes to positions 0 --> 1 --> 3 --> 3, and your speed goes to 1 --> 2 --> 4 --> -1.

Given a target position target, return the length of the shortest sequence of instructions to get there.



Example 1:

Input: target = 3
Output: 2
Explanation:
The shortest instruction sequence is AA.
Your position goes from 0 --> 1 --> 3.
Example 2:

Input: target = 6
Output: 5
Explanation:
The shortest instruction sequence is AAARA.
Your position goes from 0 --> 1 --> 3 --> 7 --> 7 --> 6.


Constraints:

1 <= target <= 104
*/

class Solution
{
public:
    int racecar(int target)
    {
        queue<vector<int>> q;
        // 0-moves 0-position 1-speed
        q.push({0, 0, 1});
        while (!q.empty())
        {
            vector<int> values = q.front();
            q.pop();
            int moves = values[0];
            int position = values[1];
            int speed = values[2];

            if (position == target)
                return moves;

            // bypass integer overflow in tests
            if (abs(position) > target * 2)
                continue;

            q.push({moves + 1, position + speed, speed * 2});
            if ((position + speed > target && speed > 0) || (position + speed < target && speed < 0))
                q.push({moves + 1, position, (speed > 0) ? -1 : 1});
        }
        return 0;
    }
};