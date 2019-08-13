package com.wenyao.observemode;

import java.util.List;

import com.google.common.collect.Lists;

public class UserTwo implements Observable, Observer {

    private List<Observer> observerList;
    private String name;

    public UserTwo(String name) {
        this.name = name;
        observerList = Lists.newLinkedList();
    }

    public void sendMessage(String message) {
        notifyObserver(message);
    }

    @Override
    public void addObserver(Observer observer) {
        this.observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observerList.remove(observer);
    }

    @Override
    public void notifyObserver(String message) {
        this.observerList.forEach(observer -> observer.update(name, message));
    }

    @Override
    public void update(String name, String message) {
        System.out.println("【" + this.name + "】看到【" + name + "】发的朋友圈：" + message);
    }

    @Override
    public void cancel(Observer observer) {
        this.removeObserver(observer);
    }
}
