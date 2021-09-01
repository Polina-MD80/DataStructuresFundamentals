package interfaces;

public interface ReversedList<E> extends Iterable<E> {
    void add(E element);

    int capacity();

    int size();

    E get(int index);

    E removeAt(int index);

}
