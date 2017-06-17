package nl.edegier.rxjava.filereader;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 * Created by Erwin on 17/02/16.
 */
public class Main {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        AsyncFileReader am1 = new AsyncFileReader("readfile1.txt");
        AsyncFileReader am2 = new AsyncFileReader("readfile2.txt");
        AsyncFileReader am3 = new AsyncFileReader("readfile3.txt");

        am1.invoke(System.out::println);
        am2.invoke(System.out::println);
        am3.invoke(System.out::println);

//        System.out.println("test");
        while(true){


        }
    }
}
