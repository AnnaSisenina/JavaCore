package Seminar3.Seminar.Service;

import Seminar3.Seminar.Model.Employee;

import java.util.Arrays;

public class AnalyseSalary {

    public static double printAverageSalary(Employee[] employees){
        return Arrays.stream(employees).mapToDouble(Employee::getSalary).average().orElse(0);
    }
}
