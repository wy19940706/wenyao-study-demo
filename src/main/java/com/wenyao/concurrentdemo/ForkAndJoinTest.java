package com.wenyao.concurrentdemo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * Created by Think on 2019/1/23
 */
public class ForkAndJoinTest extends RecursiveTask<Integer> {
    private static final Integer CHILD_TASK_COUNT = 2;
    private int start;
    private int end;

    public ForkAndJoinTest(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkAndJoinTest forkAndJoinTest = new ForkAndJoinTest(1, 4);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Future<Integer> sum = forkJoinPool.submit(forkAndJoinTest);
        System.out.println(sum.get());
    }

    /**
     * The main computation performed by this task.
     *
     * @return the result of the computation
     */
    @Override
    protected Integer compute() {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            boolean canCompute = (end - start) <= CHILD_TASK_COUNT;
            if (canCompute) {
                sum += i;
            } else {
                int middleCount = (start + end) / 2;
                ForkAndJoinTest taskOne = new ForkAndJoinTest(start, middleCount);
                ForkAndJoinTest taskTwo = new ForkAndJoinTest(middleCount + 1, end);
                taskOne.fork();
                taskTwo.fork();
                Integer sum1 = taskOne.join();
                Integer sum2 = taskTwo.join();
                sum = sum1 + sum2;
            }
        }
        return sum;
    }
}