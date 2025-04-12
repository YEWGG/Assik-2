import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {
    private Object[] elements;
    private int length;

    public MyArrayList() {
        elements = new Object[5];
        length = 0;
    }

    @Override
    public void add(T item){
        increaseCapacity();
        elements[length] = item;
        length++;
    }

    @Override
    public void set(int index, T item) {
        checkIndex(index);
        elements[index] = item;

    }

    @Override
    public void add(int index, T item) {
        checkIndex(index);
        increaseCapacity();
        for (int i = length; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = item;
        length++;

    }

    @Override
    public void addFirst(T item) {
        increaseCapacity();
        for (int i = length; i > 0; i--) {
            elements[i] = elements[i - 1];
        }
        elements[0] = item;
        length++;
    }

    @Override
    public void addLast(T item) {
        increaseCapacity();
        elements[length] = item;
        length++;

    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }

    @Override
    public T getFirst() {
        if (length == 0) {
            return null;
        }
        return (T) elements[0];
    }

    @Override
    public T getLast() {
        if (length == 0) {
            return null;
        }
        return (T) elements[length - 1];
    }
    @Override
    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < length - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[length - 1] = null;
        length--;
    }

    @Override
    public void removeFirst() {
        if (length == 0) {
            return;
        }
        for (int i = 0; i < length - 1; i++) {
            elements[i] = elements[i + 1];
        }
        length--;
    }

    @Override
    public void removeLast() {
        if (length == 0) {
            return;
        }
        elements[length - 1] = null;
        length--;
    }

    @Override
    public void sort() {
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (((Comparable) elements[j]).compareTo(elements[j + 1]) > 0) {
                    Object temp = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = temp;
                }
            }
        }

    }

    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < length; i++) {
            if (elements[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        for (int i = length - 1; i >= 0; i--) {
            if (elements[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        for (int i = 0; i < length; i++) {
            if (elements[i].equals(object)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[length];
        for (int i = 0; i < length; i++) {
            array[i] = elements[i];
        }
        return array;
    }

    @Override
    public void clear() {
        for (int i = 0; i < length; i++) {
            elements[i] = null;
        }
        length = 0;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < length;
            }

            @Override
            public T next() {
                return (T) elements[currentIndex++];
            }
        };
    }
    private void increaseCapacity() {
        if (length == elements.length) {
            Object[] newElements = new Object[elements.length * 2];
            for (int i = 0; i < elements.length; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
        }
    }
    private void checkIndex(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Index: " + index + " not found");
        }
    }
}





