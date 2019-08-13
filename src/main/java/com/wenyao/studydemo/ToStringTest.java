package com.wenyao.studydemo;

/**
 * Created by Think on 2019/4/26
 */
public class ToStringTest {
    private String name;
    private Integer age;
    private StudyData studyData;

    public ToStringTest(String name, Integer age, StudyData studyData) {
        this.name = name;
        this.age = age;
        this.studyData = studyData;
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

    public StudyData getStudyData() {
        return studyData;
    }

    public void setStudyData(StudyData studyData) {
        this.studyData = studyData;
    }

    @Override
    public String toString() {
        return "ToStringTest{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", studyData=" + studyData +
                '}';
    }

    public static void main(String[] args) {
        ToStringTest toStringTest = new ToStringTest("wenyao", 24, new StudyData(12, "hello"));
        System.out.println(toStringTest.toString());
    }
}

class StudyData {
    private Integer a;
    private String b;

    public StudyData(Integer a, String b) {
        this.a = a;
        this.b = b;
    }

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "StudyData{" +
                "a=" + a +
                ", b='" + b + '\'' +
                '}';
    }

}
