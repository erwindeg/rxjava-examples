package nl.edegier.rxjava.common;

/**
 * Created by Erwin on 17/06/2017.
 */
@FunctionalInterface
public interface Callback<T> {
    void handle(T t);
}
