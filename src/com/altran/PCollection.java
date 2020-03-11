package com.altran;

import java.util.*;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public interface PCollection<E> extends Iterable<E> {
    int size();

    boolean isEmpty();

    boolean contains(Object var1);

    Iterator<E> iterator();

    Object[] toArray();

    <T> T[] toArray(T[] var1);

    default <T> T[] toArray(IntFunction<T[]> generator) {
        return this.toArray((T[])generator.apply(0));
    }

    boolean add(E var1);

    boolean remove(Object var1);

    boolean containsAll(PCollection<? extends E> var1);

    boolean addAll(PCollection<? extends E> var1);

    boolean removeAll(PCollection<? extends E> var1);

    default boolean removeIf(Predicate<? super E> filter) {
        Objects.requireNonNull(filter);
        boolean removed = false;
        Iterator<E> each = this.iterator();

        while(each.hasNext()) {
            if (filter.test(each.next())) {
                each.remove();
                removed = true;
            }
        }

        return removed;
    }

    boolean retainAll(PCollection<? extends E> var1);

    void clear();

    boolean equals(Object var1);

    int hashCode();

   // default Spliterator<E> spliterator() {
        //return Spliterators.spliterator(this, 0);
    //}

    default Stream<E> stream() {
        return StreamSupport.stream(this.spliterator(), false);
    }

    default Stream<E> parallelStream() {
        return StreamSupport.stream(this.spliterator(), true);
    }
}
