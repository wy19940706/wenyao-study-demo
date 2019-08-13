package com.wenyao.concurrentdemo;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExchangerTestDemo {
    private static volatile boolean isDone = false;

    static class ExchangerProducer implements Runnable {
        private Exchanger<Integer> exchanger;
        private static int data = 1;

        public ExchangerProducer(Exchanger<Integer> exchanger) {
            this.exchanger = exchanger;
        }

        public void run() {
            while (!Thread.interrupted() && !isDone) {
                for (int i = 0; i <= 3; i++) {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        data = i;
                        System.out.println("Producer before:" + data);
                        exchanger.exchange(data);
                        System.out.println("Producer after:" + data);
                    } catch (InterruptedException e) {
                    }
                }
            }
            isDone = true;
        }
    }

    static class ExchangerConsumer implements Runnable {
        private Exchanger<Integer> exchanger;
        private static int data = 0;

        public ExchangerConsumer(Exchanger<Integer> exchanger) {
            this.exchanger = exchanger;
        }

        public void run() {
            while (!Thread.interrupted() && !isDone) {
                data = 0;
                System.out.println("consumer before:" + data);
                try {
                    TimeUnit.SECONDS.sleep(1);
                    exchanger.exchange(data);
                } catch (InterruptedException e) {
                }
                System.out.println("consume after:" + data);
            }

        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Exchanger<Integer> integerExchanger = new Exchanger<Integer>();
        ExchangerProducer exchangerProducer = new ExchangerProducer(integerExchanger);
        ExchangerConsumer exchangerConsumer = new ExchangerConsumer(integerExchanger);
        executorService.execute(exchangerProducer);
        executorService.execute(exchangerConsumer);
        executorService.shutdown();
        try {
            executorService.awaitTermination(30, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
        }
    }


}
