package com.aditya.files.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Paranthesis {
    static String[] braces(String[] values) {
        ArrayList<String> result = new ArrayList<>();
        if (values != null) {
            for (String value : values) {
                char[] stack = new char[value.length()];
                int p = -1;

                for (int i = 0; i < value.length(); i++) {
                    char ch = value.charAt(i);

                    if (ch == '(') {
                        stack[++p] = ')';
                    } else if (ch == '[') {
                        stack[++p] = ']';
                    } else if (ch == '{') {
                        stack[++p] = '}';
                    } else if (p >= 0) {
                        char top = stack[0];
                        if (top == ch) {
                            p--;
                        } else {
                            result.add("NO");
                        }
                    } else {
                        result.add("NO");
                    }
                }
                if (p < 0) {
                    result.add("YES");
                }

            }

        }
        return result.toArray(new String[0]);

    }

}
