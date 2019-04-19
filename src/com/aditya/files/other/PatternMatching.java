package com.aditya.files.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PatternMatching {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> nWords = new ArrayList<String>();
        for(String word : words){
            Map<Character,Character> wordMap = new HashMap<Character,Character>();
            for(int i=0; i< word.length();i++){
                char curr = pattern.charAt(i);
                if(wordMap.containsKey(curr)){
                    if(word.charAt(i)!=wordMap.get(curr))
                    continue;
                }else if(!wordMap.containsValue(word.charAt(i))){
                    wordMap.put(curr,word.charAt(i));
                }
                nWords.add(word);
            }
        }
    return nWords;
    }
}
