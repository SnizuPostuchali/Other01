package chapter04.quickSort;

import supportClasses.CreateArray;

import java.util.Arrays;

public class QuickSortArray {
    public static void main(String[] args) {
        CreateArray createArray = new CreateArray();
        int [] array = createArray.createArray(10);
        System.out.println(Arrays.toString(array));
        quickSort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int [] arrayToSort, int first, int last){
        if(first>=last){
            return;
        }

        int pivot = partition(arrayToSort, first, last);
        quickSort(arrayToSort, first, pivot-1);
        quickSort(arrayToSort, pivot+1, last);
    }

    public static void swap(int [] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static int partition(int[] array, int first, int last){
        int pivot = array[last];
        int pIndex = first;

        for(int i = first; i<last; i++){
            if(array[i] <= pivot){
                swap(array, i, pIndex);
                pIndex++;
            }
        }

        swap(array, last, pIndex);
        return pIndex;
    }
}
