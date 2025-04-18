import java.util.NoSuchElementException;

public class MyQueue<T extends Comparable<T>> {
    private MyLinkedList<T> data = new MyLinkedList<>();

    public void enqueue(T element) {
        data.addLast(element);
    }
    /*
     * Inserts the specified element into this queue.
     *
     * Time complexity: O(1)
     * Space complexity: O(1)
     *
     * @param element the element to add
     */

    public T dequeue() {
        if (data.isEmpty()) throw new NoSuchElementException("Queue is empty");
        T value = data.getFirst();
        data.removeFirst();
        return value;
    }
    /*
     * Retrieves and removes the head of this queue.
     *
     * Time complexity: O(1)
     * Space complexity: O(1)
     *
     * @return the element at the head
     * @throws NoSuchElementException if this queue is empty
     */

    public T peek() {
        if (data.isEmpty()) throw new NoSuchElementException();
        return data.getFirst();
    }
    /*
     * Retrieves, but does not remove, the head of this queue.
     *
     * Time complexity: O(1)
     * Space complexity: O(1)
     *
     * @return the element at the head
     * @throws NoSuchElementException if this queue is empty
     */

    public boolean isEmpty() {
        return data.isEmpty();
    }
    /*
     * Tests if this queue contains no elements.
     *
     * Time complexity: O(1)
     * Space complexity: O(1)
     *
     * @return true if this queue is empty; false otherwise
     */
}