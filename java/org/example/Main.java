package org.example;

import java.util.*;

public class Main {

    static void deleteStudent(Set<Student> students) {
        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            Student s = it.next();
            if (s.averageMarks() < 3) {
                it.remove();
            }
        }

    }

    static void transferStudent(Set<Student> students) {
        for (Student s : students) {
            if (s.averageMarks() >= 3) {
                s.course = s.course + 1;
            }
        }
    }

    static void printStudents(Set<Student> students, int course) {
        System.out.println("Список студентов  " + course + " курса");
        for (Student s : students) {
            if (s.course == course) {
                System.out.println(s.name);
            }
        }
    }


    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();
        students.add(new Student("Анастасия", "А", 1, Arrays.asList(10, 9, 10)));
        students.add(new Student("Галина", "Б", 2, Arrays.asList(2, 2, 1)));
        students.add(new Student("Евгений", "В", 1, Arrays.asList(3, 4, 9)));
        students.add(new Student("Иван", "Г", 2, Arrays.asList(9, 8, 10)));
        students.add(new Student("Петр", "Д", 1, Arrays.asList(1, 2, 3)));
        students.add(new Student("Надежда", "Ж", 2, Arrays.asList(5, 3, 1)));

        printStudents(students, 1);
        System.out.println();
        printStudents(students, 2);
        System.out.println();
        deleteStudent(students);
        transferStudent(students);
        System.out.println("Результат перевода студентов");
        printStudents(students, 2);
        System.out.println();
        printStudents(students, 3);
        System.out.println();

        Phone pb = new Phone();
        pb.add("Медведева", "+375333333333");
        pb.add("Исаков", "+375336524896");
        pb.add("Иванов", "+375297332510");
        pb.add("Медведева", "+375291234568");
        System.out.println("Телефонный справочник:");
        pb.get("Медведева");
        pb.get("Исаков");
        pb.get("Иванов");
        pb.get("Василько");

    }

}
