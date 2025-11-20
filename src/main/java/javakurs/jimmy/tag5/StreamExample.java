package javakurs.jimmy.tag5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        final List<Person> persons = new ArrayList<>();

        final Optional<Person> first = persons.stream().filter(p -> p.age() >= 18).findFirst();
    }

    private static List<String> getNames(List<Person> persons) {
        List<String> names = new ArrayList<>();
        for (final Person person : persons) {
            names.add(person.name());
        }
        return Collections.unmodifiableList(names);
    }

    private static List<String> getNames2(List<Person> persons) {
        //mutable
        return persons.stream().map(Person::name).collect(Collectors.toList());
    }

    private static List<String> getNames3(List<Person> persons) {
        //immutable
        return persons.stream().map(Person::name).toList();
    }
}
