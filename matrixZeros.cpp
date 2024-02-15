#include <vector>
#include <set>
using namespace std;
/*
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

You must do it in place.



Example 1:


Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
Example 2:


Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]


Constraints:

m == matrix.length
n == matrix[0].length
1 <= m, n <= 200
-231 <= matrix[i][j] <= 231 - 1

*/
class Solution
{
public:
    void setZeroes(vector<vector<int>> &matrix)
    {
        set<int> r;
        set<int> c;
        int rows = matrix.size();
        int cols = matrix[0].size();
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (matrix[i][j] == 0)
                {
                    r.insert(i);
                    c.insert(j);
                }

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
            {
                auto it = r.find(i);
                auto itt = c.find(j);
                if (it != r.end() || itt != c.end())
                {
                    matrix[i][j] = 0;
                }
            }
    }
};