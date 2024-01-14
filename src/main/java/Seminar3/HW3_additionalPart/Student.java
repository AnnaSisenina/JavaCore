package Seminar3.HW3_additionalPart;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class Student {
    private String name;
    private List<Double> grades;
    private Specialization specialization;


    @Override
    public String toString() {
        return infoFormat();
    }

    public String infoFormat(){
        return String.format("Student {name = '%s'" +
                        ", grades = '%s'" +
                        ", averageGrade = %.2f" +
                        ", Specialization = '%s'\n"
                , name
                , grades.toString()
                , getAverageGrade()
                , getSpecialization());
    }
    public double getAverageGrade(){
        return grades.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);
    }
}


