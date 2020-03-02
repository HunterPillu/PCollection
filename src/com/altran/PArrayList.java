package com.altran;

public class PArrayList<T> {

    private int HEAD = -1;
    private Object arr[];

    public PArrayList() {
        arr = new Object[10];
    }

    public void add(T e) {
        HEAD++;
        arr[HEAD] = e;
    }

    public void remove(int pos) throws ArrayIndexOutOfBoundsException {
        if (pos >= arr.length) {
            throw new ArrayIndexOutOfBoundsException(pos);
        }


    }

}
