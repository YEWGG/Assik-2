import java.util.Comparator;
import java.util.Iterator;

public class MyArrayList<T extends Comparable<T>> implements MyList<T> {
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
    /*

     * This method add element in array list.

     * It uses another method and simple statements.

     * Time complexity: 0(1).

     * The algorithm just add new element in the array list.,

     * resulting in constant time complexity.

     *

     * @param item, it is the input number.

     * @return doesn't exist.

     */

    @Override
    public void set(int index, T item) {
        checkIndex(index);
        elements[index] = item;

    }
    /*

     * This method add element in array list.

     * It uses another method and simple statements.

     * Time complexity: 0(1).

     * The algorithm just add new element in the array list.,

     * resulting in constant time complexity.

     *

     * @param index, it is the input number.

     * @param item, it is the input number.

     * @return doesn't exist.

     */


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
    /*

     * This method add element in array list.

     * It uses another method and simple statements.

     * Time complexity: 0(1).

     * The algorithm just add new element in the array list.,

     * resulting in constant time complexity.

     *

     * @param index, it is the input number.

     * @param item, it is the input number.

     * @return doesn't exist.

     */

    @Override
    public void addFirst(T item) {
        increaseCapacity();
        for (int i = length; i > 0; i--) {
            elements[i] = elements[i - 1];
        }
        elements[0] = item;
        length++;
    }
    /*

     * This method add element on first position in array list.

     * It uses another method and simple statements.

     * Time complexity: 0(1).

     * The algorithm just add new element on first position in the array list.,

     * resulting in constant time complexity.

     *

     * @param item, it is the input number.

     * @return doesn't exist.

     */

