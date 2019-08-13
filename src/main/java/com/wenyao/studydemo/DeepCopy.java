package com.wenyao.studydemo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import cn.hutool.core.util.ObjectUtil;

/**
 * Created by Think on 2019/4/28
 */
public class DeepCopy {
    public static <T> List<T> deepCopy(List<T> src) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(src);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        List<T> dest = (List<T>) objectInputStream.readObject();
        return dest;
    }

    private static class Student implements Serializable {
        private String name;
        private Integer age;
        private Teacher teacher;

        public Student(String name, Integer age, Teacher teacher) {
            this.name = name;
            this.age = age;
            this.teacher = teacher;
        }

        public Teacher getTeacher() {
            return teacher;
        }

        public void setTeacher(Teacher teacher) {
            this.teacher = teacher;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }

    private static class Teacher implements Serializable {
        private String name;
        private Integer age;

        public Teacher(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Student> srcList = Lists.newArrayList(new Student("wenyao", 24, new Teacher("hello", 44)));
        List<Student> destListOne = deepCopy(srcList);
        List<Student> destList = ObjectUtil.clone(srcList);
        System.out.println(JSON.toJSONString(srcList));
        System.out.println(JSON.toJSONString(destListOne));
        System.out.println(JSON.toJSONString(destList));
    }
}
