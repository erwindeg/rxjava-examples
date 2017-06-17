package nl.edegier.rxjava.event;

import io.reactivex.Observable;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Erwin on 17/06/2017.
 */
public class Events {

    public static void main(String[] args) {
         Observable.create(observableEmitter -> {
             final KeyListener listener = new KeyListener() {
                 @Override
                 public void keyPressed(KeyEvent event) {
                     observableEmitter.onNext(event);
                 }

                 @Override
                 public void keyReleased(KeyEvent event) {
                     observableEmitter.onNext(event);
                 }

                 @Override
                 public void keyTyped(KeyEvent event) {
                     observableEmitter.onNext(event);
                 }
             };
         });
    }
}
