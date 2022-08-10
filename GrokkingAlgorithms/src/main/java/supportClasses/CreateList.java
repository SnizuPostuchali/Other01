package supportClasses;

import java.util.ArrayList;
import java.util.List;

public class CreateList {
    private List<Integer> list = new ArrayList<>();

    public List<Integer> createList(int size){
        for(int i = 0; i < size; i++){
            list.add((int)(Math.random()*size) + 1);
        }
        return list;
    }
}
