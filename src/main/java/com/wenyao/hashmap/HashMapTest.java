package com.wenyao.hashmap;

import java.util.Map;

import com.google.common.base.Objects;
import com.google.common.collect.Maps;

public class HashMapTest {

    private static class Student {
        private Long id;
        private String name;

        public Student(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Student student = (Student) o;
            return Objects.equal(id, student.id) && Objects.equal(name, student.name);
        }

        @Override
        public int hashCode() {
            return 1;
        }
    }

    public static void main(String[] args) {
        Map<Student, String> hashMap = Maps.newHashMap();
        Student student = new Student(1L, "a");
        Student student2 = new Student(1L, "b");
        hashMap.put(student, "b");
        hashMap.put(student2, "c");
        String result = hashMap.get(student);
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= Integer.MAX_VALUE) ? Integer.MAX_VALUE : n + 1;
    }
}
