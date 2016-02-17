package rxjava;

import rx.Observable;

public class Test {

	public static void main(String[] args) {
		hello("erwin","ben");
	}
	
	public static void hello(String... names) {
	    Observable.from(names).subscribe(s -> System.out.println(s));	 
	}

}
