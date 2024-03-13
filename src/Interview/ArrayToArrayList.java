package Interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayToArrayList {
    public static void main(String[] args) {
        String[] carArray = {"Audi", "Jaguar", "BMW", "Mini Cooper"};
        List<String> carList = new ArrayList<>();

        Collections.addAll(carList, carArray);

        System.out.println("\n Collections add all\n");
        carList.forEach(System.out::println);

        System.out.println("\n Car List Stream\n");
        List<String> carListStream = Stream.of(carArray).collect(Collectors.toList());
        carListStream.forEach(System.out::println);

        // ordered, unique, allow null elements, uses LinkedHashMap implementation
        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("Item");
        linkedHashSet.add("Car");
        linkedHashSet.add("Fridge");

        // synchronized LinkedHashSet
        Set<String> synchronizedLinkedHashSet = Collections.synchronizedSet(linkedHashSet);

        Set<String> setMap = new HashSet<>();
        setMap.add("A");
        setMap.add("E");
        setMap.add("C");
        setMap.add("B");
        setMap.add("D");

        List<String> listSet = new ArrayList<>(setMap);
        Collections.sort(listSet);
        System.out.println("\n Set List Sorted:\n");
        listSet.forEach(System.out::println);

        Map<Employee, Employee> treeMap = new TreeMap<>(Comparator.comparing(Employee::getLastName));
        Employee e1 = new Employee("Aslam", "Shaik");
        Employee e2 = new Employee("Areef", "Kadumuru");
        treeMap.put(e1, e1);
        treeMap.put(e2, e2);
        System.out.println("=================TREE MAP");
        treeMap.entrySet().forEach(System.out::println);

        Map<String, String> hashTable = new Hashtable<>();
        hashTable.put("A", "a");

        Map<String, String> map = new HashMap<>();
        map.put("Washinton", "DC");
        map.put("USA", "CD");

        map.merge("India", "Delhi", (oldValue, newValue) -> oldValue + "/" + newValue);
        map.merge("USA", "California", (oldValue, newValue) -> newValue + "/" + oldValue);

        map.entrySet().forEach(System.out::println);
        // test

        // synchronization, thread safe
        Map<Integer, String> concurrentHashMap = new ConcurrentHashMap<>();
        Map<Integer, String> synchronizedMap = Collections.synchronizedMap(concurrentHashMap);
    }
}
class KeyComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getLastName().compareTo(o2.getLastName());
    }
}