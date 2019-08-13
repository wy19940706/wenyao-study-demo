package com.wenyao.studydemo.builderdemo;

/**
 * Created by Think on 2019/4/8
 */
public class User {
    private String name;
    private int age;
    private int length;

    public User(String name, int age, int length) {
        this.name = name;
        this.age = age;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    private User(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.length = builder.length;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", length=" + length +
                '}';
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {

        private String name;
        private int age;
        private int length;

        private Builder() {
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder length(int length) {
            this.length = length;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

}
