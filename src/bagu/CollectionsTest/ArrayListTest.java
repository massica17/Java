package bagu.CollectionsTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student implements Comparable<Student> {
    private int age;
    private String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Student() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Student o) {
        return this.getAge() - o.getAge();
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
public class ArrayListTest {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(12, "zl"));
        students.add(new Student(13, "kj"));
        students.add(new Student(10, "kj2"));
        Collections.sort(students);
        System.out.println(students);
    }
}
