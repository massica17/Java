package oralTest.tianyiyun1011;

public class Test01 {
    public int[][] solve(int[][] matrix) {
        int n, m;
        if ((n = matrix.length) == 0 || (m = matrix[0].length) == 0) return matrix;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++){
                matrix[i][j] = matrix[i][j] % 2 == 0 ? matrix[i][j] * 3 : matrix[i][j];
            }
        }
        return matrix;
    }
}
