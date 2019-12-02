package com.wenyao.wenyaostudydemo;

import org.junit.Test;
import strman.Strman;

public class StrmanTest extends BaseTest {

    @Test
    public void strman() {
        String string = Strman.appendArray("w", new String[] {"e", "n", "y", "a", "o"});
        System.out.println(string);
    }

}
