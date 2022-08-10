package chapter03.recursion;

import java.util.Arrays;
import java.util.List;

public class MaxElement {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 7, 3, 10, 2, 8);
        System.out.println(max(list.get(0), list));
    }

    private static int max(int x, List<Integer> list){
        if(list.size() == 0){
            return x;
        }
        if(list.get(0) > x){
            x = list.get(0);
        }
        return max(x, list.subList(1, list.size()));
    }
}
