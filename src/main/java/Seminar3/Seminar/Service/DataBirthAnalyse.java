package Seminar3.Seminar.Service;

import java.time.LocalDate;

public class DataBirthAnalyse {

    public static int compareDatesOfBirth(LocalDate firstDate, LocalDate secondDate){
        return firstDate.compareTo(secondDate);
    }
}
