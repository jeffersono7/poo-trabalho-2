package br.edu.iesb.pea.utils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Group<T> implements Collection<T> {

    private static final int INITIAL_SIZE = 2;

    private Object[] group;
    private int index;

    public Group() {

        group = new Object[INITIAL_SIZE];
        index = 0;
    }

    @Override
    public synchronized boolean add(T t) {

        if (group.length - 1 < index) {

            group[index++] = t;
            return true;
        }

        increaseArr();

        group[index] = t;

        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {

        c.forEach(this::add);

        return true;
    }

    @Override
    public void clear() {

        group = new Object[INITIAL_SIZE];
    }

    @Override
    public boolean contains(Object o) {

        for (int i = 0; i < group.length; i++) {

            if (group[i].equals(o) && group[i].hashCode() == o.hashCode()) {
                return true;
            }

        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {

        long matchValues = c.stream()
                .filter(this::contains)
                .count();

        return matchValues == c.size();
    }

    @Override
    public boolean isEmpty() {

        return group.length == 0;
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public T next() {
                return null;
            }
        };
    }

    /**
     * <h3>Remove o objeto do Group</h3>
     * <p>Custo da operação O(n)</p>
     * @param o
     * @return
     */
    @Override
    public boolean remove(Object o) {

        boolean found = false;

        for (int i = 0; i < group.length; i++) {

            if (found) {
                group[i - 1] = group[i];
            }
            else if (group[i].equals(o) && group[i].hashCode() == o.hashCode()) {
                found = true;
                group[i] = null;
                index--;
            }
        }

        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {

        c.forEach(this::remove);

        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int size() {

        return group.length;
    }

    @Override
    public Object[] toArray() {

        return group.clone();
    }

    @Override
    public <T> T[] toArray(T[] a) {

        T[] arrParam = a.clone();

        int newSize = arrParam.length + group.length;

        T[] newArr = (T[]) new Object[newSize];

        int i = 0;

        for (int b = 0; b < group.length; b++) {
            newArr[i++] = (T) group[b];
        }

        for (int b = 0; b < arrParam.length; b++) {
            newArr[i++] = arrParam[b];
        }

        return newArr;
    }

    /**
     * Aumenta tamanho do array.
     */
    private void increaseArr() {

        Object[] oldArr = group;

        int newSize = (int) oldArr.length * 2;

        Object[] newArr = new Object[newSize];

        copyArrToGroup(newArr);
    }

    /**
     * Reduz o tamanho do array.
     */
    private void decreaseArr() {

        Object[] oldArr = group;

        int newSize = ((int) oldArr.length / 2) + 1;

        if (newSize < index + 1) {
            return;
        }

        Object[] newArr = new Object[newSize];

        copyArrToGroup(newArr);
    }

    /**
     * Copia todos os elementos de group para o novo array recebido por parâmetro;
     *
     * @param arr
     */
    private void copyArrToGroup(Object[] arr) {

        for (int i = 0; i < group.length; i++) {
            arr[i] = group[i];
        }

        group = arr;
    }
}
