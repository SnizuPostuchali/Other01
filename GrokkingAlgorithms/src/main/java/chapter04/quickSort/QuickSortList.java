package chapter04.quickSort;

import supportClasses.CreateList;

import java.util.ArrayList;
import java.util.List;

public class QuickSortList {

    static int count = 0;

    public static void main(String[] args) {
        CreateList createList = new CreateList();
        List<Integer> list = createList.createList(2000);
        System.out.println(list);
        System.out.println(quickSort(list));
        System.out.println();
        System.out.println(count);
    }

    public static List<Integer> quickSort(List<Integer> listToSort){
        ++count;
        if (listToSort.size() >= 2) {
            int pillar = listToSort.get(0);
            List<Integer> pillarList = new ArrayList<>();
            pillarList.add(listToSort.get(0));
            List<Integer> lowerList = new ArrayList<>();
            List<Integer> upperList = new ArrayList<>();
            for (int i = 1; i < listToSort.size(); i++) {
                if (listToSort.get(i) < pillar) {
                    lowerList.add(listToSort.get(i));
                } else if (listToSort.get(i) > pillar) {
                    upperList.add(listToSort.get(i));
                } else {
                    pillarList.add(listToSort.get(i));
                }
            }
            listToSort.clear();
            listToSort.addAll(quickSort(lowerList));
            listToSort.addAll(pillarList);
            listToSort.addAll(quickSort(upperList));
        }
        return listToSort;
    }
}
