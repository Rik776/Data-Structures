public class Queue<T> {
    private Node<T> head;
    private Node<T> tail;


    public Queue() {
        head = null;
        tail = null;
    }

    public void add(T t){
        Node<T> newNode = new Node<T>(t);
        if (head==null) {
            head = newNode;
            tail = newNode;
        }

        tail.setNext(newNode);
        tail = newNode;
    }
    public T get(){
        if (head == null) {
            throw new NullPointerException("No elemens in the Queue");
        }
        T auxT = head.getData();
        
        head = (head == tail) ? null : head.getNext();
        return auxT;
    }
    public T peak(){
        return head.getData();
    }
    public boolean isEmpty(){
        return head==null;
    }

}
