package Seminar2.Seminar;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

// task #1
        int size = 5;
// System.out.println(print2DArray(fileDiagonals(size)));

// task #2 Написать функцию добавления элемента в конец массива таким образом, чтобы она расширяла массив при необходимости.
        int[] arr = new int[size];
        for (int i = 0; i < size * 3; i++) {
            arr = addItem(arr, 5, i);
            System.out.println(print1DArray(arr));
        }

    }

    public static int[][] fileDiagonals(int size) {
        int arr[][] = new int[size][size];

        for (int i = 0; i < size; i++) {
            arr[i][i] = 1;
            arr[i][size - 1 - i] = 1;
        }
        return arr;
    }

    public static String print1DArray(int[] arr) {
        String res = "";

        for (int i = 0; i < arr.length; i++) {
            res += arr[i] + "\t";
        }
        return res;
    }

    public static String print2DArray(int[][] arr) {
        String res = "";

        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                res += arr[i][j] + "\t";
            }
            res += "\n";

        }
        return res;
    }

    public static int[] addItem(int[] arr, int value, int index) {

        int[] arrNew;

        if (index == arr.length) {
// arrNew = Arrays.copyOf(arr, 2 * index);
            arrNew = new int[2 * index];
            System.arraycopy(arr, 0, arrNew, 0, arr.length);
        } else {
            arrNew = arr;
        }

        arrNew[index] = value;

        return arrNew;
    }

}