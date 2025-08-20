package Utils;

import java.time.LocalDate;
import java.time.DayOfWeek;

public class DayOfWeekDemo {
    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        DayOfWeek currentDayOfWeek = currentDate.getDayOfWeek();
        System.out.println("Today is " + currentDayOfWeek);
    }
}

