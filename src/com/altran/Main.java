package com.altran;

import com.altran.pList.ArrayListImpl;
import com.altran.pList.LinkedListImpl;
import com.altran.pList.PArrayList;

import java.util.Iterator;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        // write your code here
        new ArrayListImpl().main();
        new LinkedListImpl().main();

        /*LinkedList<Integer> pl = new LinkedList<>();
        pl.add(1);
        pl.add(2);
        pl.add(3);
        pl.add(4);
        pl.add(5);
        pl.add(6);

        Iterator<Integer> itr = pl.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        for (Integer node : pl) {
            System.out.println(node);
        }*/
    }
}
