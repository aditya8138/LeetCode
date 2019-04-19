package com.aditya.files.other;

import java.util.*;

public class Solution {

    public String[] uncommonFromSentences(String A, String B) {
        StringTokenizer stA = new StringTokenizer(A);
        StringTokenizer stB = new StringTokenizer(B);

        HashSet<String> set = new HashSet<String>();
        if(stA.hasMoreTokens()){
            set.add(stA.nextToken());
        }
        if(stB.hasMoreTokens()){
            String bString =stB.nextToken();
            if(!set.add(bString)){
                set.remove(bString);
            }
        }
        List<String> list = new ArrayList<String>(set);
        System.out.println(list);
        String[] arr = new String[list.size()];
        arr=list.toArray(arr);
        return arr;
    }
}
