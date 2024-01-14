package Seminar3.Seminar;

import Seminar3.Seminar.Model.Employee;
import Seminar3.Seminar.Model.Manager;
import Seminar3.Seminar.Service.AnalyseSalary;
import Seminar3.Seminar.Service.ChangeSalary;
import Seminar3.Seminar.Service.DataBirthAnalyse;

import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Employee ivan = new Employee("Ivan", "developer", "8914556789", 100000.0, LocalDate.of(1998, 11, 25));
        Employee olga = new Employee("Olga", "tester", "8769056778", 80000.0, LocalDate.of(1995, 10, 15));
        Employee sergei = new Employee("Sergei", "designer", "9112056745", 100000.0, LocalDate.of(1993, 7, 11));
        Employee natlia = new Employee("Natalia", "analyst", "9824567123", 100000.0, LocalDate.of(1976, 5, 5));
        Manager andrey = new Manager("Andrey", "devops", "9119067896", 130000.0, LocalDate.of(1977, 11, 4));

        Employee[] employees = {ivan, olga, sergei, natlia, andrey};

//        Employee[] employees1 = {new Employee("Ivan", "developer", "8914556789", 1000.0, LocalDate.of(1998, 11, 25),
//                new Employee("Olga", "tester", "8769056778", 150.0, LocalDate.of(1995, 10, 15)),
//                new Employee("Sergei", "designer", "9112056745", 200.0, LocalDate.of(1993, 7, 11)),
//                new Employee("Natalia", "analyst", "9824567123", 250.0, LocalDate.of(1990, 5, 5)),
//                new Employee("Andrey", "devops", "9119067896", 300.0, LocalDate.of(1977, 11, 4))};

        System.out.println(Arrays.toString(employees));
        ChangeSalary.increaseSalary(employees);

        System.out.println(Arrays.toString(employees));

        ChangeSalary.increaseSalary(employees, 45, 5000);
        System.out.println(Arrays.toString(employees));

        System.out.println(AnalyseSalary.printAverageSalary(employees));

        System.out.println(DataBirthAnalyse.compareDatesOfBirth(olga.getDateOfBirth(), ivan.getDateOfBirth()));


    }





}