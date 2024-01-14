package Seminar3.HW3_additionalPart;
// Имеется список студентов. Каждый студент имеет имя, список оценок и специальность.
//Найдите первых 5 студентов специальности "Информатика" с средним баллом выше 4.5, отсортированных по убыванию среднего балла.
//В решении не использовать циклы! Только StreamAPI

import Seminar3.Seminar.Model.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Student student1 = new Student("Student1", Arrays.asList(4.0, 3.7, 4.8), Specialization.INFORMATICS);
        Student student2 = new Student("Student2", Arrays.asList(4.8, 4.7, 4.8), Specialization.INFORMATICS);
        Student student3 = new Student("Student3", Arrays.asList(4.6, 4.6, 4.8), Specialization.INFORMATICS);
        Student student4 = new Student("Student4", Arrays.asList(4.6, 4.6, 4.8), Specialization.ELECTRICAL_ENGINEERING);
        Student student5 = new Student("Student5", Arrays.asList(4.3, 4.4, 4.0), Specialization.MECHANICAL_ENGINEERING);
        Student student6 = new Student("Student6", Arrays.asList(5.0, 5.0, 5.0), Specialization.INFORMATICS);
        Student student7 = new Student("Student7", Arrays.asList(4.5, 4.6, 4.6), Specialization.INFORMATICS);
        Student student8 = new Student("Student8", Arrays.asList(5.0, 4.7, 4.7), Specialization.INFORMATICS);

        ArrayList <Student> students = new ArrayList<>(Arrays.asList(student1, student2, student3, student4, student5, student6, student7, student8));
        getListInformaticsStudentsWithHighGrade(students);
    }

    public static void getListInformaticsStudentsWithHighGrade(ArrayList<Student> students) {
        ArrayList<Student> filteredStudentsList = students.stream()
                .filter(student -> student.getSpecialization() == Specialization.INFORMATICS)
                .filter(student -> student.getAverageGrade() > 4.5)
                .sorted(Comparator.comparingDouble(Student::getAverageGrade))
                .collect(Collectors.toCollection(ArrayList::new));
        Collections.reverse(filteredStudentsList);
        System.out.println(filteredStudentsList);
    }
}
