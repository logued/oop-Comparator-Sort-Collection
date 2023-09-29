package org.example;

import java.util.Comparator;

public class StudentNameComparator implements Comparator<Student>
{
    // implement the compare() method required by the Comparator interface
    @Override
    public int compare(Student s1, Student s2)
    {
        return s1.getName().compareTo(s2.getName());

        // The student name is of type String and the String class implements
        // a compareTo() method that returns -1, 0, or +1 as appropriate.
        // So, to compare string fields we simply use the compareTo() method
        // of the String class.
    }
}