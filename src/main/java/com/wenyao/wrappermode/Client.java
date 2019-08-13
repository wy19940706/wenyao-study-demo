package com.wenyao.wrappermode;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by Think on 2019/5/12
 */
public class Client {
    public static void main(String[] args) throws FileNotFoundException {
        Cook cook1 = new WashHandsCook(new ChineseCooker());
        Cook cook2 = new WashHeadCook(new ChineseCooker());

        cook1.cookDinner();
        cook2.cookDinner();

        File file = new File("D:/ddd.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        DataInputStream inputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
    }
}
