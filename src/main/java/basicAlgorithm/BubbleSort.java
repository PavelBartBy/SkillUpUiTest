package basicAlgorithm;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {

        int[] array = { 8, 0, 4, 7, 3, 7, 10, 12, -3 };

        System.out.println("Array:");
        System.out.println(Arrays.toString(array));

        bubbleSort(array);
        System.out.println("Array now");
        System.out.println(Arrays.toString(array));
    }

    public static void bubbleSort(int[] array){

        for (int i=array.length-1; i>=1; i--){
            for (int j=0; j<i; j++){
              if (array[j]>array[j+1]){
                  toSwap(array, j,j+1);
              }
            }
        }
    }

    public static void toSwap (int[] array,int a, int b){

        int temp = array[a];
        array[a]=array[b];
        array[b]=temp;
    }
}
