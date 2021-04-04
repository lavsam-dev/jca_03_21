package ru.geekbrains.lesson10;

import java.util.*;
import java.util.function.Predicate;

public class CollectionsExample {
    public static void main(String[] args) {
        //        listsEx();
//        setsEx();
//        Map<String, Integer> map = new HashMap<>();
//        HashMap<String, Integer> map = new HashMap<>();
//        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        TreeMap<String, Integer> map = new TreeMap<>();

        map.put("First", 10);
        map.put("Second", 50);
        map.put("Third", 40);
//        map.put("First", 45);
//        map.putIfAbsent("First", 45);
//        System.out.println(map.get("Third1"));

//        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

//        for (Map.Entry<String, Integer> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + ": " + entry.getValue());
//        }
        System.out.println(map);
//        map.forEach((k, v) -> System.out.println(k +": " + v));
    }

    private static void setsEx() {


//        Set<String> set = new HashSet<>();
//        HashSet<String> set = new HashSet<>();
//        LinkedHashSet<String> set = new LinkedHashSet<>();
//        TreeSet<String> set = new TreeSet<>();
//        set.add("January");
//        set.add("February");
//        set.add("March");
//        set.add("February");
//
//        System.out.println(set);

//        HashSet<Box> set = new HashSet<>();
//        LinkedHashSet<Box> set = new LinkedHashSet<>();
        TreeSet<Box> set = new TreeSet<>();
        set.add(new Box(1, 1, 5));
        set.add(new Box(2, 2));
        set.add(new Box(3, 3));
        set.add(new Box(1, 1, 10));
//        for (int i = 0; i < set.size(); i++) {
//
//        }
        System.out.println(set);
//        for (Box box : set) {
//            System.out.println(box);
//        }
//        set.forEach(element -> System.out.println(element));
    }

    private static void listsEx() {
//        Vector<String> vector;
        //        List<String> list = new ArrayList<>();
//        ArrayList<String> list = new ArrayList<>();
        LinkedList<String> list = new LinkedList<>();
//        List list = new ArrayList();
        list.add("January");
        list.add("February");
        list.add("March");
        list.add("February");
//        list.add(2, "May");
//        List<String> list2 = Arrays.asList("1", "2", "3");
//        list.addAll(list2);
//        list.remove(1);
//        list.remove("February");
//        System.out.println(list.indexOf("February"));
//        System.out.println(list.lastIndexOf("February"));

//        list.removeIf(s -> s.startsWith("F"));
//        list.set(1, "May");
//        list.sort((o1, o2) -> o2.length() - o1.length());
//        list.retainAll(Arrays.asList("March", "January"));
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
//        System.out.println(list);
//        for (String s : list) {
//            System.out.println(s);
//        }
//        list.get(4);


//        Iterator<String> iter = list.iterator();
//        while (iter.hasNext()) {
////            System.out.println(iter.next());
//            iter.next();
////            iter.remove();
//
//        }
//        ListIterator<String> iterator = list.listIterator();
//        while (iterator.hasNext()) {
//
//        }
//        list.forEach(System.out::println);


        System.out.println(list);
    }
}
