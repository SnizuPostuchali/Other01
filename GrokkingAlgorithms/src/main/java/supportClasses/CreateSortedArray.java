package supportClasses;

public class CreateSortedArray {
    int [] array;

    public int[] createSortedArray(int arraySize) {
        array = new int[arraySize];
        array[0] = (int)(Math.random()*6);
        for(int i = 1; i < arraySize; i++){
            array[i] = array[i-1] + (int)(Math.random()*6) + 1;
        }
        return array;
    }
}
