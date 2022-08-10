package chapter03.recursion;

import java.util.Arrays;
import java.util.List;

public class Sum {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 7, 3, 0, 2, 8);
        System.out.println(sum(list));
    }

    private static int sum(List<Integer> list){
        if(list.size() == 0){
            return 0;
        } else {
            return list.get(0) + sum(list.subList(1, list.size()));
        }
    }
}
