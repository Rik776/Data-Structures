import java.util.Comparator;

public class App {
    public static void main(String[] args) throws Exception {
        Tree<Integer> tree = new Tree<Integer>(Comparator.naturalOrder());
        tree.add(10);
        tree.add(5);
        tree.add(13);
        tree.add(3);
        tree.add(14);
        tree.add(15);
        tree.add(17);
        tree.add(19);
        tree.add(345);

        System.out.println(tree.isEmpty());
        for (Integer ints : tree.inOrder()) {
            System.out.println(ints);
        }
        System.out.println("Remove method");
        tree.remove(10);
        tree.remove(345);
        tree.remove(15);

        System.out.println(tree.contains(10));
        System.out.println(tree.contains(345));

        for (Integer ints : tree.inOrder()) {
            System.out.println(ints);
        }

    }
}
