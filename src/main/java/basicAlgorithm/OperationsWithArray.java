package basicAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OperationsWithArray {

    public static int sumEvenPositive (int[] array) {

        int sum = 0;
        for (int j : array) {
            if (j >= 0 & j % 2 == 0) {
                 sum = sum + j;
            }
        }
        return sum;
    }

    public static int maxElement(int[] array){
        int max = 0;
        for (int i:array){
            if (i>=max){
                max=i;
            }
        }
        return max;
    }

    public static int minElement(int[] array){
        int min = 0;
        for (int i:array){
            if (i<min){
                min=i;
            }
        }
        return min;
    }

    public static List<Integer> lowElements(int[] array){

        int sum = 0;
        for (int i:array){
            sum=sum+i;
        }
        double amean=(double)sum/array.length;
        System.out.println("The arithmetic mean is " + amean);
        List<Integer> lowelements = new ArrayList<Integer>();
        for (int j:array){
            if(j<amean){
                lowelements.add(j);
            }
        }
        return lowelements;
    }

    public static void main (String[] args){

        int[] x = { 8, 0, 3, -6, 7, -44, 3, 7, -13, -1, -10, 10, 12, -3 };
        System.out.println(Arrays.toString(x));

        System.out.println("Sum of even positive numbers is "+ sumEvenPositive(x));
        int max = maxElement(x);
        System.out.println("Max Element is " + max);
        int min = minElement(x);
        System.out.println("Min Element is " + min);
        List<Integer> lowelements = lowElements(x);
        System.out.println("Elements which less than the arithmetic mean " + lowelements);

        System.out.println("Array memory on system: about "+ x.length*DataTypeInfo.sizeOf(int.class)+" byte");
    }

}
