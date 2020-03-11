package com.altran.pList;

import com.altran.PCollection;

import java.util.*;
import java.util.function.UnaryOperator;

public interface PList<E> extends PCollection<E>  {
    int size();

    boolean isEmpty();

    boolean contains(Object var1);

    Iterator<E> iterator();

    E[] toArray();

    <T> T[] toArray(T[] var1);

    boolean add(E var1);

    boolean remove(Object var1);

    boolean containsAll(PCollection<? extends E> var1);

    boolean addAll(PCollection<? extends E> var1);

    boolean addAll(int var1, PCollection<? extends E> var2);

    boolean removeAll(PCollection<? extends E> var1);

    boolean retainAll(PCollection<? extends E> var1);

    default void replaceAll(UnaryOperator<E> operator) {
        Objects.requireNonNull(operator);
        ListIterator<E> li = this.listIterator();

        while(li.hasNext()) {
            li.set(operator.apply(li.next()));
        }

    }

    default void sort(Comparator<? super E> c) {
        E[] a = this.toArray();
        Arrays.sort(a, c);
        ListIterator<E> i = this.listIterator();
        E[] var4 = a;
        int var5 = a.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            E e = var4[var6];
            i.next();
            i.set(e);
        }

    }

    void clear();

    boolean equals(Object var1);

    int hashCode();

    E get(int var1);

    E set(int var1, E var2);

    void add(int var1, E var2);

    E remove(int var1);

    int indexOf(Object var1);

    int lastIndexOf(Object var1);

    ListIterator<E> listIterator();

    ListIterator<E> listIterator(int var1);

    PList<E> subList(int var1, int var2);
}
