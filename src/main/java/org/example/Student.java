package org.example;

public class Student {

    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    // STATIC Comparators

    public static int compareByName(Student s1, Student s2) {
            return s1.name.compareTo(s2.name);
    }

    //
    public static int compareByNameThenAge(Student s1, Student s2) {
        if (s1.name.equals(s2.name)) {
            return Integer.compare(s1.age, s2.age);
        } else {
            return s1.name.compareTo(s2.name);
        }
    }



}
