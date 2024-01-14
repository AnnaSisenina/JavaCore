package Seminar3.Seminar.Service;

import Seminar3.Seminar.Model.Employee;
import Seminar3.Seminar.Model.Manager;

public class ChangeSalary {

    public static void increaseSalary(Employee[] employees, int age, int amount){
        for (Employee employee: employees){
            if (employee.getAge() > age && !(employee instanceof Manager)) {
                employee.setSalary(employee.getSalary() + amount);
            }
        }
    }

    public static void increaseSalary(Employee[] employees){
        for (Employee employee: employees){
            if (employee.getAge() > 45 && !(employee instanceof Manager)) {
                employee.setSalary(employee.getSalary() + 5000);
            }
        }
    }
}
