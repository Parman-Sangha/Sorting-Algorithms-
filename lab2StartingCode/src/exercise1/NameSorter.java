package exercise1;

import java.util.Comparator;

public class NameSorter implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        int ageDiff = Integer.compare(s1.getAge(), s2.getAge());
        return ageDiff != 0 ? ageDiff : s1.getName().compareTo(s2.getName());
    }
}