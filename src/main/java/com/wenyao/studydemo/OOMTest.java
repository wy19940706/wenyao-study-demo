package com.wenyao.studydemo;

import java.util.LinkedList;

/**
 * Created by Think on 2019/1/15
 */
public class OOMTest {
    public static void main(String[] args) {
        LinkedList<OOMTest> linkedList = new LinkedList<>();
        while (true) {
            linkedList.add(new OOMTest());
        }
    }
}
