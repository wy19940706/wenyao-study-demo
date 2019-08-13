package com.wenyao.studydemo.annotation;

/**
 * Created by Think on 2019/2/18
 */
public class User {
    private String name;
    private String age;

    @Check
    public String getName() {
        return name;
    }

    @Init(value = "wenyao")
    public void setName(String name) {
        this.name = name;
    }

    @Check
    public String getAge() {
        return age;
    }

    @Init(value = "24")
    public void setAge(String age) {
        this.age = age;
    }
}
