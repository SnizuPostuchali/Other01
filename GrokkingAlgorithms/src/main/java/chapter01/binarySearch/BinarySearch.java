package chapter01.binarySearch;

import supportClasses.CreateSortedArray;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число элементов в массиве: ");
        int arraySize = sc.nextInt();
        System.out.println("Введите искомый элемент: ");
        int searchedElement = sc.nextInt();
        sc.close();

        CreateSortedArray createSortedArray = new CreateSortedArray();

        int [] array = createSortedArray.createSortedArray(arraySize);

        System.out.println(Arrays.toString(array));

        System.out.println(binarySearchWhile(array, searchedElement));


        int lowIndex = 0;
        int upIndex = arraySize-1;
        System.out.println(binarySearchRecurse(array, searchedElement, lowIndex, upIndex));
    }

    public static String binarySearchWhile(int [] array, int searchedElement){
        int lowIndex = 0;
        int upIndex = array.length-1;
        int mid = (upIndex - lowIndex)/2;

        while(lowIndex<=upIndex){
            if(array[mid] == searchedElement){
                return ""+mid;
            }
            if(array[mid] > searchedElement){
                upIndex = mid - 1;
            } else {
                lowIndex = mid + 1;
            }
            mid = (upIndex - lowIndex)/2;
        }
        return "No elements founded";
    }

    public static int binarySearchRecurse(int [] array, int searchedElement, int lowIndex, int upIndex){
        int mid = (upIndex - lowIndex)/2;
        if(array[mid] == searchedElement){
            return mid;
        }
        if(lowIndex>upIndex){
            return 0;
        }
        if(array[mid] > searchedElement){
            return binarySearchRecurse(array, searchedElement, lowIndex, mid-1);
        } else {
            return binarySearchRecurse(array, searchedElement, mid+1, upIndex);
        }
    }
}
