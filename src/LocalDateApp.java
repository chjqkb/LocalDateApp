/*
打印一个月的日历
 */

import java.io.PrintStream;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public class LocalDateApp {

    public static void main(String[] args) {
        PrintStream out = System.out;
        LocalDate date = LocalDate.now();

        int year = date.getYear();
        Month month = date.getMonth();
        int day = date.getDayOfMonth();

        //out.printf("%1$s,%2$d,%3$d\n", month, day, year);

        //本月一共有多少天
        int days = month.length(date.isLeapYear());
        //out.printf("本月一共 %d\n", days);
        LocalDate firstDate= LocalDate.of(year, month,1);

        //1号是星期几？
        DayOfWeek firstWeek = firstDate.getDayOfWeek();
        //out.println("\nfirst weekday: " + firstWeek.getValue());

        out.printf("%d,%d\n", month.getValue(), year);
        for (DayOfWeek weekday : DayOfWeek.values()) {
            out.printf("%s\t", weekday.toString().substring(0, 3));
            //System.out.printf("%d\t", weekday.getValue());
        }
        out.println();


        for (int i = 1; i < firstWeek.getValue(); i++) {
            out.print("   \t");
        }

        for (int j = 1; j <= days; j++) {
            out.printf("%3d\t", j);
            if ((j + firstWeek.getValue()) % 7 == 1) {
                out.println();
            }

        }

    }
}
