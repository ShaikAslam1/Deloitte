package Interview;

import java.util.*;
import java.util.stream.Collectors;

public class Spliterator {

    public static void main(String[] args) {

        List<String> listOfNames = Arrays.asList("Clint", "Gregory", "James", "John", "Humphrey",
                "Cary", "Kirk");

        java.util.Spliterator<String> spliterator = listOfNames.spliterator();

        // split into 2 parts
        java.util.Spliterator<String> stringSpliterator = spliterator.trySplit();

        if (stringSpliterator != null)
            while (stringSpliterator.tryAdvance(n -> System.out.println(n)));

        // print all using spliterator

        spliterator = listOfNames.spliterator();

        if (spliterator != null)
            while (spliterator.tryAdvance(System.out::println));

        List<Person> personList = new ArrayList<>();
        personList.add(new Person("William", "Shatner", 60));
        personList.add(new Person("William", "Brooks", 25));
        personList.add(new Person("Persis", "Khambatta", 50));
        personList.add(new Person("James", "Doohan", 70));
        personList.add(new Person("DeForest", "Kelley", 65));

        for (Person person: personList) {
            System.out.println(person);
        }

        System.out.println("\nSorted List:");
        Collections.sort(personList);
        personList.stream().forEach(System.out::println);

        System.out.println("\nAge Comparator:");
        Collections.sort(personList, Comparator.comparingInt(Person::getAge));
        personList.stream().forEach(System.out::println);

        List<Student> students = new ArrayList<>();
        students.add(new Student("William", "Shatner", 60));
        students.add(new Student("William", "Brooks", 25));
        students.add(new Student("Persis", "Khambatta", 50));
        students.add(new Student("James", "Doohan", 70));
        students.add(new Student("DeForest", "Kelley", 65));

        Collections.sort(students, Comparator.comparingInt(Student::getAge));
        students.add(new Student("aslam", "shaik", 85));
        Collections.sort(students, Comparator.nullsFirst
                (Comparator.comparing(Student::getFirstName)));
        System.out.println("Students:");
        students.forEach(System.out::println);

        List<Student> william = students.stream()
                .filter(e -> e.getFirstName().equalsIgnoreCase("william"))
                .collect(Collectors.toList());
        william.stream().forEach(System.out::println);
    }
}
