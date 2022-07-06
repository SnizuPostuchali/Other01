package supportClasses;

public class CreateArray {
    int [] array;

    public int[] createArray(int arraySize) {
        array = new int[arraySize];
        for(int i = 0; i < arraySize; i++){
            array[i] = (int)(Math.random()*arraySize) + 1;
        }
        return array;
    }
}
