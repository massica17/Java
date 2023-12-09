package BaseStruct.Test3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Nurse {
    private LocalDate firstDay;
    public  static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public Nurse(LocalDate firstDay) {
        this.firstDay = firstDay;
    }

    public Nurse() {
    }

    public LocalDate getFirstDay() {
        return firstDay;
    }

    public void setFirstDay(LocalDate firstDay) {
        this.firstDay = firstDay;
    }

    @Override
    public String toString() {
        return "Nurse{" +
                "firstDay=" + firstDay.toString() +
                '}';
    }
}
