import java.util.Comparator;
import java.util.Iterator;

public class MyLinkedList<T extends Comparable<T>> implements MyList<T>{
    private MyNode<T> node;
    private int length;
    public MyLinkedList(){
        node = null;
        length = 0;
    }

    @Override
    public void add(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        if(node==null){
            node = newNode;
        }
        else{
            MyNode<T> current = node;
            while (current.next != null){
                current = current.next;
            }
            current.next = newNode;
            length++;
        }
    }
    /*

     * This method add a new node in linked list.

     * It uses if-else statement.

     * Time complexity: 0(1) or 0(n), where n is size of linked list.

     * The algorithm just add new node if list is empty or iterates through all nodes for this,

     * resulting in constant or dependent time complexity.

     *

     * @param item, it is the input number.

     * @return doesn't exist.

     */

    @Override
    public void set(int index, T item) {
        if(index<0 || index>=size()){
            throw new IndexOutOfBoundsException();
        }
        MyNode<T> current = node;
        for(int i=0;i<index;i++){
            current = current.next;
        }
        current.data= item;
    }
    /*

     * This method set a new node in linked list.

     * It uses if-else statement.

     * Time complexity: 0(1) or 0(n), where n is size of linked list.

     * The algorithm just set new node if list is empty or iterates through all nodes for this,

     * resulting in constant or dependent time complexity.

     *

     * @param index, it is the index of the node to be set.

     * @param item, it is the input number.

     * @return doesn't exist.

     */

