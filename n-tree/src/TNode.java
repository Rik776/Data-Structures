public class TNode<T> {
    private List<TNode<T>> children;
    private T data;

    public TNode(T data) {
        this.children = new List<TNode<T>>();
        this.data = data;
    }

    public boolean add (T data){
        return children.add(new TNode<T>(data));
    }
    public boolean remove(TNode<T> data){
        return children.remove(data);
    }


    public List<TNode<T>> getChildren() {
        return children;
    }

    public void setChildren(List<TNode<T>> children) {
        this.children = children;
    }

    public T getData() {
        return data;
    }  
    
}
