package com.aditya.files.other;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Twitter {


    public boolean checkPrime(int n) {

        //check if n is a multiple of 2
        if (n % 2 == 0) return false;
        //if not, then just check the odds

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;

    }

    public List<Integer>[] buildGraph(int n, int[] first, int[] second) {

        List<Integer>[] g = new ArrayList[n + 1];

        for (int p = 0; p < g.length; p++)
            g[p] = new ArrayList<>();

        for (int i = 0; i < first.length; i++) {
            g[first[i]].add(second[i]);
        }

        return g;
    }

    public int returnPrime(int numofvertices, List<Integer>[] g, int[] values, int s) {
        int counter = 0;
        boolean visited[] = new boolean[numofvertices];

        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            s = queue.poll();
            System.out.print(s + " ");

            Iterator<Integer> i = g[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    if (checkPrime(n) == true)
                        counter++;
                    queue.add(n);
                }
            }
        }


        return counter;
    }

    public int[] primeQuery(int n, int[] first, int[] second, int[] values, int[] queries) {

        int[] result = new int[queries.length];
        List<Integer>[] g = buildGraph(n, first, second);

        for (int i = 0; i < queries.length; i++) {
            result[i] = returnPrime(n, g, values, queries[i]);
        }


        return result;
    }


}
