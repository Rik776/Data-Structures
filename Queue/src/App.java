public class App {
    public static void main(String[] args) {
        Queue<Integer> ints = new Queue<>();
        ints.add(1);
        ints.add(2);    
        ints.add(3);    
        ints.add(4);    
        ints.add(5);    
        ints.add(6);
        for (Object object : ints) {
            System.out.println(object);
        }       
    }
}

