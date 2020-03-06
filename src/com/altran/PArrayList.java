package com.altran;

import java.util.*;
import java.util.function.Consumer;

public class PArrayList<E> implements Iterable<E> {
    private int HEAD = -1;
    private Object arr[];
    private static final int DEFAULT_SIZE = 10;

    public PArrayList() {
        this(DEFAULT_SIZE);
    }

    public PArrayList(int capacity) {
        arr = new Object[capacity];
    }

    public PArrayList(PArrayList<? extends E> list) {
        arr = new Object[DEFAULT_SIZE];
        for (int i = 0; i < list.size(); i++) {
            checkAndIncreaseSize();
            arr[i] = list.get(i);
        }
        HEAD = list.size() - 1;
    }

    public void add(E e) {
        checkAndIncreaseSize();
        HEAD++;
        arr[HEAD] = e;
    }

    public void addAll(Iterable<? extends E> e) {
        checkAndIncreaseSize();
        HEAD++;
        arr[HEAD] = e;
        Iterator<? extends E> iterator = e.iterator();

        while (iterator.hasNext()) {
            toString();
            add(iterator.next());

        }
    }

    void add(int index, E element) {
        checkAndIncreaseSize();
        System.arraycopy(arr, index, arr, index + 1, HEAD - index + 1);
        arr[index] = element;
        HEAD++;

    }

    private void checkAndIncreaseSize() {
        if (HEAD == arr.length - 1) {
            //right shift operator which means half of the value 6>>1 means 3
            int newLength = arr.length + (arr.length >> 1);
            arr = Arrays.copyOf(arr, newLength);
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

    public E get(int pos) {
        checkInavlidPosition(pos);
        return (E) arr[pos];
    }

    public int size() {
        return HEAD + 1;
    }

    public boolean isEmpty() {
        return size() > 0;
    }

    @Override
    public String toString() {
        return "PArrayList{" +
                "HEAD=" + HEAD +
                ", arr=" + Arrays.toString(arr) +
                '}';
    }

    @Override
    public Iterator<E> iterator() {
        return new ListIterator<>();
    }

    class ListIterator<E> implements Iterator<E> {
        int index = 0;

        @Override
        public boolean hasNext() {
            return index != PArrayList.this.size();
        }

        @Override
        public E next() {
            return (E) PArrayList.this.get(index++);
        }

        @Override
        public void remove() {

        }
    }
}
