package Seminar5.HW;
//ѕредположить, что числа в исходном массиве из 9 элементов имеют диапазон[0, 3],
// и представл€ют собой, например, состо€ни€ €чеек пол€ дл€ игры в крестикинолики,
// где 0 Ц это пустое поле, 1 Ц это поле с крестиком, 2 Ц это поле с ноликом, 3 Ц резервное значение.
// “акое предположение позволит хранить в одном числе типа int всЄ поле 3х3. «аписать в файл 9 значений так, чтобы они зан€ли три байта.

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Task2 {
    public static void main(String[] args) {
        int[] data = {0, 2, 0, 1, 3, 0, 2, 2, 1}; // ѕример массива значений полей
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
     * метод считывает из файла массив байт и возвращает его
     * @param dataStorage - путь к файлу и название файла
     * @return возвращает считанный массив байт
     */
    private static byte[] readFromFile(String dataStorage) {
        byte [] byteArray = null;
        try {
            FileInputStream fis = new FileInputStream(dataStorage);
            BufferedInputStream bis = new BufferedInputStream(fis);
            int fileSize = bis.available();
            byteArray = new byte[fileSize];
            int bytesNumber = bis.read(byteArray);
            System.out.println("ѕрочитано " + bytesNumber + " байт");
            bis.close();
            fis.close();
        } catch (IOException e){
            System.out.println("ќшибка при чтении данных из файла" + e.getMessage());
        }
        return byteArray;
    }

    /**
     * ћетод получает массив байт и записывает его в файл txt
     * @param compressedData массив байт, который получает метод
     * @param dataStorage путь к файлу и название файла
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
     * ћетод получает массив byte, содержащий двоичное представление чисел, и переводит его в массив int, содержащий дес€тичное представление этих чисел
     * @param compressedData вход€щий массив byte, содержаший двоичное представление чисел
     * @return возвращаемый массив int, содержаший дес€тичное представление чисел
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
     * ћетод получает массив int чисел в дес€тичной форме представлени€ и сжимает его в массив байт,
     * упаковыва€ несколько чисел массива int в одно число массива byte  в двоичном представлении
     * @param data - получаемый на вход массив Int  с числами в дес€тичной форме представлени€ (значени€ €чеек должны быть не более или равны 3)
     * @param compressedArrayLength - желаемый размер сжатого массива
     * @return - возвращает массив byte  с числами в двоичной форме представлени€
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

