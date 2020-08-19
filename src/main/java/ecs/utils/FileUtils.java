package ecs.utils;

import ecs.graphics.Constants;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileUtils {

    public static String loadAsString(String path) {
        StringBuilder result = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(Constants.RESOURCES_PATH + path));
            String buffer = "";
            while ((buffer = reader.readLine()) != null) {
                result.append(buffer + '\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}
