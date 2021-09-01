package implementations;

import interfaces.Deque;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayDeque<E> implements Deque<E> {

    private final int DEFAULT_CAPACITY = 7;
    private int head;
    private int tail;
    private int size;

    private Object[] elements;

    public ArrayDeque() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.head = this.elements.length / 2;
        this.tail = this.head;

    }

    @Override
    public void add(E Element) {
        this.addLast(Element);
    }

    @Override
    public void offer(E element) {
        this.addLast(element);
    }

    @Override
    public void addFirst(E element) {
        if (this.size == 0) {
            elements[this.head] = element;
            size++;
            return;
        } else if (this.head == 0) {
            this.grow();
        }
        this.elements[--this.head] = element;
        size++;
    }


    private void grow() {
        Object[] newElements = new Object[elements.length * 2];
        int startIndex = newElements.length / 2 - this.size / 2;
        for (int i = startIndex; i < startIndex + this.size; i++) {
            newElements[i] = elements[this.head++];
        }
        this.head = startIndex;
        this.tail = this.head + this.size - 1;
        this.elements = newElements;

    }

    @Override
    public void addLast(E element) {
        if (this.size == 0) {
            elements[this.tail] = element;
            size++;
            return;
        } else if (this.tail == elements.length - 1) {
            this.grow();
        }
        this.elements[++this.tail] = element;
        size++;
    }

    @Override
    public void push(E element) {
        this.addFirst(element);

    }

    @Override
    public void insert(int index, E element) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException(index);
        }

        E e = this.get(this.size - 1);
        this.addLast(e);
        for (int i = tail - 1; i > this.head + index; i--) {
            this.elements[i] = this.elements[i - 1];
        }
        this.elements[this.head + index] = element;
    }


    @Override
    public void set(int index, E element) {
        if (index < 0 || index > this.size - 1) {
            throw new IndexOutOfBoundsException(index);
        }

        this.elements[this.head + index] = element;


    }

    @Override
    public E peek() {
        if (size == 0) {
            return null;
        }
        return (E) elements[this.head];
    }

    @Override
    public E poll() {
       return this.removeFirst();
    }

    @Override
    public E pop() {
        return this.removeFirst();
    }

    @Override
    public E get(int index) {
        if (index < 0 || index > this.size - 1) {
            throw new IndexOutOfBoundsException(index);
        }
        return (E) this.elements[this.head + index];
    }

    @Override
    public E get(Object object) {
        for (int i = this.head; i <= this.tail; i++) {
            if (this.elements[i].equals(object)) {
                return (E) elements[i];
            }
        }
        return null;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index > this.size - 1) {
            throw new IndexOutOfBoundsException(index);
        }
        if (index == 0) {
            return this.removeFirst();
        }
        if (index == this.size - 1) {
            return removeLast();
        }
        E element = this.get(index);
        for (int i = this.head + index; i < this.tail; i++) {
            this.elements[i] = this.elements[i + 1];

        }
        this.removeLast();
        return element;
    }

    @Override
    public E remove(Object object) {
        if (size == 0) {
            return null;
        }

        for (int i = this.head; i <= this.tail; i++) {
            if (this.elements[i].equals(object)) {
                return this.remove(i - this.head);
            }
        }

        return null;
    }

    @Override
    public E removeFirst() {
        if (size == 0) {
            return null;
        }
        E element = (E) elements[this.head];
        elements[this.head++] = null;
        size--;
        return element;
    }

    @Override
    public E removeLast() {
        if (size == 0) {
            return null;
        }
        E element = (E) this.elements[this.tail];
        this.elements[this.tail--] = null;
        size--;
        return element;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int capacity() {
        return elements.length;
    }

    @Override
    public void trimToSize() {
        Object[] newElements = new Object[this.size];
        int j = 0;
        for (int i = this.head; i < this.head + size; i++) {
            newElements[j++] = this.elements[i];
        }
        this.elements = newElements;
        this.head = 0;
        this.tail = this.elements.length - 1;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = head;

            @Override
            public boolean hasNext() {
                return index > tail;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) elements[index++];
            }
        };
    }
}
