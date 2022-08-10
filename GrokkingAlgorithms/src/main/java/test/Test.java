package test;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Integer a = 1;
        list.add(a);
        list.add(++a);
        list.add(++a);
        list.add(++a);

        System.out.println(list);
        list.remove((Integer) 1);
        System.out.println(list);
        list.remove(1);
        System.out.println(list);

//        ArrayList<Number> list1 = new ArrayList<>();
//        list1.addAll(list);
//        System.out.println(list1);
//        System.out.println(list1.get(0).getClass());
    }
}
