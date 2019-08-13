package com.wenyao.observemode;

public class Client {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        UserTwo tom = new UserTwo("Tom");
        UserTwo bob = new UserTwo("Bob");
        UserTwo alice = new UserTwo("Alice");
        tom.addObserver(bob);
        tom.addObserver(alice);
        tom.sendMessage("今天真开心");
        tom.removeObserver(bob);
        tom.sendMessage("天天都开心");
    }
}
