package com.altran;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // write your code here
        PArrayList<Integer> pArrayList = new PArrayList<Integer>();
        for (int i = 0; i < 12; i++) {
            pArrayList.add(i);
        }
        System.out.println(pArrayList.toString());

        // pArrayList.remove(5);
        // System.out.println(pArrayList.toString());

        pArrayList.remove(-2);

        for (int i = 0; i < 12; i++) {

            pArrayList.remove(pArrayList.getSize() - 1);
            System.out.println(pArrayList.toString());
        }
    }
}
