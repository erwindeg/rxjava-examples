package nl.edegier.rxjava.basic;

import io.reactivex.Flowable;
import io.reactivex.annotations.NonNull;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 * Created by Erwin on 17/06/2017.
 */
public class SubcriberPublisher {


    public static void main(String[] args) throws InterruptedException {
        Publisher<Integer> intProducer = Flowable.just(1, 2, 3);

        intProducer.subscribe(new Subscriber<Integer>() {
            @Override
            public void onSubscribe(@NonNull Subscription subscription) {
                System.out.println("subscribed");
                subscription.request(Integer.MAX_VALUE);
            }

            @Override
            public void onNext(@NonNull Integer integer) {
                System.out.println(integer);
            }

            @Override
            public void onError(@NonNull Throwable throwable) {
                System.out.println("Error");
            }

            @Override
            public void onComplete() {
                System.out.println("completed");
            }
        });

        Flowable<Integer> ints = Flowable.range(0,100);

        ints.filter(i -> i%2 == 0).map(even -> even/2).subscribe(System.out::println);

        Thread.sleep(10000);
    }

}
