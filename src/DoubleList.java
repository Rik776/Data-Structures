import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

    @SuppressWarnings("rawtypes")
    public class DoubleList<T>  implements java.util.List  {
    private NodeDouble<T> head;
    private NodeDouble<T> tail;
    private int size;
    public DoubleList() {
        size = 0;
        head = null;
        tail = null;
    }
    @Override
    public int size() {
    return size;
    }
    @Override
    public boolean isEmpty() {
    return head == null;
    }
    @Override
    public boolean contains(Object o) {
        NodeDouble<T> auxNode = head;
        while (auxNode.getData()!= o ) {
            auxNode = auxNode.getNext();
            if (auxNode.getNext()==null&& auxNode.getData()!=o) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Object[] toArray() {
        Object[] object = new Object[size-1];
        NodeDouble<T> nodeAux = head;
        int i = 0;
        while (nodeAux.getNext()!=null) {
            object[i]=nodeAux.getData();
            nodeAux = nodeAux.getNext();
            i++;
        }
        return object;


    }
    @Override
    public Object[] toArray(Object[] a) {
    Object[] object = new Object[a.length];
        NodeDouble<T> nodeAux = head;
        int i = 0;
        while (nodeAux.getNext()!=null && i< a.length ) {
            object[i]=nodeAux.getData();
            nodeAux = nodeAux.getNext();
            i++;
        }
        return object;

    }
    @SuppressWarnings("unchecked")
    @Override
    public boolean add(Object e) {
        NodeDouble<T> auxNode = new NodeDouble<T>((T)e);
        if (head==null) {
            head = auxNode;
            tail = auxNode;
            size++;
        }else{
            auxNode.setPrevius(tail);
            tail.setNext(auxNode);
            tail = auxNode;
            size++;
        }
        return tail ==auxNode;
    }
    @Override
    public boolean remove(Object o) {
        NodeDouble<T> auxNode = head;
        if (contains(o)&& o != head.getData()) {
            while (auxNode.getData()!= o ) {
            auxNode = auxNode.getNext();
        }
        if (auxNode.getNext()==null) {
            auxNode.getPrevius().setNext(null);;
        }else{
        auxNode.getNext().setPrevius(auxNode.getPrevius());
        auxNode.getPrevius().setNext(auxNode.getNext());
        }
        size--;
        return true;
        }else if (o == head.getData()) {
            head = head.getNext();
            head.setPrevius(null);
        size--;
            return true;
        }
        return false;
    }
    @Override
    public boolean containsAll(Collection c) {
        for (Object object : c) {
            if (!contains(object)) {
                return false;
            }
        }

        return true;
    }
    @Override
    public boolean addAll(Collection c) {
        if (!c.isEmpty()) {
        for (Object object : c) {
            add(object);
        }   

    return true;
    
    }
    return false;
    
}
@Override
public boolean addAll(int index, Collection c) {
    int aux = 0;
    NodeDouble<T> nodeAux = head;
    if (index == 0) {
        for (Object object : c) {
            add(aux++, object);
        }
    }else if( 0<=index && index<size){
    while (aux!=index-1 && nodeAux.getNext()!=null) {
        nodeAux = nodeAux.getNext();
        aux++;
    }for (Object object : c) {
        add(aux++, object);;
    }
    return true;
    }
    return false;

 }
    
@Override
public boolean removeAll(Collection c) {
   if (containsAll(c)) {
     for (Object object : c) {
        remove(object);
     }

     return true;
   }
   return false;
}
@SuppressWarnings({ "unchecked" })
@Override
public boolean retainAll(Collection c) {
    if (containsAll(c)) {
       forEach(t -> {if (!c.contains(t)) {
        remove(t);
       }
     }
       );
       return true;
    }
    return false;
}
@Override
public void clear() {
    head = null;
}
@Override
public Object get(int index) {
    NodeDouble<T> nodeAux = head;
    int aux = 0;
    if (size>index && index>=0) {
      while (aux != index && nodeAux.getNext() != null ) {
        nodeAux = nodeAux.getNext();
        aux++;
    }  
    return nodeAux.getData();
    }
    throw new IndexOutOfBoundsException("Index out of bounds. size = "+size);
}
@SuppressWarnings("unchecked")
@Override
public Object set(int index, Object element) {
    Object auxObject;
   if (contains(element)) {
    NodeDouble<T> auxNode = new NodeDouble<T>((T)get(indexOf(element)));
    
    remove(element);
        if (index == 0) {
            auxObject = get(index);
            auxNode.setNext(head);
            head = auxNode;
        }else if (index==size-1) {
            auxObject = get(index);
            tail.setNext(auxNode);
        }else if (index>0 && index<size-1) {
            auxObject = get(index);
            add(element);
        }else{
             throw new NullPointerException("The index is out of bounds size ="+ size);
        }
        return auxObject;
}
throw new NullPointerException("The object is not Listed");
}
@SuppressWarnings("unchecked")
@Override
public void add(int index, Object element) {
    NodeDouble<T> newNode = new NodeDouble<T>((T) element);
    int aux = 0;
    NodeDouble<T> nodeAux = head;
    if (index == 0) {
        newNode.setNext(head);
        head=newNode;
    }else{
    while (aux!=index-1 && nodeAux.getNext()!=null) {
        nodeAux = nodeAux.getNext();
        aux++;
    }
    newNode.setNext(nodeAux.getNext());
    nodeAux.setNext(newNode);
    }
    size++;
 }
@Override
public Object remove(int index) {
    if (index>=0 && index <=size-1) {
        remove(get(index));
        return true;
    }
    return false;
}
@Override
public int indexOf(Object o) {
    NodeDouble<T> auxNode = head;
    int auxInt = 0;
    if (contains(o)) {
        while (auxNode.getNext()!= null) {
            if (o.equals(auxNode.getData())) {
                return auxInt;
            }
            auxNode = auxNode.getNext();
            auxInt++;
        }
    }
    return -1;
}
@Override
public int lastIndexOf(Object o) {
    NodeDouble<T> auxNode = head;
    int auxInt=0;
    if (contains(o)) {
        while (auxNode.getNext()!=null) {
            if (o.equals(auxNode.getData())) {
                auxInt = indexOf(auxNode);
            }
            auxNode = auxNode.getNext();
        }
        return auxInt;
    }
    return -1;
}
@Override
public ListIterator listIterator() {
    throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
}
@Override
public ListIterator listIterator(int index) {
    throw new UnsupportedOperationException("Unimplemented method 'listIterator'");
}
@SuppressWarnings("unchecked")
@Override
public java.util.List subList(int fromIndex, int toIndex) {
    int intAux = 0;
    List newList = new List<T>();
    if (fromIndex>=0 && fromIndex<toIndex && toIndex<=size-1) {
        for (Object object : this) {

            if (intAux >= fromIndex && intAux <= toIndex) {
                newList.add(object);
            }
            intAux++;
    }
    return newList;
}
throw new UnsupportedOperationException("Wrong index");
}
@Override
public Iterator<T> iterator() {
   Iterator<T> iterator = new Iterator<T>() {
    NodeDouble<T> nodeAux = head;
    @Override
    public boolean hasNext() {
        return nodeAux!=null;
    }
    @Override
    public T next() {
        T auxT = nodeAux.getData();
        nodeAux = nodeAux.getNext();
         return auxT;
    }
   };
   return iterator;
}
}
