package com.altran;

import java.util.Arrays;

public class PArrayList<T> {

    private int HEAD = -1;
    private Object arr[];

    public PArrayList() {
        arr = new Object[10];
    }

    public void add(T e) {
        checkAndIncreaseSize();
        HEAD++;
        arr[HEAD] = e;
    }

    private void checkAndIncreaseSize() {
        if (HEAD == arr.length - 1) {
            Object[] arr2 = new Object[getNewSize()];
            for (int i = 0; i < arr.length; i++) {
                arr2[i] = arr[i];
            }
            arr = arr2;
        }
    }

    private int getNewSize() {
        return ((3 * arr.length) / 2) + 1;
    }

    private void checckInvalidPosition(int pos) throws ArrayIndexOutOfBoundsException {
        if (0 > pos && HEAD != -1 && pos > HEAD) {
            throw new ArrayIndexOutOfBoundsException(pos);
        }
    }

    public void remove(int pos) {
        checckInvalidPosition(pos);
        arr[pos] = null;
        if (pos != HEAD) {
            swapData(pos);
        }
        HEAD--;
    }

    public void swapData(int pos) {

        for (int i = pos; i < HEAD; i++) {
            arr[i] = arr[i + 1];
        }
        arr[HEAD] = null;
    }

    @Override
    public String toString() {
        return "PArrayList{" +
                "HEAD=" + HEAD +
                ", arr=" + Arrays.toString(arr) +
                '}';
    }
}
