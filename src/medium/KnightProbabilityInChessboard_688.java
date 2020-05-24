public class KnightProbabilityInChessboard_688 {
    public static double knightProbability(int N, int K, int r, int c) {
        double res = 0.0;
        int[] X = {1, 2, 2, 1, -1, -2, -2, -1};
        int[] Y = {2, 1, -1, -2, -2, -1, 1, 2};
        
        double[][] dp1 = new double[N][N];
        dp1[r][c] = 1;
        while (K > 0) {
            double[][] dp2 = new double[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int p = 0; p < X.length; p++) {
                        int row = i + X[p];
                        int col = j + Y[p];
                        if (isInside(N, row, col)) {
                            dp2[row][col] += dp1[i][j] / 8.0;
                        }
                    }
                }
            }
            dp1 = dp2;
            K--;
        }

        for (double[] row : dp1) {
            for (double x : row) {
                res += x;
            }
        }
        return res;
    }

    private static boolean isInside(int n, int row, int col) {
        if (n > row && n > col && row >= 0 && col >= 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(knightProbability(3, 2, 0, 0));
    }
}
