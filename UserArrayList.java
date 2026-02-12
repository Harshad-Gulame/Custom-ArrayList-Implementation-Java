import java.util.Iterator;
import java.util.NoSuchElementException;

public class UserArrayList<E> implements Iterable<E> {

    private Object[] elementData;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    // Constructor
    public UserArrayList() {
        elementData = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    // Add element
    public void add(E element) {
        ensureCapacity();
        elementData[size++] = element;
    }

    // Add at specific index
    public void add(int index, E element) {
        checkPositionIndex(index);
        ensureCapacity();

        for (int i = size; i > index; i--) {
            elementData[i] = elementData[i - 1];
        }

        elementData[index] = element;
        size++;
    }

    // Get element
    public E get(int index) {
        checkElementIndex(index);
        return (E) elementData[index];
    }

    // Set element
    public E set(int index, E element) {
        checkElementIndex(index);
        E oldValue = (E) elementData[index];
        elementData[index] = element;
        return oldValue;
    }

    // Remove by index
    public E remove(int index) {
        checkElementIndex(index);

        E removed = (E) elementData[index];

        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }

        elementData[--size] = null;
        return removed;
    }

    // Remove by object
    public boolean remove(Object obj) {
        int index = indexOf(obj);
        if (index >= 0) {
            remove(index);
            return true;
        }
        return false;
    }

    // indexOf
    public int indexOf(Object obj) {
        if (obj == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null)
                    return i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (obj.equals(elementData[i]))
                    return i;
            }
        }
        return -1;
    }

    // contains
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    // size
    public int size() {
        return size;
    }

    // isEmpty
    public boolean isEmpty() {
        return size == 0;
    }

    // clear
    public void clear() {
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
        size = 0;
    }

    // Ensure capacity (resize)
    private void ensureCapacity() {
        if (size == elementData.length) {
            Object[] newArray = new Object[elementData.length * 2];
            for (int i = 0; i < elementData.length; i++) {
                newArray[i] = elementData[i];
            }
            elementData = newArray;
        }
    }

    // Index validation
    private void checkElementIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index);
    }

    private void checkPositionIndex(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index: " + index);
    }

    // toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < size; i++) {
            sb.append(elementData[i]);
            if (i < size - 1)
                sb.append(", ");
        }

        sb.append("]");
        return sb.toString();
    }

    // Iterator implementation
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private int cursor = 0;

            @Override
            public boolean hasNext() {
                return cursor < size;
            }

            @Override
            public E next() {
                if (!hasNext())
                    throw new NoSuchElementException();
                return (E) elementData[cursor++];
            }
        };
    }
}



