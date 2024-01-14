package Seminar2.HW2;

public class Main {
    public static void main(String[] args) {

        int [] array = {1, -2, 4, 2, 0, 1, 10, 3, 0};
        System.out.println(countEvents(array));
        System.out.println(differenceMaxMin(array));
        System.out.println(checkAdjacentNull(array));
    }

    /**
     * �����, ������������ ������, ���� � ���������� ������� ���� ��� �������� ��������, � ������� ���������.
     * @param array ������ ��������� int
     * @return true, ���� � ������� ���� ��� ������ ������ 0
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
     * ����� ���������� ������� ����� ����� ������� � ����� ��������� ���������� ����������� �� ������� �������.
     * @param array ������ ��������� int
     * @return ������� ����� ������������ � ����������� ���������� �������
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
     * ����� ���������� ���-�� ������ ��������� �������
     * @param array ������ ��������� int
     * @return ���-�� ������ ��������� ����������� �������
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
