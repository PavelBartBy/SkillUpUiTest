package basicAlgorithm;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {

        int[] x = { 8, 0, 4, 7, 3, 7, 10, 12, -3 };
        System.out.println("Array:");
        System.out.println(Arrays.toString(x));

        insertionSort(x);
        System.out.println("Array now");
        System.out.println(Arrays.toString(x));

    }

    public static void insertionSort(int[] array){

        for (int i=1; i<array.length; i++){
            int currElem = array[i];
            int prevKey = i-1;
            while (prevKey>=0 && currElem < array[prevKey]){
                array[prevKey+1]= array[prevKey];
                array[prevKey]=currElem;
                prevKey--;
            }
        }
    }
}
