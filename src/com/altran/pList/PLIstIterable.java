package com.altran.pList;

import java.util.Iterator;
import java.util.function.Consumer;

public interface PListIterator<E> extends Iterator<E> {
    boolean hasNext();

    E next();

    void remove();

    boolean hasPrevious();

    E previous();

    int nextIndex();

    int previousIndex();

    void set(E var1);

    void add(E var1);

}
