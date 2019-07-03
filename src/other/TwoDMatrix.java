package other;

public class TwoDMatrix {

    public static boolean isToeplitzMatrix(int[][] matrix) {
        int hori = matrix.length;
        int vert = matrix[0].length;

        for (int i = 0; i < hori; i++) {
            for (int j = 0; j < vert; j++) {
                if (matrix[i] != null && matrix[j] != null && matrix[i + 1] != null && matrix[j + 1] != null) {
                    return matrix[i][j] == matrix[i + 1][j + 1];
                }
            }
        }
        return false;
    }
}
