package com.wenyao.concurrentdemo;

import java.util.Objects;

/**
 * @Description: 两个人AB通过一个账户A在柜台取钱和B在ATM机取钱
 * @Author: wy
 * @CreateDate: 2019/5/16 23:13
 */
public class BankTransfer {

    static Double money = 1000D;

    private void counter(Double money) {
        BankTransfer.money -= money;
        System.out.println("柜台取走" + money + "元钱，还剩" + BankTransfer.money + "元钱");
    }

    private void atm(Double money) {
        BankTransfer.money -= money;
        System.out.println("ATM取走" + money + "元钱，还剩" + BankTransfer.money + "元钱");
    }

    public synchronized void outMoney(Double money, String mode) {
        if (money > BankTransfer.money) {
            return;
        }
        if (Objects.equals("ATM", mode)) {
            atm(money);
        } else {
            counter(money);
        }
    }

    static class PerSonA implements Runnable {

        private BankTransfer bankTransfer;
        private String mode;

        public PerSonA(BankTransfer bankTransfer, String mode) {
            this.bankTransfer = bankTransfer;
            this.mode = mode;
        }

        @Override
        public void run() {
            while (BankTransfer.money >= 100) {
                bankTransfer.outMoney(100D, mode);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class PerSonB implements Runnable {

        private BankTransfer bankTransfer;
        private String mode;

        public PerSonB(BankTransfer bankTransfer, String mode) {
            this.bankTransfer = bankTransfer;
            this.mode = mode;
        }

        @Override
        public void run() {
            while (BankTransfer.money >= 200) {
                bankTransfer.outMoney(200D, mode);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        BankTransfer bankTransfer = new BankTransfer();
        PerSonA perSonA = new PerSonA(bankTransfer, "Counter");
        PerSonB perSonB = new PerSonB(bankTransfer, "ATM");
        Thread threadA = new Thread(perSonA);
        Thread threadB = new Thread(perSonB);
        threadA.start();
        threadB.start();
    }

}

