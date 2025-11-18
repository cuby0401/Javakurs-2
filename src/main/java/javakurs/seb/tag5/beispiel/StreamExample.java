package javakurs.seb.tag5.beispiel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StreamExample
{
    public static void main(String[] args) {
        final List<Person> persons = new ArrayList<>();

        //final Optional<Person> first = persons.stream().filter((Person p) -> p.age() >= 18).findFirst();
    }

    private static List<String> getNames(List<Person> persons)
    {
        List<String> names = new ArrayList<>();
        for (Person person : persons)
        {
            //names.add(person.name());
        }
        return Collections.unmodifiableList(names);
    }

    //private static List<String> getNames2(List<Person> persons)
    //{
      //  return persons.stream().map(Person::name).collect(Collectors.toList());
    //}

    //private static List<String> getNames3(List<Person> persons)
    //{
      //  return persons.stream().map(Person::name).toList();
    //}
}