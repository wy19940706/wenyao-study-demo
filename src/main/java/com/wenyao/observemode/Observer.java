package com.wenyao.observemode;

/**
 * 观察者
 */
public interface Observer {
    void update(String name, String message);

    void cancel(Observer observer);
}
