package nl.edegier.rxjava.filereader;

import io.reactivex.Observable;

public class Test {

	public static void main(String[] args) {
		hello("erwin","ben");
	}
	
	public static void hello(String... names) {
	    Observable.fromArray(names).subscribe(s -> System.out.println(s));
	}

}
