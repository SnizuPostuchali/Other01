package chapter02.selectionSort;

import supportClasses.CreateArray;

import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число элементов в массиве: ");
        int arraySize = sc.nextInt();
        sc.close();
        CreateArray createArray = new CreateArray();

        int [] array = createArray.createArray(arraySize);
        System.out.println(Arrays.toString(array));

        System.out.println(Arrays.toString(selectionSort(array)));
    }

    public static int[] selectionSort(int[] array){

        for (int i = 0; i<array.length; i++){
            int min = array[i];
            int minIndex = i;

            for (int j = i+1; j<array.length; j++){
                if(array[j]<array[minIndex]){
                    minIndex = j;
                }
            }

            array[i] = array[minIndex];
            array[minIndex] = min;
        }

        return array;
    }
}
