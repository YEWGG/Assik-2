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
    public void add(T element) {
        MyNode<T> newNode = new MyNode<>(element);
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

    @Override
    public void set(int index, T item) {
        if(index<0 || index>=size()){
            throw new IndexOutOfBoundsException();
        }
        MyNode<T> current = node;
        for(int i=0;i<index;i++){
            current = current.next;
        }
        current.value = item;
    }

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

    @Override
    public void addFirst(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        newNode.next = node;
        node = newNode;
        length++;

    }

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

    @Override
    public void remove(int index) {
        if(index<0 || index>=size()){
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

    @Override
    public void removeFirst() {
        if(node==null){
            throw new IndexOutOfBoundsException();
        }
        node = node.next;
        length--;

    }

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

    @Override
    public void sort(Comparator<T> cmp) {
        if(node==null || node.next==null){
            return;
        }
        MyNode<T> current = node;
        MyNode<T> index = null;
        T temp;
        while (current != null){
            index = current.next;
            while (index != null){
                if(cmp.compare(current.value, index.value)>0){
                    temp = current.value;
                    current.value = index.value;
                    index.value = temp;
                }
                index = index.next;
            }
            current = current.next;
        }
    }

    @Override
    public int indexOf(Object object) {
        MyNode<T> current = node;
        int index = 0;
        while (current != null){
            if(current.value.equals(object)){
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        MyNode<T> current = node;
        int index = 0;
        int lastIndex = -1;
        while (current != null){
            if(current.value.equals(object)){
                lastIndex = index;
            }
            current = current.next;
            index++;
        }
        return lastIndex;
    }

    @Override
    public boolean exists(Object object) {
        MyNode<T> current = node;
        while (current != null){
            if(current.value.equals(object)){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[length];
        MyNode<T> current = node;
        for(int i=0;i<length;i++){
            array[i] = current.value;
            current = current.next;
        }
        return array;
    }

    @Override
    public void clear() {
        node = null;
        length = 0;

    }

    @Override
    public T get(int index) {
        if(index<0 || index>=size()){
            throw new IndexOutOfBoundsException();
        }
        MyNode<T> current = node;
        for(int i=0;i<index;i++){
            current = current.next;
        }
        return current.value;
    }

    @Override
    public T getFirst() {
        if(node==null){
            throw new IndexOutOfBoundsException();
        }
        return node.value;
    }

    @Override
    public T getLast() {
        if(node==null){
            throw new IndexOutOfBoundsException();
        }
        MyNode<T> current = node;
        while (current.next != null){
            current = current.next;
        }
        return current.value;
    }

    @Override
    public int size() {
        return length;
    }

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
                T value = current.value;
                current = current.next;
                return value;
            }
        };
    }
}