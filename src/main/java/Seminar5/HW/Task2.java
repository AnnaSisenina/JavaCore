package Seminar5.HW;
//������������, ��� ����� � �������� ������� �� 9 ��������� ����� ��������[0, 3],
// � ������������ �����, ��������, ��������� ����� ���� ��� ���� � ��������������,
// ��� 0 � ��� ������ ����, 1 � ��� ���� � ���������, 2 � ��� ���� � �������, 3 � ��������� ��������.
// ����� ������������� �������� ������� � ����� ����� ���� int �� ���� 3�3. �������� � ���� 9 �������� ���, ����� ��� ������ ��� �����.

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Task2 {
    public static void main(String[] args) {
        int[] data = {0, 2, 0, 1, 3, 0, 2, 2, 1}; // ������ ������� �������� �����
        int compressedDataLength = 3;
        byte[] compressedData = compressData(data, compressedDataLength);
        String dataStorage = "src/main/java/Seminar5/HW/data.txt";
        writeToFile(compressedData, dataStorage);
        int [] afterCompress = readByteData(readFromFile(dataStorage));
        for (int compress : afterCompress) {
            System.out.print(compress + " ");
        }
    }

    /**
     * ����� ��������� �� ����� ������ ���� � ���������� ���
     * @param dataStorage - ���� � ����� � �������� �����
     * @return ���������� ��������� ������ ����
     */
    private static byte[] readFromFile(String dataStorage) {
        byte [] byteArray = null;
        try {
            FileInputStream fis = new FileInputStream(dataStorage);
            BufferedInputStream bis = new BufferedInputStream(fis);
            int fileSize = bis.available();
            byteArray = new byte[fileSize];
            int bytesNumber = bis.read(byteArray);
            System.out.println("��������� " + bytesNumber + " ����");
            bis.close();
            fis.close();
        } catch (IOException e){
            System.out.println("������ ��� ������ ������ �� �����" + e.getMessage());
        }
        return byteArray;
    }

    /**
     * ����� �������� ������ ���� � ���������� ��� � ���� txt
     * @param compressedData ������ ����, ������� �������� �����
     * @param dataStorage ���� � ����� � �������� �����
     */
    private static void writeToFile(byte[] compressedData, String dataStorage) {
        try (FileOutputStream fos = new FileOutputStream(dataStorage))
        {
            fos.write(compressedData);
        } catch (IOException e)
        {
    e.printStackTrace();
        }
    }

    /**
     * ����� �������� ������ byte, ���������� �������� ������������� �����, � ��������� ��� � ������ int, ���������� ���������� ������������� ���� �����
     * @param compressedData �������� ������ byte, ���������� �������� ������������� �����
     * @return ������������ ������ int, ���������� ���������� ������������� �����
     */
    private static int[] readByteData(byte[] compressedData) {
        int [] newData = new int [compressedData.length * 3];
        int newDataIndex = 0;
        for (byte compressedDatum : compressedData) {
            newData[newDataIndex] = (compressedDatum >> 4) & 0x03;
            newDataIndex++;
            newData[newDataIndex] = (compressedDatum >> 2) & 0x03;
            newDataIndex++;
            newData[newDataIndex] = compressedDatum & 0x03;
            newDataIndex++;
        }

        return newData;
    }

    /**
     * ����� �������� ������ int ����� � ���������� ����� ������������� � ������� ��� � ������ ����,
     * ���������� ��������� ����� ������� int � ���� ����� ������� byte  � �������� �������������
     * @param data - ���������� �� ���� ������ Int  � ������� � ���������� ����� ������������� (�������� ����� ������ ���� �� ����� ��� ����� 3)
     * @param compressedArrayLength - �������� ������ ������� �������
     * @return - ���������� ������ byte  � ������� � �������� ����� �������������
     */
    private static byte[] compressData(int[] data, int compressedArrayLength) {
        byte[] compressedData = new byte[compressedArrayLength];
        int compressedDataIndex = 0;
        for (int i = 0; i < data.length; i +=3) {
            compressedData[compressedDataIndex] = (byte) ((data[i] << 4) | (data[i + 1]) << 2 | (data[i + 2]));
            compressedDataIndex++;
        }
        return compressedData;
    }
}

