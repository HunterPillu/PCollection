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

        //pArrayList.remove(-2);

        for (int i = 0; i < 12; i++) {

            pArrayList.remove(pArrayList.size() - 1);

        }
        System.out.println(pArrayList.toString());
        PArrayList<User> al = new PArrayList<>(10);
        al.add(new User("asdf", 45));
        al.add(new User("asdf", 47));
        //System.out.println(al.toString());



        al.add(0, new User("asdfae", 46));
        //System.out.println(al.toString());

        al.add(2, new User("asdfae", 48));
        //System.out.println(al.toString());

        al.add(3, new User("asdfae", 48));
        //System.out.println(al.toString());

        PArrayList<User> al2 = new PArrayList<>(al);
        //al2.addAll(al);
        System.out.println(al2.toString());
    }
}
