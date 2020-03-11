package com.altran.pList;

import com.altran.PCollection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.NoSuchElementException;


public class PLinkedList<E> implements PList<E> {

    int size;
    PLinkedList.Node<E> first;

    public PLinkedList() {
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object var1) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return listIterator();
    }

    @Override
    public E[] toArray() {
        return null;
    }

    @Override
    public <T> T[] toArray(T[] var1) {
        return null;
    }

    @Override
    public boolean add(E var1) {
        if (null != first) {
            getLastNode().next = new PLinkedList.Node<E>(var1);
        } else {
            first = new PLinkedList.Node<E>(var1);
        }
        return true;
    }

    public E getFirst() {
        if (null != first) {
            return first.item;
        } else return null;
    }

    public Node<E> getFirstNode() {
        if (null != first) {
            return first;
        } else return null;
    }

    public Node<E> getLastNode() {
        Node<E> item = getFirstNode();
        if (null != item) {
            while (item.next != null) {
                item = item.next;
            }
        }
        return item;
    }

    @Override
    public boolean remove(Object var1) {
        return false;
    }

    @Override
    public boolean containsAll(PCollection<? extends E> var1) {
        return false;
    }

    @Override
    public boolean addAll(PCollection<? extends E> var1) {
        return false;
    }

    @Override
    public boolean addAll(int var1, PCollection<? extends E> var2) {
        return false;
    }

    @Override
    public boolean removeAll(PCollection<? extends E> var1) {
        return false;
    }

    @Override
    public boolean retainAll(PCollection<? extends E> var1) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public E get(int var1) {
        return null;
    }

    @Override
    public E set(int var1, E var2) {
        return null;
    }

    @Override
    public void add(int var1, E var2) {

    }

    @Override
    public E remove(int var1) {
        return null;
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
    public PListIterator<E> listIterator() {
        return new ListItr();
    }

    @Override
    public PListIterator<E> listIterator(int var1) {
        return new ListItr();
    }

    @Override
    public PList<E> subList(int var1, int var2) {
        return null;
    }

    class ListItr implements PListIterator<E> {
        int index;
        PLinkedList.Node<E> lastReturned;
        PLinkedList.Node<E> next;

        public ListItr() {
            this.index = 0;
            lastReturned = null;
            next = PLinkedList.this.first;
        }

        @Override
        public boolean hasNext() {
            //return index != PLinkedList.this.size();
            return null != next;
        }

        @Override
        public E next() {
            lastReturned = next;
            next = next.next;
            return (E) lastReturned.item;
        }

        @Override
        public boolean hasPrevious() {
            return false;
        }

        @Override
        public E previous() {
            return null;
        }

        @Override
        public int nextIndex() {
            return 0;
        }

        @Override
        public int previousIndex() {
            return 0;
        }

        @Override
        public void remove() {
            PLinkedList.this.remove(index);
        }

        @Override
        public void set(E e) {

        }

        @Override
        public void add(E e) {

        }
    }


    public static class Node<E> {
        E item;
        PLinkedList.Node<E> next;

        public Node(E e, Node<E> next) {
            this.item = e;
            this.next = next;
        }

        public Node(E e) {
            this.item = e;
            this.next = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "e=" + item +
                    ", next=" + next +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "PLinkedList{" +
                "size=" + size +
                ", first=" + first.toString() +
                '}';
    }
}
