/**
 * Demonstrates:                            Sept 2023
 * Sorting collection of objects using Comparator to determine order of elements
 * Collections.sort()
 * List.sort()
 * Using Lambda expressions for Comparators
 * Using static comparators
 */

package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Sorting Collections using Comparators");

        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Sarah", 10));
        studentList.add(new Student("Jack", 12));
        System.out.println("Initial List:");
        System.out.println(studentList);

        // 0. Sort a Collection by creating an instance of a Comparator class
        // (i.e. StudentNameComparator ) and pass it into Collections.sort()
        // as an argument.
        // (This is the more traditional approach)

        Collections.sort(studentList, new StudentNameComparator());


        // 1. Define a Comparator to compare Student objects by name,
        // using an 'Anonymous Inner Class' definition.
        // The class is defined anonymously (with no class name) within the
        // call to the sort method, and then it is instantiated as a Comparator
        // and passed as an argument.
        //
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getName().compareTo(s2.getName());
            }
        });

        System.out.println(studentList);

        // 2. Use Lambda Function to define Comparator.
        // Compare Student objects by name field.
        // An ArrayList implements the List interface, and the List defines a default sort method
        // that expects a Comparator as an argument to determine the ordering.
        // The Lambda function is a "stripped down" way of defining the compare function
        // in the expected Comparator.

        studentList.sort((Student s1, Student s2) -> s1.getName().compareTo(s2.getName()));

        // The advantage of this approach is that it is a bit more readable than
        // the anonymous inner class approach.
        // We simply define the compare method as a lambda (on the fly) where
        // the call is being made.

        // 3. Shortened Lambda Function to compare Students
        //    The lambda can be further abbreviated by leaving out the types of
        //    the parameters, which are then inferred from the type returned by getName()
        //
        studentList.sort((s1, s2) -> s1.getName().compareTo(s2.getName()));

        // The advantage of using the lambda style is that the code is concise
        // ( "reduced boilerplate code" )
        // and the logic of the 'compare' is located where the call is being made
        // to sort() the list.
        // However, you need to familiarise yourself with its syntax.

        // 4. Reversing order - use Comparator Helper function - reverse()
        // - assign lambda function to a variable (here called comparator)
        // - pass comparator with reverse() helper/modifier into sort()
        //
        Comparator<Student> comparator = (s1, s2) -> s1.getName().compareTo(s2.getName());
        studentList.sort(comparator.reversed());

        // 4. Call sort and pass in a static comparator
        studentList.sort(Student::compareByName);


        studentList.sort(Student::compareByNameThenAge);

        // Comparator with multiple conditions is used to
        // sort in more complex ways.
        // Here we define a lambda to sort on "age within name"
        // Logic:    if names are the same, then we consider age
        //           else, if names not the same then only consider name.
        //
        studentList.sort((s1, s2) -> {
            if (s1.getName().equals(s2.getName())) {
                return Integer.compare(s1.getAge(), s2.getAge());
            } else {
                return s1.getName().compareTo(s2.getName());
            }
        });
    }
}