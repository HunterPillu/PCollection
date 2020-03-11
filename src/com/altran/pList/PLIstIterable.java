package com.altran.pList;

import java.util.Iterator;

public class PLIstIterable<E> implements Iterable<E> {
    @Override
    public Iterator<E> iterator() {
        return new PLIstIterable.ListIterator();
    }

    class ListIterator<E> implements Iterator<E> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public E next() {
            return null;
        }

        @Override
        public void remove() {

        }
    }
}