    @Override
    public void addLast(T item) {
        increaseCapacity();
        elements[length] = item;
        length++;

    }
    /*

     * This method add element on last position in array list.

     * It uses another method and simple statements.

     * Time complexity: 0(1).

     * The algorithm just add new element on last position in the array list.,

     * resulting in constant time complexity.

     *

     * @param item, it is the input number.

     * @return doesn't exist.

     */


    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }
    /*

     * This method get element from array list.

     * It uses another method and simple statements.

     * Time complexity: 0(1).

     * The algorithm just get new element from the array list.,

     * resulting in constant time complexity.

     *

     * @param index, it is the input number.

     * @return doesn't exist.

     */

    @Override
    public T getFirst() {
        if (length == 0) {
            return null;
        }
        return (T) elements[0];
    }
    /*

     * This method get first element from array list.

     * It uses another method and simple statements.

     * Time complexity: 0(1).

     * The algorithm just get new element from the array list.,

     * resulting in constant time complexity.

     *

     * @param index, it is the input number.

     * @return doesn't exist.

     */

    @Override
    public T getLast() {
        if (length == 0) {
            return null;
        }
        return (T) elements[length - 1];
    }
    /*

     * This method get last element from array list.

     * It uses another method and simple statements.

     * Time complexity: 0(1).

     * The algorithm just get new element from the array list.,

     * resulting in constant time complexity.

     *

     * @param index, it is the input number.

     * @return doesn't exist.

     */

    @Override
    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < length - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[length - 1] = null;
        length--;
    }
    /*

     * This method remove element from array list.

     * It uses another method and simple statements.

     * Time complexity: 0(1).

     * The algorithm just remove new element from the array list.,

     * resulting in constant time complexity.

     *

     * @param index, it is the input number.

     * @return doesn't exist.

     */

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
    /*

     * This method remove first element from array list.

     * It uses another method and simple statements.

     * Time complexity: 0(1).

     * The algorithm just remove new element from the array list.,

     * resulting in constant time complexity.

     *

     * @param index, it is the input number.

     * @return doesn't exist.

     */

    @Override
    public void removeLast() {
        if (length == 0) {
            return;
        }
        elements[length - 1] = null;
        length--;
    }
    /*

     * This method remove last element from array list.

     * It uses another method and simple statements.

     * Time complexity: 0(1).

     * The algorithm just remove new element from the array list.,

     * resulting in constant time complexity.

     *

     * @param index, it is the input number.

     * @return doesn't exist.

     */

    @Override
    public void sort(Comparator<T> cmp) {
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (cmp.compare((T) elements[j], (T) elements[j + 1]) > 0) {
                    Object temp = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = temp;
                }
            }
        }
    }
    /*

     * This method sort array list.

     * It uses another method and simple statements.

     * Time complexity: 0(1).

     * The algorithm just sort new element from the array list.,

     * resulting in constant time complexity.

     *

     * @param index, it is the input number.

     * @return doesn't exist.

     */

    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < length; i++) {
            if (elements[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }
    /*

     * This method get index of element from array list.

     * It uses another method and simple statements.

     * Time complexity: 0(1).

     * The algorithm just get new element from the array list.,

     * resulting in constant time complexity.

     *

     * @param index, it is the input number.

     * @return doesn't exist.

     */

    @Override
    public int lastIndexOf(Object object) {
        for (int i = length - 1; i >= 0; i--) {
            if (elements[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }
    /*

     * This method get last index of element from array list.

     * It uses another method and simple statements.

     * Time complexity: 0(1).

     * The algorithm just get new element from the array list.,

     * resulting in constant time complexity.

     *

     * @param index, it is the input number.

     * @return doesn't exist.

     */

    @Override
    public boolean exists(Object object) {
        for (int i = 0; i < length; i++) {
            if (elements[i].equals(object)) {
                return true;
            }
        }
        return false;
    }
    /*

     * This method check if element exists in array list.

     * It uses another method and simple statements.

     * Time complexity: 0(1).

     * The algorithm just check new element from the array list.,

     * resulting in constant time complexity.

     *

     * @param index, it is the input number.

     * @return doesn't exist.

     */

    @Override
    public Object[] toArray() {
        Object[] array = new Object[length];
        for (int i = 0; i < length; i++) {
            array[i] = elements[i];
        }
        return array;
    }
    /*

     * This method convert object to array.

     * It uses another method and simple statements.

     * Time complexity: 0(1).

     * The algorithm just convert new element from the array list.,

     * resulting in constant time complexity.

     *

     * @param index, it is the input number.

     * @return doesn't exist.

     */

    @Override
    public void clear() {
        for (int i = 0; i < length; i++) {
            elements[i] = null;
        }
        length = 0;
    }
    /*

     * This method clear array list.

     * It uses another method and simple statements.

     * Time complexity: 0(1).

     * The algorithm just clear new element from the array list.,

     * resulting in constant time complexity.

     *

     * @param index, it is the input number.

     * @return doesn't exist.

     */

    @Override
    public int size() {
        return length;
    }
    /*

     * This method get size of array list.

     * It uses another method and simple statements.

     * Time complexity: 0(1).

     * The algorithm just get new element from the array list.,

     * resulting in constant time complexity.

     *

     * @param index, it is the input number.

     * @return doesn't exist.

     */

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
    /*

     * This method get iterator of array list.

     * It uses another method and simple statements.

     * Time complexity: 0(1).

     * The algorithm just get new element from the array list.,

     * resulting in constant time complexity.

     *

     * @param index, it is the input number.

     * @return doesn't exist.

     */
    private void increaseCapacity() {
        if (length == elements.length) {
            Object[] newElements = new Object[elements.length * 2];
            for (int i = 0; i < elements.length; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
        }
    }
    /*

     * This method increase capacity of array list.

     * It uses another method and simple statements.

     * Time complexity: 0(1).

     * The algorithm just increase new element from the array list.,

     * resulting in constant time complexity.

     *

     * @param index, it is the input number.

     * @return doesn't exist.

     */
    private void checkIndex(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Index: " + index + " not found");
        }
    }
    /*

     * This method check index of array list.

     * It uses another method and simple statements.

     * Time complexity: 0(1).

     * The algorithm just check new element from the array list.,

     * resulting in constant time complexity.

     *

     * @param index, it is the input number.

     * @return doesn't exist.

     */

}





