public class MyNode<T> {
    T data;
    MyNode<T> next;
    MyNode<T> prev;

    public MyNode(T data){
        this.data = data;
        this.next = null;
    }
    public MyNode(T data, MyNode<T> next){
        this.data = data;
        this.next = next;
    }
    public MyNode(T data, MyNode<T> next, MyNode<T> prev){
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public MyNode<T> getNext() {
        return next;
    }
    public void setNext(MyNode<T> next) {
        this.next = next;
    }
    public MyNode<T> getPrev() {
        return prev;
    }
    public void setPrev(MyNode<T> prev) {
        this.prev = prev;
    }

}