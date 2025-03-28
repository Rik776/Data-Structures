import java.util.Comparator;
import java.util.Iterator;

public class NarioTree<T> implements Iterable<T> {
    private TNode<T> root;
    private Comparator<T> comparator;

    public NarioTree(T rootData, Comparator<T> comparator){
        root = new TNode <T>(rootData);
        this.comparator = comparator;
    }
    public boolean add(T parentData, T sonData){
        if (comparator.compare(parentData,root.getData())==0) {
            return search(parentData).add(sonData);
        }
        if (findNode(parentData, root)==null) return false;
        return search(parentData).add(sonData);
    }
    public TNode<T>  search (T data){
        return findNode(data, root);
    }
    public TNode<T> findNode(T data, TNode<T> auxRoot){
        if (auxRoot == null ) return null;
        if (auxRoot.getData() != null && comparator.compare(data, auxRoot.getData())==0) return auxRoot;
        for (int i = 0; i < auxRoot.getChildren().size(); i++) {
            TNode<T> foundNode = findNode(data, auxRoot.getChildren().get(i));
            if (foundNode!=null) return foundNode;
        }
        return null;
    }
    public boolean remove (T parentData, T sonData){
        if (search(parentData)==null) {
            return false;
        }else{
        return search(parentData).remove(search(sonData));
        }
    }

    public TNode<T> getRoot(){
        return root;
    }
    //deepIterator add in a stack the data from the tree in based in deep order 
    // and Based in Pre-Order concept
    public Iterator<T> deepIterator() {
        return new Iterator<T>() {
            Stack<TNode<T>> stack = new Stack<>();
            { stack.push(root); }

            @Override
            public boolean hasNext() {
                return stack.peak()!=null;
            }

            @Override
            public T next() {
                TNode<T> node = stack.pop();
                for (int i = node.getChildren().size() - 1; i >= 0; i--) {
                    stack.push(node.getChildren().get(i));
                }
                return node.getData();
            }
        };
    }
    @Override
    //BreathIterator add in a queue the data from level order like a breath
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Queue<TNode<T>> queue = new Queue<TNode<T>>();
            {queue.add(root);}
            @Override
            public boolean hasNext() {
                return !queue.isEmpty();
            }

            @Override
            public T next() {
                T data = queue.peak().getData();
                TNode<T> node = queue.get();
                Iterator<T> iterator = (Iterator<T>) node.getChildren().iterator();
                while (iterator.hasNext()) {
                    queue.add((TNode<T>) iterator.next());
                }
                return data;
            }
        };
    }
}
