package leetcode;

class Solutions {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {

            for (int j = i; j < n - 1 - i; j++) {
                int a = matrix[i][j];
                int b = matrix[j][n - 1 - i];
                int c = matrix[n - 1 - i][n - 1 - j];
                int d = matrix[n - 1 - j][i];

                matrix[i][j] = d;
                matrix[j][n - 1 - i] = a;
                matrix[n - 1 - i][n - 1 - j] = b;
                matrix[n - 1 - j][i] = c;
            }

        }
    }
}