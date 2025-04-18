import java.util.NoSuchElementException;

public class MyStack<T extends Comparable<T>> {
    private MyArrayList<T> data = new MyArrayList<>();


    public void push(T element) {
        data.add(element);
    }
    /*
     * Pushes an element onto the top of this stack.
     *
     * Time complexity: O(1) amortized
     * Space complexity: O(1) (plus one slot in the backing array if resize is needed)
     *
     * @param element the element to push
     */


    public T pop() {
        if (data.isEmpty()) throw new NoSuchElementException();
        int lastIdx = data.size() - 1;
        T value = data.get(lastIdx);
        data.remove(lastIdx);
        return value;
    }
    /*
     * Removes and returns the element at the top of this stack.
     *
     * Time complexity: O(1)
     * Space complexity: O(1)
     *
     * @return the element removed from the top
     * @throws NoSuchElementException if the stack is empty
     */


    public T peek() {
        if (data.isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return data.get(data.size() - 1);
    }
    /*
     * Retrieves, but does not remove, the element at the top of this stack.
     *
     * Time complexity: O(1)
     * Space complexity: O(1)
     *
     * @return the element at the top
     * @throws NoSuchElementException if the stack is empty
     */


    public boolean isEmpty() {
        return data.isEmpty();
    }
    /*
     * Tests if this stack contains no elements.
     *
     * Time complexity: O(1)
     * Space complexity: O(1)
     *
     * @return true if this stack is empty; false otherwise
     */

}
