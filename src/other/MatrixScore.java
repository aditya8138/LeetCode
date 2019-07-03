package other;

public class MatrixScore {
    private static int calc(int[][] A) {
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            int temp = 0;
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    temp += 1 << (A[0].length - j - 1);
                }
            }
            result += temp;
        }
        return result;
    }

    public static void flipRow(int[][] A, int i) {
        for (int j = 0; j < A[0].length; i++) {
            A[i][j] = 1 - A[i][j];
        }
    }

    public static Boolean moreZero(int[][] A, int j) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i][j] == 0) {
                count++;
            }
        }
        return count > A.length / 2;
    }

    public static void flipCol(int[][] A, int j) {
        for (int i = 0; i < A.length; i++) {
            A[i][j] = 1 - A[i][j];
        }
    }

    public static int matrixScore(int[][] A) {
        int rowSize = A.length;
        int colSize = A[0].length;

        for (int i = 0; i < rowSize; i++) {
            flipRow(A, i);
        }

        for (int j = 0; j < colSize; j++) {
            if (moreZero(A, j)) {
                flipCol(A, j);
            }
        }
        return calc(A);
    }


}
