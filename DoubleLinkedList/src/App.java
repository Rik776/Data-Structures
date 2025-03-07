import java.util.ArrayList;

public class App {
    
    public static void main(String args[]){
    List list = new List();
 
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
    list.add(6);
    list.add(7);
    list.add(8);
    list.add(9);


    System.out.println(list.size());
    for (Object object : list) {
      System.out.println(object);
    }
    System.out.println(list.remove(0));
    System.out.println(list.remove(7));
    System.out.println(list.remove(8));
    System.out.println(list.size());

    Object[] ints = list.toArray();

    for (int i = 0; i < ints.length; i++) {
        System.out.print(ints[i]);
    }

    }
  }