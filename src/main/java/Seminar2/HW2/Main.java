package Seminar2.HW2;

public class Main {
    public static void main(String[] args) {

        int [] array = {1, -2, 4, 2, 0, 1, 10, 3, 0};
        System.out.println(countEvents(array));
        System.out.println(differenceMaxMin(array));
        System.out.println(checkAdjacentNull(array));
    }

    /**
     * ћетод, возвращающий истину, если в переданном массиве есть два соседних элемента, с нулевым значением.
     * @param array массив элементов int
     * @return true, если в массиве есть два подр€д идущих 0
     */
    private static boolean checkAdjacentNull(int[] array) {
        boolean check = false;
        int arrayLength = array.length;
        for (int i = 0; i < arrayLength-1 && !check; i++) {
            if (array[i] == 0 && array[i+1] == 0)
                check = true;
        }
        return check;
    }

    /**
     * метод возвращает разницу между самым большим и самым маленьким элементами переданного не пустого массива.
     * @param array массив элементов int
     * @return разница между максимальным и минимальным элементами массива
     */
    private static int differenceMaxMin(int[] array) {
        int min = array[0];
        int max = array[0];

        for (int number : array) {
            if (min > number) min = number;
            if (max < number) max = number;
        }

        return max-min;
    }

    /**
     * ћетод возвращает кол-во четных элементов массива
     * @param array массив элементов int
     * @return кол-во четных элементов полученного массива
     */
    private static int countEvents(int[] array) {
        int count = 0;
        for (int number : array) {
            if (number % 2 == 0) {
                count++;
            }
        }
        return count;
    }
}
