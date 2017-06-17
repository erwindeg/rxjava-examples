package nl.edegier.rxjava.time;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

/**
 * Created by Erwin on 17/06/2017.
 */
public class Timer {

    public static void main(String[] args) throws InterruptedException {

        Observable timer = Observable.interval(1, TimeUnit.SECONDS);

        timer.subscribe(System.out::println);



        Thread.sleep(100000);
    }
}
