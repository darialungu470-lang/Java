package Main;

import SchoolSystem.Student;

public class Main {
    static void main() {
        Student student = new Student(2);
        student.setGrade(4);
       // System.out.println(student.getName());
        System.out.println(student.getAge());
    }
}
