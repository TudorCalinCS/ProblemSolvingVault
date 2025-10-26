package leetcode;

import static java.lang.Math.min;

public class GoodLand {
    class Main {
        public int goodLand(int[][] matrix) {

            int n = matrix.length;
            int m = matrix[0].length;
            if (matrix == null || n == 0 || m == 0) return 0;
            int maxx = 0;
            int dp[][] = new int[n+1][m+1];
            for(int i = 0; i < n+1 ; i++)
                for (int j = 0; j < m+1; j++)
                    dp[i][j] = 0;

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (matrix[i-1][j-1] == 1) {
                        dp[i][j] = 1 + Math.min(Math.min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1]);
                        if (dp[i][j] > maxx)
                            maxx = dp[i][j];
                    }
                    else dp[i][j] = 0;
                }
            }
            return maxx * maxx;
        }


    }
}
