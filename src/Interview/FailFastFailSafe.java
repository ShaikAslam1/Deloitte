package Interview;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailFastFailSafe {
    public static void main(String[] args) {
        List<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();

        copyOnWriteArrayList.add("A");
        copyOnWriteArrayList.add("B");
        copyOnWriteArrayList.add("C");
        copyOnWriteArrayList.add("D");

        // iterator work with snapshot, not with the actual object

        Iterator<String> iterator = copyOnWriteArrayList.iterator();
        while (iterator.hasNext()) {
            copyOnWriteArrayList.add("E");
            System.out.println(iterator.next());
            // we are adding elements using the actual reference
            copyOnWriteArrayList.add("F");
            copyOnWriteArrayList.remove("C");
            copyOnWriteArrayList.remove(0);
        }

        System.out.println("After iteration over");

        copyOnWriteArrayList.forEach(System.out::println);

        System.out.println("Concurrent Hash Map");

        Map<Integer, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put(1, "One");
        concurrentHashMap.put(2, "Two");
        concurrentHashMap.put(3, "Three");
        concurrentHashMap.put(4, "Four");

        Iterator<Map.Entry<Integer, String>> mapIterator = concurrentHashMap.entrySet().iterator();

        while (mapIterator.hasNext()) {
            System.out.println(mapIterator.next());
            concurrentHashMap.put(5, "Five");
            concurrentHashMap.put(6, "Six");
            concurrentHashMap.put(7, "Seven");
            concurrentHashMap.remove(2);
        }

        System.out.println("After Map Iteration over");

        concurrentHashMap.entrySet().forEach(System.out::println);
    }
}
