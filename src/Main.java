import hw_29_05_23.Pair;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Pair personOne = new Pair<String, Integer>("Oleg", 22);
        System.out.println(personOne);
        Pair personTwo = personOne.copy();
        System.out.println(personTwo);

        HashMap<Integer, Pair<String, Integer>> hashMap = new HashMap<>();
        hashMap.put(1, new Pair("Ivan", 21));
        hashMap.put(2, new Pair("Nickolay", 35));
        hashMap.put(3, personOne);

        for (Map.Entry<Integer, Pair<String, Integer>> entry : hashMap.entrySet()) {
            int position = entry.getKey();
            String name = entry.getValue().getFirst();
            int age = entry.getValue().getSecond();
            System.out.println("At position " + position + " - " + name + " of age " + age);
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList = addMillionToArrayList();
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList = addMillionToLinkedList();
    }

    /*
    Напишите метод, который добавляет 1000000 элементов в ArrayList и LinkedList. Напишите еще один метод, который
    выбирает из заполненного списка элемент наугад 100000 раз. Замерьте время, которое потрачено на это. Сравните
    результаты и предположите, почему они именно такие.
    */

    public static ArrayList<Integer> addMillionToArrayList() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Random random = new Random();
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 1_000_000; i++) {
            arrayList.add(random.nextInt());
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        System.out.println("The method " + methodName + " ran for " + duration + " ms");

        return arrayList;
    }

    public static LinkedList<Integer> addMillionToLinkedList() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        Random random = new Random();
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 1_000_000; i++) {
            linkedList.add(random.nextInt());
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        System.out.println("The method " + methodName + " ran for " + duration + " ms");

        return linkedList;
    }


}