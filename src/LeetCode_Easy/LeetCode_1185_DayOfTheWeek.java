package LeetCode_Easy;

import java.time.LocalDate;

public class LeetCode_1185_DayOfTheWeek {
    public static void main(String[] args) {
        System.out.println(new LeetCode_1185_DayOfTheWeek().dayOfTheWeek(31, 8, 2019));
        System.out.println(new LeetCode_1185_DayOfTheWeek().dayOfTheWeek(18, 7, 1999));
    }

    public String dayOfTheWeek(int day, int month, int year) {
        LocalDate localDate = LocalDate.of(year, month, day);
        switch (localDate.getDayOfWeek()) {
            case MONDAY:
                return "Monday";
            case TUESDAY:
                return "Tuesday";
            case WEDNESDAY:
                return "Wednesday";
            case THURSDAY:
                return "Thursday";
            case FRIDAY:
                return "Friday";
            case SATURDAY:
                return "Saturday";
            case SUNDAY:
                return "Sunday";
        }
        return "";
    }
}
