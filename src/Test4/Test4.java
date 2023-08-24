package Test4;

import java.util.ArrayList;
import java.util.List;

public class Test4 {
    public static void main(String[] args) {
        MyArrayList<String> names = new MyArrayList<String>();
        names.add("name1");
        names.add("name2");
        names.add("name3");
        names.add("name4");
        names.add("name5");
        names.add("name6");
        names.add("name7");
        System.out.println(names);
        String n1 = names.get(4);
        System.out.println(n1);
        names.remove(3);
        System.out.println(names);
        names.foreach(s -> System.out.println(s.length()));
    }
}
