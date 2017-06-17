package nl.edegier.rxjava.person.repository;


import io.reactivex.Observable;
import nl.edegier.rxjava.common.Callback;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Erwin on 17/06/2017.
 */
public class PersonRepository {
    public void findByName(String name, Callback<List<Person>> personResult){
        personResult.handle(Arrays.asList(new Person(),new Person()));
    }

    public void getIncome(Person person, Callback<BigDecimal> income) {
        income.handle(BigDecimal.valueOf(20000));
    }

    public Observable<Person> findByName(String name){
        return Observable.fromArray(new Person(),new Person());
    }

    public Observable<BigDecimal> getIncome(Person person) {
        return Observable.create(v -> v.onNext(new BigDecimal(20000)));
        //return new BigDecimal(20000);
    }
}
