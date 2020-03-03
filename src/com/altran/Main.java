package com.altran;

import com.google.gson.Gson;

public class Main {

    public static void main(String[] args) {
        // write your code here

        PArrayList<Integer> pal = new PArrayList<>();
        pal.add(1);
        pal.add(2);
        pal.add(3);
        pal.add(4);
        pal.add(5);
        pal.add(6);
        pal.add(7);
        pal.add(8);
        pal.add(9);
        pal.add(10);
        System.out.println(pal.toString());
        pal.remove(9);
        System.out.println(pal.toString());
    }
}
