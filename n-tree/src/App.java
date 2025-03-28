import java.util.Comparator;
import java.util.Iterator;

public class App {
    public static void main(String[] args) throws Exception {
        NarioTree<Integer> narioTree = new NarioTree<Integer>(50, Comparator.naturalOrder());
        narioTree.add(50, 10);
        narioTree.add(50, 20);
        narioTree.add(50, 30);
        narioTree.add(50, 40);
        narioTree.add(50, 60);
        narioTree.add(10, 2);
        narioTree.add(10, 3);
        narioTree.add(10, 4);
        narioTree.add(40, 47);
        narioTree.add(40, 48);
        narioTree.add(40, 49);


        narioTree.remove(10, 4);

        for (Object object : narioTree) {
            System.out.println(object);
        }
        System.out.println("***********************");
        Iterator<Integer> iterator = narioTree.deepIterator(); 
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


    }
}
