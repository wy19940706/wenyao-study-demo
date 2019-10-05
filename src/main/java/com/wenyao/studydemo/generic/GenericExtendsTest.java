package com.wenyao.studydemo.generic;

public class GenericExtendsTest<T extends GenericExtendsTest.Animal> {

    private T t;

    public GenericExtendsTest(T t) {
        this.t = t;
    }

    public void testDog() {
        t.dog();
    }

    public void testCat() {
        t.cat();
    }

    public static void main(String[] args) {
        GenericExtendsTest<Animal> dogGenericExtendsTest = new GenericExtendsTest<>(new DogImpl());
        dogGenericExtendsTest.testCat();
        dogGenericExtendsTest.testDog();
    }

    interface Animal {
        void dog();

        void cat();
    }

    static class DogImpl implements Animal {

        @Override
        public void dog() {
            System.out.println("this is a dog");
        }

        @Override
        public void cat() {
            System.out.println("this is a cat");
        }
    }

}


