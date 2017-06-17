package nl.edegier.rxjava.basic;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by Erwin on 17/06/2017.
 */
public class ObserverObservable {
    public static void main(String[] args) {
        Observable<Integer> intObservable = Observable.create(observableEmitter -> {
            observableEmitter.onNext(1);
            observableEmitter.onNext(2);
            observableEmitter.onNext(3);
            observableEmitter.onComplete();
        });

        intObservable.subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable disposable) {
                System.out.println("subscribed");
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

        intObservable.map(i -> i*2).filter(p -> p > 4).subscribe(value -> System.out.println(value));
    }


}
