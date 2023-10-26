import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {2,4,-1,56,98,44,-35};
        binarySearch(arr,44);
    }

    public static void binarySearch(int[] array, int number) {

        selectionSort(array); //küçükten büyüğe sıraladım.
        System.out.println(Arrays.toString(array));

        boolean flag = false;
        for (int j : array) {
            if (j == number) {
                flag = true;
            }
        }
        if(!flag) {
            System.out.println("Aradığınız sayı bu dizide bulunmamaktadır.");
            return;
        }


        int middle = array.length/2;         //middle index
        int index = 0;                      // aradığımız sayının bulunduğu index

        // istediğim sayı ortadaki sayıdan küçükse sola, büyükse sağa bakacağım
        while(0 <= middle && middle <= array.length-1){
            if (number < array[middle]){
                middle = middle/2;
            } else if (number > array[middle]) {
            middle = (middle + array.length-1)/2;
            } else{
                index = middle +1;
                break;
            }
        }
        System.out.print("aradığınız sayının bulunduğu sıra: " + index);

    }

    // sorting array in increased order (with selection sort)
    static int[] selectionSort(int[] arr) {
        //i sabit index
        //j gezen index

        for (int i = 0; i < arr.length - 1; i++) {
            int iMin = i; // minimun sayının indexi
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[iMin] > arr[j]) {
                    iMin = j;
                }
            }
            if (i != iMin)
                swap(i, iMin, arr);
        }
        return arr;
    }

    public static void swap(int k, int indexMin, int[] arr) {
        int term = arr[k];
        arr[k] = arr[indexMin];
        arr[indexMin] = term;
    }
}