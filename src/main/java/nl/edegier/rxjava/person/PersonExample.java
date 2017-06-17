package nl.edegier.rxjava.person;

import nl.edegier.rxjava.person.repository.PersonRepository;

import java.math.BigDecimal;

/**
 * Created by Erwin on 17/06/2017.
 */
public class PersonExample {

    PersonRepository repository = new PersonRepository();
    BigDecimal totalIncome = BigDecimal.ZERO;

    public void getIncomeForElderly() {
        repository.findByName("Erwin", persons ->
                persons.stream().filter(person -> person.getAge() >= 65).forEach(person -> {
                    repository.getIncome(person, income ->
                            totalIncome = totalIncome.add(income)
                    );
                })
        );
    }

    public void getIncomeForElderlyRX()  {
        repository.findByName("Erwin").filter(person -> person.getAge() >= 65)
                .flatMap(person -> repository.getIncome(person))
                .subscribe(income -> totalIncome = totalIncome.add(income));
    }

    public static void main(String[] args) {
        //new PersonExample().getIncomeForElderly();
        new PersonExample().getIncomeForElderlyRX();
    }
}
