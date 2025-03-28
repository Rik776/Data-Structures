import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Tree<T> {
    private Node<T> root;
    private Comparator<T> comparator;

    public Tree(Comparator<T> comparator) {
        root = null;
        this.comparator = comparator;
    }

    public void add(T data){
        Node<T> newNode = new Node<T>(data);
        if (root==null) {
            root = newNode;
        }else{
           auxAdd(newNode, comparator.compare(newNode.getData(), root.getData()), root);
        }
    }
    public boolean auxAdd(Node<T> newNode, int i, Node<T> node){
        if (i==1) {
            if (node.getRight()==null) {
                node.setRight(newNode);
                return true;
            }
        }else{
            if (node.getLeft()==null) {
                node.setLeft(newNode);
                return true;
            }
        }
        int aux = comparator.compare(newNode.getData(), node.getData());
        if (aux==0) {
            return false;
        }
        auxAdd(newNode, aux, (aux==1)? node.getRight(): node.getLeft());
        return false;
    }
    public Boolean isEmpty(){
        return  root==null;
    }
    public List<T> preOrder(){
        List<T> newList = new ArrayList<T>();
        preOrder(newList, root);
        return newList;
        
    }
    public void preOrder(List<T> list, Node<T> root){
        if (root!=null) {
            list.add(root.getData());
            preOrder(list, root.getLeft());
            preOrder(list, root.getRight());

        }
    }
    public List<T> inOrder(){
        List<T> newList = new ArrayList<T>();
        inOrder(newList, root);
        return newList;
        
    }
    public void inOrder(List<T> list, Node<T> node){
        if (node!=null) {
            preOrder(list, node.getLeft());
            list.add(node.getData());
            preOrder(list, node.getRight());

        }
    }
    public List<T> posOrder(){
        List<T> newList = new ArrayList<T>();
        posOrder(newList, root);
        return newList;
        
    }
    public void posOrder(List<T> list, Node<T> node){
        if (node!=null) {
            preOrder(list, node.getLeft());
            preOrder(list, node.getRight());
            list.add(node.getData());
        }
    }
    public void remove(T data){
        if (root.getData().equals(data)) {
            if (!isLeaf(root)) {
                Node<T> auxNode = root.getRight();
            root = root.getLeft();
            root.setRight(auxNode);
            }else{
                root = null;
            }
           
        }else{
            findNode(data, root);
        }
    }
    public void findNode(T data, Node<T> node){
        if (contains(data)) {
            if (!isLeaf(node)) {
               if ((comparator.compare(data, node.getData())==1)) { 
                if (!node.getRight().getData().equals(data)) {
                    findNode(data, node.getRight());
                }  
                removeAux(node, data);

             }else if ((comparator.compare(data, node.getData())==-1)) {
                if (!node.getLeft().getData().equals(data)) {
                    findNode(data, node.getLeft());
                } 
                removeAux(node, data);
             }  
            }

        }

            
    }
    public void removeAux(Node<T> node, T data){
        if (node!=null) {
         if (isLeaf(node)) {
            if (root.getLeft().getData().equals(data)) {
                root.setLeft(null);
            }else if (root.getRight().getData().equals(data)) {
                root.setRight(null);
            }
        }else if (node.getLeft()!=null) {
            if ((node.getLeft().getData().equals(data))) {
                node.setLeft(node.getLeft().getLeft());
            } 
        } else if (node.getRight()!=null) {
            if ((node.getRight().getData().equals(data))) {
                node.setRight(node.getRight().getRight());
            } 
        }   
        }  
    }
    public boolean isLeaf(Node<T> node){
        if (node.getLeft() == null && node.getRight() == null) {
            return true;
        }
        return false;
    }

    public boolean contains(T data){
        return posOrder().contains((T) data);
    }

}