    @Override
    public void add(int index, T item) {
        if(index<0 || index>size()){
            throw new IndexOutOfBoundsException();
        }
        MyNode<T> newNode = new MyNode<>(item);
        if(index==0){
            newNode.next = node;
            node = newNode;
        }
        else{
            MyNode<T> current = node;
            for(int i=0;i<index-1;i++){
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        length++;

    }
    /*

     * This method add a new node in linked list.

     * It uses if-else statement.

     * Time complexity: 0(1) or 0(n), where n is size of linked list.

     * The algorithm just add new node if list is empty or iterates through all nodes for this,

     * resulting in constant or dependent time complexity.

     *

     * @param index, it is the index of the node to be added.

     * @param item, it is the input number.

     * @return doesn't exist.

     */

    @Override
    public void addFirst(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        newNode.next = node;
        node = newNode;
        length++;

    }
    /*

     * This method add a new node on the first position in the linked list.

     * It uses if-else statement.

     * Time complexity: 0(1).

     * The algorithm just add new node in front of list,

     * resulting in constant complexity.

     *

     * @param item, it is the input number.

     * @return doesn't exist.

     */

    @Override
    public void addLast(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        if(node==null){
            node = newNode;
        }
        else{
            MyNode<T> current = node;
            while (current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
        length++;

    }
    /*

     * This method add a new node on the last position in the linked list.

     * It uses if-else statement.

     * Time complexity: 0(1) or 0(n), where n is size of linked list.

     * The algorithm just add new node if list is empty or iterates through all nodes for this,

     * resulting in constant or dependent time complexity.

     *

     * @param item, it is the input number.

     * @return doesn't exist.

     */

    @Override
    public void remove(int index) {
        if(index<0 || index>size()){
            throw new IndexOutOfBoundsException();
        }
        if(index==0){
            node = node.next;
        }
        else{
            MyNode<T> current = node;
            for(int i=0;i<index-1;i++){
                current = current.next;
            }
            current.next = current.next.next;
        }
        length--;

    }
    /*

     * This method remove a node in linked list.

     * It uses if-else statement.

     * Time complexity: 0(1) or 0(n), where n is size of linked list.

     * The algorithm just remove new node if list is empty or iterates through all nodes for this,

     * resulting in constant or dependent time complexity.

     *

     * @param index, it is the index of the node to be removed.

     * @return doesn't exist.

     */

    @Override
    public void removeFirst() {
        if(node==null){
            throw new IndexOutOfBoundsException();
        }
        node = node.next;
        length--;

    }
    /*

     * This method remove a first node in linked list.

     * It uses if statement.

     * Time complexity: 0(1).

     * The algorithm just remove new node if list is empty or iterates through all nodes for this,

     * resulting in constant time complexity.

     *

     * @param

     * @return doesn't exist.

     */

    @Override
    public void removeLast() {
        if(node==null){
            throw new IndexOutOfBoundsException();
        }
        if(node.next==null){
            node = null;
        }
        else{
            MyNode<T> current = node;
            while (current.next.next != null){
                current = current.next;
            }
            current.next = null;
        }
        length--;

    }
    /*

     * This method remove a last node in linked list.

     * It uses if-else statement.

     * Time complexity: 0(1) or 0(n), where n is size of linked list.

     * The algorithm just remove last node,

     * resulting in constant time complexity.

     *

     * @param item, it is the input number.

     * @return doesn't exist.

     */

    @Override
    public void sort(Comparator<T> cmp) {
        if(node==null || node.next==null){
            return;
        }
        MyNode<T> current = node;
        MyNode<T> nextNode;
        T temp;
        for(int i=0;i<length-1;i++){
            current = node;
            for(int j=0;j<length-i-1;j++){
                nextNode = current.next;
                if(cmp.compare(current.data, nextNode.data) > 0){
                    temp = current.data;
                    current.data = nextNode.data;
                    nextNode.data = temp;
                }
                current = current.next;
            }
        }
    }
    /*

     * This method sorts nodes in linked list.

     * It uses if-else statement.

     * Time complexity: 0(1) or 0(n), where n is size of linked list.

     * The algorithm just sort new node if list is empty or iterates through all nodes for this,

     * resulting in constant or dependent time complexity.

     *

     * @param cmp, it is the comparator to be used for sorting.

     * @return doesn't exist.

     */

    @Override
    public int indexOf(Object object) {
        MyNode<T> current = node;
        int index = 0;
        while (current != null){
            if(current.data.equals(object)){
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }
    /*

     * This method finds index of node in linked list.

     * It uses ifa and while statement.

     * Time complexity: 0(1) or 0(n), where n is size of linked list.

     * The algorithm just index new node if list is empty or iterates through all nodes for this,

     * resulting in constant or dependent time complexity.

     *

     * @param object, it is the input number.

     * @return doesn't exist.

     */

    @Override
    public int lastIndexOf(Object object) {
        MyNode<T> current = node;
        int index = 0;
        int lastIndex = -1;
        while (current != null){
            if(current.data.equals(object)){
                lastIndex = index;
            }
            current = current.next;
            index++;
        }
        return lastIndex;
    }
    /*

     * This method finds last index a node in linked list.

     * It uses if-else statement.

     * Time complexity: 0(1) or 0(n), where n is size of linked list.

     * The algorithm just last index new node if list is empty or iterates through all nodes for this,

     * resulting in constant or dependent time complexity.

     *

     * @param object, it is the input number.

     * @return doesn't exist.

     */

    @Override
    public boolean exists(Object object) {
        MyNode<T> current = node;
        while (current != null){
            if(current.data.equals(object)){
                return true;
            }
            current = current.next;
        }
        return false;
    }
    /*

     * This method check if node exists in linked list.

     * It uses if-else statement.

     * Time complexity: 0(1) or 0(n), where n is size of linked list.

     * The algorithm just check if new node exists if list is empty or iterates through all nodes for this,

     * resulting in constant or dependent time complexity.

     *

     * @param object, it is the input number.

     * @return doesn't exist.

     */

    @Override
    public Object[] toArray() {
        Object[] array = new Object[length];
        MyNode<T> current = node;
        for(int i=0;i<length;i++){
            array[i] = current.data;
            current = current.next;
        }
        return array;
    }
    /*

     * This method convert a object to Array.

     * It uses for loop.

     * Time complexity: 0(1) or 0(n), where n is size of linked list.

     * The algorithm just convert new node to array if list is empty or iterates through all nodes for this,

     * resulting in constant or dependent time complexity.

     *

     * @return doesn't exist.

     */

    @Override
    public void clear() {
        node = null;
        length = 0;

    }
    /*

     * This method clears linked list.

     * It uses if-else statement.

     * Time complexity: 0(1) or 0(n), where n is size of linked list.

     * The algorithm just clear new node if list is empty or iterates through all nodes for this,

     * resulting in constant or dependent time complexity.

     *

     * @return doesn't exist.

     */

    @Override
    public T get(int index) {
        if(index<0 || index>=size()){
            throw new IndexOutOfBoundsException();
        }
        MyNode<T> current = node;
        for(int i=0;i<index;i++){
            current = current.next;
        }
        return current.data;
    }
    /*

     * This method get a node in linked list.

     * It uses if-else statement.

     * Time complexity: 0(1) or 0(n), where n is size of linked list.

     * The algorithm just get new node if list is empty or iterates through all nodes for this,

     * resulting in constant or dependent time complexity.

     *

     * @param index, it is the index of the node to be get.

     * @return doesn't exist.

     */

    @Override
    public T getFirst() {
        if(node==null){
            throw new IndexOutOfBoundsException();
        }
        return node.data;
    }
    /*

     * This method get a first node in linked list.

     * It uses if-else statement.

     * Time complexity: 0(1) or 0(n), where n is size of linked list.

     * The algorithm just get new node if list is empty or iterates through all nodes for this,

     * resulting in constant or dependent time complexity.

     *

     * @return doesn't exist.

     */

    @Override
    public T getLast() {
        if(node==null){
            throw new IndexOutOfBoundsException();
        }
        MyNode<T> current = node;
        while (current.next != null){
            current = current.next;
        }
        return current.data;
    }
    /*

     * This method get a last in linked list.

     * It uses if-else statement.

     * Time complexity: 0(1) or 0(n), where n is size of linked list.

     * The algorithm just get new node if list is empty or iterates through all nodes for this,

     * resulting in constant or dependent time complexity.

     *

     * @return doesn't exist.

     */

    @Override
    public int size() {
        return length;
    }
    /*

     * This method get size of linked list.

     * It uses if-else statement.

     * Time complexity: 0(1).

     * The algorithm just get new node if list is empty or iterates through all nodes for this,

     * resulting in constant time complexity.

     *

     * @return doesn't exist.

     */

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private MyNode<T> current = node;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T value = current.data;
                current = current.next;
                return value;
            }
        };
    }
    /*

     * This method is responsible for iterator in linked list.

     * It uses if-else statement.

     * Time complexity: 0(1) or 0(n), where n is size of linked list.

     * The algorithm just iterator new node if list is empty or iterates through all nodes for this,

     * resulting in constant or dependent time complexity.

     *

     * @return doesn't exist.

     */
}