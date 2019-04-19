package com.aditya.files.other;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    public List<String> fizzBuzz(int n) {
        List<String> fb= new ArrayList<>();
        for(int i=1; i<=n;i++){
            if(i%3!=0 && i%5!=0){
                fb.add(String.valueOf(i));
            }
            if(i%3==0){
                fb.add("Fizz");
            }
            if(i%5==0){
                fb.add("Buzz");
            }
            if(i%3==0 && i%5==0){
                fb.add("FizzBuzz");
            }
        }
        return fb;
    }
}
