package com.aditya.files.other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadingInput {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String line;

        try {


            while ((line = stdin.readLine()) != null && line.length() != 0) {
                String[] input = line.split(" ");
                if(input.length>=2)
                    System.out.println((input[0] + " "  + input[1]));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
