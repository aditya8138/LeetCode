package com.aditya.files.other;

public class FiboMatrixMultiplication {
    /* Raises the matrix to the exponent n, modulo m. */

    public static void main(String[] args) {
        int num  = NUM (10,1);
    }

    static int NUM(int n, int m)
    {
        int F[][] = {{2,2},{2,4}};
        if(n == 0)
            return 0;
        power(F, n-1, m);

        for (int i = 0; i < F.length; i++) {
            for (int j = 0; j < F[i].length; j++) {
                System.out.print(F[i][j] + " ");
            }
            System.out.println();
        }
        return F[0][0];
    }

    /* Takes a matrix modulo m. */
    static int[][] modMatrix(int F[][], int m)
    {
        F[0][0] = F[0][0] % m;
        F[0][1] = F[0][1] % m;
        F[1][0] = F[1][0] % m;
        F[1][1] = F[1][1] % m;
        return F;
    }

    /* Optimized version of power() - raises a matrix F to the exponent n modulo modulus */
    static int[][] power(int F[][], int n, int modulus)
    {
        if( n == 0 || n == 1) return F; // recursive termination condition

        int M[][] = {{2,2},{1,0}}; // original matrix for multiplication

        power(F, n/2, modulus); // raise the matrix to half the exponent
        if( n%2 != 0 )
            return modMatrix(multiply(F, M), modulus);

        return modMatrix(multiply(F, F), modulus);

         // square the matrix to go the rest of the way

         // if the exponent is odd, multiply one last time
    }


    static int[][] multiply(int a[][], int b[][]) {

        int mul[][] = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                mul[i][j] = 0;
                for (int k = 0; k < 2; k++)
                    mul[i][j] += a[i][k]
                            * b[k][j];
            }
        }
        return mul;
    }
}







