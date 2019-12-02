package com.wenyao.wenyaostudydemo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import javax.validation.constraints.NotNull;

import cn.hutool.core.util.ObjectUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.collections.Maps;

import com.google.common.collect.Lists;

import cn.hutool.core.lang.Console;
import cn.hutool.json.JSONUtil;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RxJavaDemoTest {

    @Test
    public void flatMap() {
        String[] strings = {"Hello", "World"};
        Stream.of(strings).map(e -> e.split("")).flatMap(Arrays::stream).forEach(e -> System.out.print(e + " "));
    }

    @Test
    public void mergeMap() {
        @Getter
        @Setter
        @AllArgsConstructor
        class Account {
            private Long accountId;
            private Integer amount;
        }

        List<Account> accounts = Lists.newArrayList(new Account(1L, 3), new Account(1L, -5), new Account(1L, 44),
                new Account(2L, -5), new Account(2L, 88), new Account(2L, -9));
        Map<Long, Integer> hashMap = Maps.newHashMap();
        accounts.forEach(e -> hashMap.merge(e.getAccountId(), e.getAmount(), Integer::sum));
        cn.hutool.core.lang.Console.log(JSONUtil.toJsonStr(hashMap));
        List<String> list = Lists.newArrayList("hello", "world", "hello", "haixue", "alibaba", "ant", "haixue");
        Map<String, Integer> map = Maps.newHashMap();
        // v1
        list.forEach(e -> {
            map.putIfAbsent(e, 0);
            map.put(e, map.get(e) + 1);
        });
        Console.log(map);
        map.clear();
        // v2
        list.forEach(e -> {
            map.putIfAbsent(e, 0);
            map.computeIfPresent(e, (w, prev) -> prev + 1);
        });
        Console.log(map);
        map.clear();
        // v3
        list.forEach(e -> map.merge(e, 1, Integer::sum));
        Console.log(map);
    }

    @Test
    public void testMapCompute() {
        // map compute
        Map<Integer, Integer> computeMap = Maps.newHashMap();
        for (int i = 0; i < 3; i++) {
            computeMap.compute(1, (v1, v2) -> ObjectUtil.isNull(v2) ? 1 : v1 + v2);
            Console.log(computeMap);
        }
    }

    @Test
    public void test0() {
        Flowable.just(1, 1, 2, 2, 3, 4, 5).subscribe(System.out::println);
    }

    @Test
    public void test1() throws InterruptedException {
        Disposable disposable = Flowable.just("Hello world!")
                .delay(1, TimeUnit.SECONDS)
                .subscribeWith(new DisposableSubscriber<String>() {
                    @Override
                    public void onStart() {
                        System.out.println("Start!");
                        request(1);
                    }

                    @Override
                    public void onNext(String string) {
                        System.out.println(string);
                        request(1);
                    }

                    @Override
                    public void onError(Throwable string) {
                        string.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Done!");
                    }
                });
        Thread.sleep(500);
        // the sequence can now be cancelled via dispose()
        disposable.dispose();
    }

    @Test
    public void test2() {
        Flowable<Integer> flowable = Flowable.range(1, 5).map(v -> v * v).filter(v -> v % 3 == 0);
        flowable.subscribe(System.out::println);
    }

    @Test
    public void test3() {
        Observable.create(emitter -> {
            while (!emitter.isDisposed()) {
                long time = System.currentTimeMillis();
                emitter.onNext(time);
                if (time % 2 != 0) {
                    emitter.onError(new IllegalStateException("Odd millisecond"));
                    break;
                }
            }
        }).subscribe(System.out::println, Throwable::printStackTrace);
    }

    @Test
    public void test4() throws InterruptedException {
        Flowable.fromCallable(() -> {
            Thread.sleep(1000);
            return "Done";
        })
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.single())
                .subscribe(System.out::println, Throwable::printStackTrace);
        Thread.sleep(2000);
    }

    @Test
    public void test5() {
        Flowable.range(1, 10)
                .observeOn(Schedulers.computation())
                .map(v -> v * v)
                .blockingSubscribe(System.out::println);
    }

    @Test
    public void test6() {
        Flowable.range(1, 10)
                .flatMap(v -> Flowable.just(v).subscribeOn(Schedulers.computation()).map(w -> w * w))
                .blockingSubscribe(System.out::println);
    }

    @Test
    public void test7() {
        Observable.create((ObservableOnSubscribe<Integer>) emitter -> {
            System.out.println("Observale emit 1");
            emitter.onNext(1);
            System.out.println("Observale emit 2");
            emitter.onNext(2);
            System.out.println("Observale emit 3");
            emitter.onNext(3);
            emitter.onComplete();
            System.out.println("Observale emit 4");
            emitter.onNext(4);
        }).subscribe(new Observer<Integer>() {

            private int i;
            private Disposable disposable;

            @Override
            public void onSubscribe(@NotNull Disposable d) {
                System.out.println("onSubscribe: " + d.isDisposed());
                disposable = d;
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext value: " + integer);
                i++;
                if (i == 2) {
                    disposable.dispose();
                    System.out.println("onNext dispose: " + disposable.isDisposed());
                }
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError: " + e.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        });
    }

    @Test
    public void test8() {
        Observable.create((ObservableOnSubscribe<Integer>) emitter ->

        {
            emitter.onNext(1);
            emitter.onNext(2);
            emitter.onNext(3);
        }).map(integer -> "this is result: " + integer).subscribe(string -> System.out.println("accpet: " + string));
    }

    @Test
    public void test9() {
        Observable.zip(getStringObserverable(), getIntegerObservable(), (string, integer) -> string + integer)
                .subscribe(s -> System.out.println("accept: " + s));
    }

    private static Observable<Integer> getIntegerObservable() {
        return Observable.create(emitter -> {
            emitter.onNext(1);
            emitter.onNext(2);
            emitter.onNext(3);
            emitter.onNext(4);
        });
    }

    private static Observable<String> getStringObserverable() {
        return Observable.create(emitter -> {
            emitter.onNext("A");
            emitter.onNext("B");
            emitter.onNext("C");
        });
    }

    @Test
    public void test10() {
        Observable.concat(Observable.just(1, 2, 3), Observable.just(4, 5, 6))
                .subscribe(integer -> System.out.println(integer));
    }

    @Test
    public void test11() {
        Observable.create((ObservableOnSubscribe<Integer>) emitter -> {
            emitter.onNext(1);
            emitter.onNext(2);
            emitter.onNext(3);
        }).flatMap((Function<Integer, ObservableSource<String>>) integer -> {

            List<String> list = Lists.newArrayList();
            for (int i = 0; i < 3; i++) {
                list.add("I am value " + integer);
            }
            int delayTime = (int) (1 + Math.random() * 10);
            return Observable.fromIterable(list).delay(delayTime, TimeUnit.MICROSECONDS);
        }).subscribeOn(Schedulers.newThread()).subscribe(s -> System.out.println(s));
    }

    @Test
    public void test12() {
        Observable.create((ObservableOnSubscribe<Integer>) emitter -> {
            emitter.onNext(1);
            emitter.onNext(2);
            emitter.onNext(3);
        }).concatMap((Function<Integer, ObservableSource<String>>) integer -> {
            List<String> list = Lists.newArrayList();
            for (int i = 0; i < 3; i++) {
                list.add("I am value " + integer);
            }
            int delayTime = (int) (1 + Math.random() * 10);
            return Observable.fromIterable(list).delay(delayTime, TimeUnit.MICROSECONDS);
        }).subscribeOn(Schedulers.newThread()).subscribe(s -> System.out.println(s));
    }

    @Test
    public void filter() {
        Flowable.just(1, 2, 3, 55, 33).filter(e -> e > 10).subscribe(e -> System.out.println(e));
    }

    @Test
    public void buffer() {
        Observable.just(1, 2, 3, 4, 5).buffer(3, 2).subscribe(e -> System.out.println(e));
    }

    @Test
    public void onNext() {
        Observable.just(1, 2, 3, 4, 5)
                .doOnNext(e -> System.out.println("保存： " + e))
                .subscribe(e -> System.out.println("消费： " + e));
    }

    @Test
    public void skip() {
        Flowable.just(1, 2, 3, 4, 5).skip(2).subscribe(e -> System.out.println(e));
    }

    @Test
    public void take() {
        Flowable.fromArray(1, 2, 3, 4, 5).take(2).subscribe(e -> System.out.println(e));
    }

    @Test
    public void single() {
        Single.just(new Random().nextInt()).subscribe(new SingleObserver<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(@NotNull Integer integer) {
                System.out.println(integer);
            }

            @Override
            public void onError(@NotNull Throwable e) {
                System.out.println(e);
            }
        });
    }

    /**
     * 去除发送频率过快的项
     */
    @Test
    public void debounce() {
        Observable.create((ObservableOnSubscribe<Integer>) emitter -> {
            emitter.onNext(1);
            Thread.sleep(400);
            emitter.onNext(2);
            Thread.sleep(500);
            emitter.onNext(3);
            Thread.sleep(100);
            emitter.onNext(4);
            Thread.sleep(1000);
            emitter.onComplete();
        }).debounce(500, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).subscribe(e -> System.out.println(e));
    }

    @Test
    public void timer() {
        System.out.println("开始时间：" + System.currentTimeMillis());
        Observable.timer(2, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .subscribe(e -> System.out.println("结束时间：" + System.currentTimeMillis()));
    }

    @Test
    public void interval() {
        Observable.interval(3, 2, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).subscribe(e -> System.out.println(e));
    }

    @Test
    public void defer() {
        Observable<Integer> observable = Observable.defer(() -> Observable.just(1, 2, 3));
        observable.subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {
                System.out.println(integer);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println(e);
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        });
    }

    @Test
    public void last() {
        Flowable.just(1, 2, 3).last(4).subscribe(e -> System.out.println(e));
    }

    @Test
    public void merge() {
        Observable.merge(Observable.just(1, 2, 3), Observable.just(4, 5, 6)).subscribe(e -> System.out.println(e));
    }

    @Test
    public void reduce() {
        Observable.just(1, 2, 3)
                .reduce((integer, integer2) -> integer + integer2)
                .subscribe(e -> System.out.println(e));
    }

    @Test
    public void scan() {
        Observable.just(1, 2, 3).scan((e1, e2) -> e1 + e2).subscribe(e -> System.out.println(e));
    }

    @Test
    public void window() {

    }
}
