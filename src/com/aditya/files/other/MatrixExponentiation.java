package com.aditya.files.other;

public class MatrixExponentiation {
    static int SIZE=10;

    static int[][] fastExp(int[][] A, double n){
        if(n==1) {
            return A;
        }
        else {
            if(n%2==0){
                int[][] A1 = fastExp(A,n/2);
                return mul(A1,A1);
            }else{
                return mul(A,fastExp(A,n-1));
            }
        }
    }

    static int[][] mul(int a[][], int b[][]) {

        int mul[][] = new int[10][10];


        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++){
                    mul[i][j] = (mul[i][j]+a[i][k]* b[k][j]) % 1000000007;
                }
            }
        }
        return mul;
    }


    public static void main(String[] args) {
        int[][] a = {{1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1,1,1}};
        int[][] res = fastExp(a,Math.pow(10,9));
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}
