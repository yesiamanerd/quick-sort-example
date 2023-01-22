package org.example;

import java.util.Arrays;
import java.util.Random;

public class Main {


    // initial quicksort call
    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    // quicksort method
    public static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int pivot = partition(array, left, right);
            System.err.println("pivot: " + pivot);
            quickSort(array, left, pivot - 1);
            quickSort(array, pivot + 1, right);
        }
    }

    // partition method
    public static int partition(int[] array, int left, int right) {
        int pivot = array[right];
        System.err.println("partition pivot: " + pivot);
        int i = left - 1;
        System.err.println("i: " + i);
        for (int j = left; j < right; j++) {
            System.err.format("Is array[j] %d less than pivot %d? %b\n", array[j], pivot, array[j] <= pivot);
            if (array[j] <= pivot) {

                i++;
                if(array[i] != array[j]) {
                    System.err.format("Swap %d with %d\n", array[j], array[i]);
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
                System.err.println("new array: " + Arrays.toString(array));
            }
        }
        if(array[i + 1] != array[right]) {
            int temp = array[i + 1];

            System.err.format("last of partition, swap %d with %d\n", temp, array[right]);
            array[i + 1] = array[right];
            array[right] = temp;
        }

        System.err.println("new array returned to quicksort: " + Arrays.toString(array));
        return i + 1;
    }

    public static void main(String[] args) {

        // get random integers
        Random rand = new Random();
        int[] numbers = new int[20];
        for (int i = 0; i < 20; i++) {
            numbers[i] = rand.nextInt(41);
        }

        // print initial array
        System.out.println("Initial array: " + Arrays.toString(numbers));
        quickSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}