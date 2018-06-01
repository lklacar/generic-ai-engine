package com.lukaklacar.aiengine.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileUtil {

    public static String readDirectory(String path) {
        StringBuilder res = new StringBuilder();
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            File file = listOfFiles[i];
            if (file.isFile() && file.getName().endsWith(".txt")) {
                try {
                    String entireFileText = new Scanner(file)
                            .useDelimiter("\\A").next();
                    res.append(entireFileText);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return res.toString();
    }

}
