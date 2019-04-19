package com.aditya.files.other;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WorkSchedule {


    public List<String> findCombination(String input, int hours, int totalHours){
//
        List<String> resultList = new ArrayList<String>();

        int arr[] = new int [totalHours-hours];
        findCombinationsUtil(arr, 0, totalHours-hours, totalHours-hours);

        return resultList;
    }




    static void findCombinationsUtil(int arr[], int index,
                                     int num, int reducedNum)
    {

        List<Integer> intList = new ArrayList<Integer>();
        String empty = "";

        if (reducedNum < 0)
            return;


        if (reducedNum == 0)
        {
            for (int i = 0; i < index; i++)

                System.out.print (arr[i] + " ");
            System.out.println();
            return;
        }


        int prev = (index == 0) ?
                1 : arr[index - 1];


        for (int k = prev; k < num ; k++)
        {

            arr[index] = k;


            findCombinationsUtil(arr, index + 1, num,
                    reducedNum - k);
        }
    }

}
