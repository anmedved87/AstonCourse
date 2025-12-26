package org.example;

import java.util.*;

public class Student {
    String name;
    String group;
    int course;
    List<Integer> marks;


    Student(String name, String group, int course, List<Integer> marks) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.marks = marks;
    }


    double averageMarks() {
        int sum = 0;
        for (int m : marks) {
            sum = sum + m;
        }
        return (double) sum / marks.size();
    }
}
