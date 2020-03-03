package com.altran;

import java.util.ArrayList;
import java.util.Arrays;

public class PArrayList<E> {
    private int HEAD = -1;
    private Object arr[];

    public PArrayList() {
        arr = new Object[10];
    }

    public void add(E e) {
        checkAndIncreaseSize();
        HEAD++;
        arr[HEAD] = e;
    }

    private void checkAndIncreaseSize() {
        if (HEAD == arr.length - 1) {
            //right shift operator which means half of the value 6>>1 means 3
            int newLength = arr.length + (arr.length >> 1);
            arr = Arrays.copyOf(arr, newLength);
            System.out.println(Arrays.toString(arr));
        }
    }

    public void remove(int pos) throws ArrayIndexOutOfBoundsException {
        checkInavlidPosition(pos);

        if (HEAD != 0 || HEAD != pos) {
            System.arraycopy(arr, pos + 1, arr, pos, (arr.length - pos - 1));
        }
        arr[HEAD] = null;
        HEAD--;
    }

    private void checkInavlidPosition(int pos) {
        if (pos > HEAD || pos < 0) {
            throw new ArrayIndexOutOfBoundsException(pos);
        }
    }

    public E get(int pos){
        checkInavlidPosition(pos);
        return (E) arr[pos];
    }

    public int getSize() {
        return HEAD + 1;
    }

    @Override
    public String toString() {
        return "PArrayList{" +
                "HEAD=" + HEAD +
                ", arr=" + Arrays.toString(arr) +
                '}';
    }
}
