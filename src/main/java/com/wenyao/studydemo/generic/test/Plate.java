package com.wenyao.studydemo.generic.test;

public class Plate<T> {
    T item;

    public Plate(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public static void main(String[] args) {
        Plate<? extends Fruit> plate = new Plate<Apple>(new Apple());
        // plate.setItem(new Fruit());
        // plate.setItem(new Apple());
        Fruit fruit = plate.getItem();
        // Apple apple = plate.getItem();
        Object object = plate.getItem();
        Plate<? super Fruit> plate1 = new Plate<Fruit>(new Apple());

        plate1.setItem(new Fruit());
        plate1.setItem(new Apple());
        Object item = plate1.getItem();
        // Apple apple = plate1.getItem();
        // Fruit fruit1 = plate1.getItem();
    }
}
