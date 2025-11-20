package javakurs.jimmy.tag5;

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        final Optional<Person> person = Optional.ofNullable(findPerson());
        if (person.isPresent()) {
            System.out.println(person.get());
        }

        person.ifPresent(System.out::println);

        final String nameWithC = person.map(Person::name)
                .filter(name -> name.startsWith("C"))
                .orElseThrow(() -> new RuntimeException(""));
    }

    private static Person findPerson() {
        return Math.random() < 0.5 ? null : new Person("", 20);
    }
}
