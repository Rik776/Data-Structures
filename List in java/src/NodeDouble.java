public class NodeDouble<T> {
        private NodeDouble<T> next;
        private NodeDouble<T> previus;
        private T data;
public NodeDouble(T data){
    this.data = data;
    this.previus = null;
    this.next = null;
}
public NodeDouble<T> getNext() {
    return next;
}
public void setNext(NodeDouble<T> next) {
    this.next = next;
}
public T getData() {    
    return data;
}
public NodeDouble<T> getPrevius() {
    return previus;
}
public void setPrevius(NodeDouble<T> previus) {
    this.previus = previus;
}

}
