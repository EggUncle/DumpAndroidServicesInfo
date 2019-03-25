package com.egguncle.dumpandroidservicesinfo.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by egguncle on 18-7-2.
 */

public class FileUtil {

    public static void writeFile(String content,String fileName){
        File file = new File(fileName);
        if (!file.exists()) {
            if (file.getParentFile() == null) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (file.getParentFile().mkdirs()) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        BufferedWriter out = null;
        try {
            file.createNewFile();
            out = new BufferedWriter(new FileWriter(file));
            out.write(content);
            out.flush();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
