import java.util.NoSuchElementException;

public class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> heap = new MyArrayList<>();

    private int parent(int i) { return (i - 1) / 2; }
    private int left(int i)   { return 2*i + 1; }
    private int right(int i)  { return 2*i + 2; }

    public void insert(T element) {
        heap.add(element);
        siftUp(heap.size() - 1);
    }
    /*
     * Inserts the specified element into this heap.
     *
     * Time complexity: O(log n)
     * Space complexity: O(1)
     *
     * @param element the element to add
     */

    public T removeMin() {
        if (heap.isEmpty()) throw new NoSuchElementException("Heap is empty");
        T min = heap.get(0);
        int lastIdx = heap.size() - 1;
        T last = heap.get(lastIdx);
        heap.remove(lastIdx);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            siftDown(0);
        }
        return min;
    }
    /*
     * Retrieves and removes the minimum element from this heap.
     *
     * Time complexity: O(log n)
     * Space complexity: O(1)
     *
     * @return the minimum element
     * @throws NoSuchElementException if this heap is empty
     */

    public T peekMin() {
        if (heap.isEmpty()) throw new NoSuchElementException();
        return heap.get(0);
    }
    /*
     * Retrieves, but does not remove, the minimum element from this heap.
     *
     * Time complexity: O(1)
     * Space complexity: O(1)
     *
     * @return the minimum element
     * @throws NoSuchElementException if this heap is empty
     */

    private void siftUp(int i) {
        while (i > 0 && heap.get(i).compareTo(heap.get(parent(i))) < 0) {
            swap(i, parent(i));
            i = parent(i);
        }
    }
    /*
     * Moves the element at index i up the heap until the heap property is restored.
     *
     * Time complexity: O(log n)
     * Space complexity: O(1)
     *
     * @param i the index of the element to move up
     */

    private void siftDown(int i) {
        int smallest = i;
        int l = left(i), r = right(i);
        if (l < heap.size() && heap.get(l).compareTo(heap.get(smallest)) < 0)
            smallest = l;
        if (r < heap.size() && heap.get(r).compareTo(heap.get(smallest)) < 0)
            smallest = r;
        if (smallest != i) {
            swap(i, smallest);
            siftDown(smallest);
        }
    }
    /*
     * Moves the element at index i down the heap until the heap property is restored.
     *
     * Time complexity: O(log n)
     * Space complexity: O(1)
     *
     * @param i the index of the element to move down
     */

    private void swap(int i, int j) {
        T tmp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, tmp);
    }
    /*
     * Swaps the elements at indices i and j.
     *
     * Time complexity: O(1)
     * Space complexity: O(1)
     *
     * @param i the index of the first element
     * @param j the index of the second element
     */

    public boolean isEmpty() {
        return heap.isEmpty();
    }
    /*
     * Tests if this heap contains no elements.
     *
     * Time complexity: O(1)
     * Space complexity: O(1)
     *
     * @return true if this heap is empty; false otherwise
     */
}
