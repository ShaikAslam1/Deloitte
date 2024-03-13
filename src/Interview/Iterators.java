package Interview;

import java.util.*;

public class Iterators {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("William", "Shatner", 60));
        personList.add(new Person("William", "Brooks", 25));
        personList.add(new Person("Persis", "Khambatta", 50));
        personList.add(new Person("James", "Doohan", 70));
        personList.add(new Person("DeForest", "Kelley", 65));

        Iterator<Person> personIterator = personList.iterator();
        while (personIterator.hasNext()) {
            System.out.println(personIterator.next());
//            personIterator.remove();
        }

        ListIterator<Person> personListIterator = personList.listIterator(1);
        while (personListIterator.hasNext()) {
            personListIterator.next();
//            while(personListIterator.hasPrevious())
//                personListIterator.previous();
        }

        List<String> carList = new ArrayList<String>();
        carList.add("Audi");
        carList.add("BMW");
        carList.add("Jaguar");
        carList.add("BMW");
        carList.add("Mini Cooper");

        carList.remove("BMW"); // it only removes first occurrence of BMW
        carList.forEach(System.out::println);
        System.out.println("2nd iteration");
        carList.remove("BMW");
        carList.forEach(System.out::println);
        System.out.println("3rd iteration");
        carList.remove("BMW");
        carList.forEach(System.out::println);

        // sorting
        carList.sort(Comparator.naturalOrder());
    }
}
