package BaseStruct.Test3;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Test3 {
    public static void main(String[] args) {
        DateTimeFormatter df =Nurse.dateTimeFormatter;
        LocalDate first = LocalDate.parse("2022-02-03", df);
        Nurse nurse = new Nurse(first);
        LocalDate now = LocalDate.now();
        System.out.println(now.format(df));
        long days = first.until(now, ChronoUnit.DAYS);
        for(long i = 0L; i <= days; i++){
            if(i % 3 == 0) System.out.printf("%s(休息日)%n", first.plusDays(i).format(df));
            else System.out.printf("%s(工作日)%n", first.plusDays(i).format(df));
        }

        DateTimeFormatter df_new = DateTimeFormatter.ofPattern("yyyy年MM月dd日HH时mm分00秒");
        LocalDateTime testDay = LocalDateTime.parse("2024年06月07日09时00分00秒", df_new);
        while(true){
            LocalDateTime now_time = LocalDateTime.now();
            Duration duration = Duration.between(now_time, testDay);
            days = duration.toDays();
            long hours = duration.minusDays(days).toHours();
            long minutes = duration.minusDays(days).minusHours(hours).toMinutes();
            long second = duration.minusDays(days).minusHours(hours).minusMinutes(minutes).toSeconds();
            System.out.printf("%d天 %d时 %d分 %d秒 %n", days, hours, minutes, second);
            if(second == 0) return;
        }
    }
}
