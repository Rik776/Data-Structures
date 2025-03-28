import java.util.Iterator;

public class Stack<T> implements Iterable<T>{
    private Node<T> top;
    private int size;

    public Stack() {
        this.top = null;
    }

    public void push(T t){
        Node<T> newNode = new Node<T>(t);
        if (top==null) {
            top = newNode;
            size ++;
        }else{
            newNode.setNext(top);
            top = newNode;
            size ++;

        }
    }
    public T peak(){
        return (top!=null)? top.getData(): null;
    }
    public T pop(){
        T t = top.getData();
        size --;
        top = top.getNext();
        return t;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>(){
            Node<T> node = top;
            @Override
            public boolean hasNext() {
                return node!=null;
            }

            @Override
            public T next() {
                    T t = node.getData();
                    node = node.getNext();
                    return t;
            }
        };
        }
    }
