package com.altran.pList;

import com.altran.PCollection;

import java.io.Serializable;
import java.util.*;

public class PArrayList<E> implements PList<E>, Cloneable, Serializable {
    private int HEAD = -1;
    private Object arr[];
    private static final int DEFAULT_SIZE = 10;

    public PArrayList() {
        this(DEFAULT_SIZE);
    }

    public PArrayList(int capacity) {
        arr = new Object[capacity];
    }

    public PArrayList(PCollection<E> list) {
        arr = new Object[DEFAULT_SIZE];
        for (E e : list) {
            checkAndIncreaseSize();
            arr[++HEAD] = e;
        }
    }


    @Override
    public boolean remove(Object var1) {
        for (int i = 0; i < size(); i++) {
            if (get(i) == var1) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(PCollection<? extends E> var1) {
        for (E e : var1) {
            if (!contains(e)) {
                return false;
            }
        }
        return true;
    }


    @Override
    public boolean removeAll(PCollection<? extends E> var1) {
        boolean result = false;
        for (E e : var1) {
            if (contains(e)) {
                result = remove(e);
            }
        }
        return result;
    }

    @Override
    public boolean retainAll(PCollection<? extends E> var1) {
        return false;
    }

    public boolean add(E e) {
        checkAndIncreaseSize();
        arr[++HEAD] = e;
        return true;
    }

    @Override
    public boolean addAll(PCollection<? extends E> e) {
        boolean result = false;
        for (E value : e) {
            result = add(value);
        }
        return result;
    }

    @Override
    public boolean addAll(int var1, PCollection<? extends E> var2) {
        return false;
    }

    @Override
    public void clear() {

    }

    public void add(int index, E element) {
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


    public E remove(int pos) throws ArrayIndexOutOfBoundsException {
        checkInavlidPosition(pos);
        E e = null;
        if (HEAD != 0 || HEAD != pos) {
            e = (E) arr[pos];
            System.arraycopy(arr, pos + 1, arr, pos, (arr.length - pos - 1));
        }
        arr[HEAD] = null;
        HEAD--;
        return e;
    }

    @Override
    public int indexOf(Object var1) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object var1) {
        return 0;
    }

    @Override
    public java.util.ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public java.util.ListIterator<E> listIterator(int var1) {
        return null;
    }

    @Override
    public PList<E> subList(int var1, int var2) {
        return null;
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

    @Override
    public E set(int var1, E var2) {
        return null;
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

    public boolean contains(Object e) {
        for (int i = 0; i <= HEAD; i++) {
            if (arr[i] == e) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new ListIterator<>();
    }

    @Override
    public E[] toArray() {
        return null;
    }

    @Override
    public <T> T[] toArray(T[] var1) {
        return null;
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
            PArrayList.this.remove(index);
        }
    }
}
