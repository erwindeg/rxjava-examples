package nl.edegier.rxjava.basic;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Created by Erwin on 17/06/2017.
 */
public class JavaStreams {

    public static void main(String[] args) throws InterruptedException {
        List<Long> numbers = Arrays.asList(1l,2l,3l,4l,5l,6l,7l,8l);

        List<Long> evens = numbers.stream().filter(x -> x%2 ==0).collect(Collectors.toList());

        evens.forEach(System.out::println);

        Observable<Long> infiniteNumbers = Observable.interval(1, TimeUnit.SECONDS);

        Observable<Long> infiniteEvens = infiniteNumbers.filter(x -> x%2 ==0);

        infiniteEvens.subscribe(System.out::println);

        Thread.sleep(100000);
    }
}
