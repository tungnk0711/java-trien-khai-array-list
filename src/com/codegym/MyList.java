package com.codegym;


import java.util.Arrays;


public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;

    //Constructs an empty list with an initial capacity of ten.
    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    //Constructs an empty list with the specified initial capacity.
    public MyList(int capacity) {
        elements = new Object[capacity];
    }

    //Inserts the specified element at the specified position in this list.
    public void add(int index, E element) {
        if (size == elements.length) {
            ensureCapacity();
        }
        for (int i = elements.length - 1; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    //Removes the element at the specified position in this list.
    public E remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index Out Of Bounds !");
        }

        for (int i = index; i < elements.length - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;

        return (E) elements[index];
    }

    //Returns the number of elements in this list.
    public int size() {
        return size;
    }

    //Returns a shallow copy of this ArrayList instance.

    //Returns true if this list contains the specified element.
    public boolean contains(E o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    //Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element.
    public int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }


    private void ensureCapacity() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

}
