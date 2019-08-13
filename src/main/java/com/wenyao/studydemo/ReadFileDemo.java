package com.wenyao.studydemo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * try-with-resources
 */
public class ReadFileDemo {
    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        String result;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("text.txt"))) {
            result = bufferedReader.readLine();
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
