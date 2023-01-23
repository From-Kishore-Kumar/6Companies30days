//https://leetcode.com/problems/matrix-block-sum/
//leetcode problem 1314
class MatrixBlockSum {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int m = mat.length, n = mat[0].length;
        int[][] ans = new int[m][n], sum = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            int total = 0;
            for (int j = 0; j < n; j++) {
                total += mat[i][j];
                sum[i][j] = total;
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int r1 = Math.max(i - K, 0), r2 = Math.min(i + K, m - 1);
                int c1 = Math.max(j - K, 0), c2 = Math.min(j + K, n - 1);
                int val = 0;
                for (int k = r1; k <= r2; k++) {
                    val += (sum[k][c2] - (c1 > 0 ? sum[k][c1 - 1] : 0));
                }
                ans[i][j] = val;
            }
        }
        
        return ans;
    }
}