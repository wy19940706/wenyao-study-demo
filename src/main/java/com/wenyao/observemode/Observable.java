package com.wenyao.observemode;

/**
 * 被观察者
 */
public interface Observable {

    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObserver(String message);
}
