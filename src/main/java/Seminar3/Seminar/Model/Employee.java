package Seminar3.Seminar.Model;

import lombok.Data;

import java.time.LocalDate;
import java.time.Period;

@Data
public class Employee {
    private String name;
    private String position;
    private String phone;
    private double salary;
    private int age;
    private LocalDate dateOfBirth;

    public Employee() {
    }
    public Employee(String name, String position, String phone, double salary, LocalDate dateOfBirth) {
        this.name = name;
        this.position = position;
        this.phone = phone;
        this.salary = salary;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public int getAge() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    public void info() {
        System.out.println("Employee{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", phone='" + phone + '\'' +
                ", salary=" + salary +
                ", age=" + getAge() +
                '}');
    }

/*    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", phone='" + phone + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }*/

    @Override
    public String toString() {
        return infoFormat();
    }

    public String infoFormat(){
        return String.format("Employee {name = '%s'" +
                        ", position = '%s'" +
                        ", phone = '%s'" +
                        ", salary = %.2f" +
                        ", age = %d }\n"
                , name
                , position
                , phone
                , salary
                , getAge());
    }



}
