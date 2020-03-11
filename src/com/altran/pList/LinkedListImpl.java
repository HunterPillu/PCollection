package com.altran.pList;

import java.util.Iterator;

public class LinkedListImpl {
    PLinkedList<Integer> pl;

    public void main() {
        pl = new PLinkedList<>();
        pl.add(1);
        pl.add(2);
        pl.add(3);
        pl.add(4);
        pl.add(5);
        pl.add(6);
        pl.add(7);
        pl.add(8);
        pl.add(9);

        System.out.println(pl.toString());
        Iterator<Integer> itr = pl.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        for (Integer nn : pl) {
            System.out.print(nn);
        }
        findMiddle();
    }


    public void findMiddle() {
        Iterator<Integer> itr = pl.iterator();
        PLinkedList.Node<Integer> fastPtr = pl.getFirstNode();
        PLinkedList.Node<Integer> slowPtr = pl.getFirstNode();
        int index = 0;
        while (fastPtr != null && fastPtr.next != null) {
            //System.out.println(itr.next());
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            index++;
        }
        System.out.println("\n" + slowPtr.item + " is at middle value on index" + index);
    }
}
