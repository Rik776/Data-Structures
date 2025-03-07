public class Stack<T> {
    private Node<T> top;
    public Stack() {
        this.top = null;
    }

    public void push(T t){
        Node<T> newNode = new Node<T>(t);
        if (top==null) {
            top = newNode;
        }else{
            newNode.setNext(top);
            top = newNode;
        }
    }
    public T peak(){
        return (top!=null)? top.getData(): null;
    }
    public T pop(){
        T t = top.getData();
        top = top.getNext();
        return t;
    }
}
