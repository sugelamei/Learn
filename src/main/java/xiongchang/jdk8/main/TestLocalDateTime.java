package xiongchang.jdk8.main;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalUnit;
import java.util.Set;

public class TestLocalDateTime {
    //1.LocalDate  LocalTime  LocalDateTime

    @Test
    public void test(){
        LocalDateTime localDateTime  = LocalDateTime.now();
        System.out.println(localDateTime);

        LocalDateTime localDateTime1  = LocalDateTime.of(2019,10,19,13,13,14);
        System.out.println(localDateTime1);


        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getDayOfYear());
        System.out.println(localDateTime.getHour());
        System.out.println(localDateTime.getMinute());
        System.out.println("----");
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getNano());
        System.out.println(localDateTime.getSecond());
        System.out.println(localDateTime.getYear());



    }

    //Instant  时间戳
    @Test
    public void test1(){
        Instant instant  = Instant.now();
        System.out.println(instant);

        OffsetDateTime odt  = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(odt);

        System.out.println(instant.getNano());

        System.out.println(instant.toEpochMilli());

        Instant instant1 = Instant.ofEpochSecond(1);


        System.out.println(instant1);




    }
    @Test
    public void test2() throws InterruptedException {

        Instant  ins1  = Instant.now();
        Thread.sleep(1000);
        Instant  ins2  = Instant.now();
        Duration between = Duration.between(ins1, ins2);
        System.out.println(between.toMillis());


        LocalDate ld1  = LocalDate.of(2015,1,1);
        Thread.sleep(2000);
        LocalDate ld2  = LocalDate.now();

        System.out.println(Period.between(ld1,ld2).getYears());

    }

    @Test
    public void test3() throws InterruptedException {

        LocalDate ld1  = LocalDate.now();

        System.out.println(ld1);
        LocalDate ld2  = ld1.withYear(1);
        System.out.println(ld2);

        System.out.println(ld1.with(TemporalAdjusters.next(DayOfWeek.MONDAY)));


    }


    //时间格式
    @Test
    public  void  test4(){
        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        LocalDateTime localDateTime  = LocalDateTime.now();
        System.out.println(dtf.format(localDateTime));
        System.out.println(dtf.parse("2019-07-13 20:59:55.873"));

    }

    @Test
    public void  test5(){
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();

//        for (String availableZoneId : availableZoneIds) {
//            System.out.println(availableZoneId);
//        }

        //Asia/Shanghai
        LocalDateTime ldt1  = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println(ldt1);
        //Hongkong
        LocalDateTime ldt2  = LocalDateTime.now(ZoneId.of("Hongkong"));
        System.out.println(ldt2);
        System.out.println(ldt2.atZone(ZoneId.of("Pacific/Guadalcanal")));

    }
}
