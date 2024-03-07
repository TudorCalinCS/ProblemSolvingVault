#include <vector>
using namespace std;
/*
Given an m x n matrix, return all elements of the matrix in spiral order.



Example 1:


Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:


Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]


Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100
*/
class Solution
{
public:
    vector<int> spiralOrder(vector<vector<int>> &matrix)
    {
        int i = 0, j = 0;
        int n = matrix.size() - 1;    // rows
        int m = matrix[0].size() - 1; // col
        vector<int> result;

        if (m == 0)
        {
            for (int x = 0; x <= n; x++)
                result.push_back(matrix[x][0]);
            return result;
        }

        int turn = 1; // 1 - going right 2 - going down  3 - going left  4 - going up
        int c1 = 0, c2 = 0, c3 = 0, c4 = 0;
        while (matrix[i][j] != -101)
        {
            result.push_back(matrix[i][j]);
            matrix[i][j] = -101;
            if (turn == 1)
            {
                if (j == m - c2)
                {
                    turn = 2;
                    c1++;
                }
                else
                    j++;
            }
            if (turn == 2)
            {
                if (i == n - c3)
                {
                    turn = 3;
                    c2++;
                }
                else
                    i++;
            }
            if (turn == 3)
            {
                if (j == 0 + c4)
                {
                    turn = 4;
                    c3++;
                }
                else
                    j--;
            }
            if (turn == 4)
            {
                if (i == 0 + c1)
                {
                    turn = 1;
                    c4++;
                    j = c4;
                }
                else
                    i--;
            }
        }
        return result;
    }
};