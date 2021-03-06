package com.wenyao.studydemo;

import cn.hutool.core.io.FileUtil;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wenyao
 * @Description
 * @Date 2021/1/22 下午5:35
 */
public class CompareTest {

    public static void main(String[] args) {
        CompareTest text = new CompareTest();
        text.read();
    }

    public void read() {
        String s;
        BufferedReader bufferedReader1 = null;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader1 = new BufferedReader(
                    new InputStreamReader(new FileInputStream(FileUtil.newFile("/Users/wenyao/Downloads/1.txt"))));
            bufferedReader2 = new BufferedReader(
                    new InputStreamReader(new FileInputStream(FileUtil.newFile("/Users/wenyao/Downloads/2.txt"))));
            ArrayList<String> arrayList1 = new ArrayList<>();
            ArrayList<String> arrayList2 = new ArrayList<>();
            while ((s = bufferedReader1.readLine()) != null) {
                arrayList1.add(s);
            }
            while ((s = bufferedReader2.readLine()) != null) {
                arrayList2.add(s);
            }
            List<String> collect =
                    arrayList2.stream().filter(s1 -> !arrayList1.contains(s1)).collect(Collectors.toList());
            System.out.println(collect);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            if (bufferedReader1 != null) {
                try {
                    bufferedReader1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
