package com.aditya.files.other;

public class BinaryGap {

    public int binaryGap(int N) {
        int[] binaryArr = new int[1000];
        int i=0;
        while(N>0){
            binaryArr[i]=N%2;
            N=N/2;
            i++;
        }
        int count=0;
        for (int j=0; j<binaryArr.length;j++){
            if(binaryArr[j]==1){
                count++;
            }
        }
        return count-1;
    }
}
