package Seminar5.HW;
//Написать функцию, создающую резервную копию всех файлов в директории(без поддиректорий) во вновь созданную папку ./backup

import java.io.*;

public class Task1 {
    public static void main(String[] args) {
        String sourceDirectory = "src/main/java/Seminar4/Shop";
        String backUpDirectory = "src/main/java/Seminar5/HW/backup";
        createBackUp (sourceDirectory, backUpDirectory);
    }

    private static void createBackUp(String sourceDirectory, String backUpDirectory) {
        File source = new File(sourceDirectory);
        File backUp = new File(backUpDirectory);
        if(!source.exists() || !source.isDirectory()) {
            System.out.println("Исходной директории не существует или указанный путь  не является директорией");
        }
        if (!backUp.exists()) {
            backUp.mkdir();
        }
        File [] files = source.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                String fileName = file.getName();
                String backUpFilePath = backUpDirectory + "/" + fileName;
                try (FileInputStream fis = new FileInputStream(file);
                     FileOutputStream fos = new FileOutputStream(backUpFilePath);
                     BufferedInputStream bis = new BufferedInputStream(fis);
                     BufferedOutputStream bos = new BufferedOutputStream(fos)) {
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = bis.read(buffer)) != -1) {
                        bos.write(buffer, 0, bytesRead);
                    }
                } catch (IOException e) {
                    System.out.println("Ошибка при создании резервной копии файла " + fileName + ": " + e.getMessage());
                }
            }
        }
        System.out.println("Резервные копии всех файлов в директории " + sourceDirectory + " были успешно созданы в " + backUpDirectory);
    }
}
