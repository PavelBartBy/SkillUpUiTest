package basicAlgorithm;

import java.util.Arrays;

public class QuickSort {

    public void quickSort (int[] array, int low, int high) {

        if (array.length==0) {
            return;
        }
        if (low>high){
            return;
        }
        //choose mid
        int middle = low + (high-low)/2;
        int opora = array[middle];
        //break array and change places
        int i = low;
        int j = high;
        while (i<=j){
            while (array[i]<opora){
                i++;
            }
            while (array[j]>opora){
                j--;
            }
            if (i<=j){
                int temp=array[i];
                array[i]=array[j];
                array[j]=temp;
                i++;
                j--;
            }
        }
        //recursion for sort parts
        if (low<j){
            quickSort(array,low,j);
        }
        if (high>i){
            quickSort(array,i,high);
        }
    }

    public void main(String[] args) {
        int[] x = { 8, 0, 4, 7, 3, 7, 10, 12, -3 };
        System.out.println("Array:");
        System.out.println(Arrays.toString(x));

        int low = 0;
        int high = x.length - 1;

        quickSort(x, low, high);
        System.out.println("Array now");
        System.out.println(Arrays.toString(x));
    }
}
