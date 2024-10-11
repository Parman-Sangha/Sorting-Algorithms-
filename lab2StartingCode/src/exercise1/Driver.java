package exercise1;

import java.util.ArrayList;
import java.util.Collections;

public class Driver {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("Smith", 34));
        list.add(new Student("Johnson", 21));
        list.add(new Student("Williams", 67));
        list.add(new Student("Brown", 53));
        list.add(new Student("Jones", 48));
        list.add(new Student("Miller", 36));
        list.add(new Student("Davis", 44));
        list.add(new Student("Wilson", 52));
        list.add(new Student("Anderson", 34));
        list.add(new Student("Moore", 33));

        System.out.println("Before sorting by name:");
        for (Student s : list) {
            System.out.println(s);
        }

        Collections.sort(list);
        System.out.println("\nAfter sorting by name:");
        for (Student s : list) {
            System.out.println(s);
        }

        Collections.sort(list, new NameSorter());
        System.out.println("\nAfter sorting by age:");
        for (Student s : list) {
            System.out.println(s);
        }
    }
}