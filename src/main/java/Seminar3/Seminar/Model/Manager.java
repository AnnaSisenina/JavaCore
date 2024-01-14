package Seminar3.Seminar.Model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Manager extends Employee{
    public Manager(String name, String position, String phone, double salary, LocalDate dateOfBirth) {
        super(name, position, phone, salary, dateOfBirth);
    }
    public void info() {
        System.out.println("Employee{" +
                "name='" + getName() + '\'' +
                ", position='" + getPosition() + '\'' +
                ", phone='" + getPhone() + '\'' +
                ", salary=" + getSalary() +
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
                , getName()
                , getPosition()
                , getPhone()
                , getSalary()
                , getAge());
    }

}
