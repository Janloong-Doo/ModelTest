package com.du.rxjavatest;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.du.rxjavatest.base.Myapplication;
import com.jakewharton.threetenabp.AndroidThreeTen;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.Duration;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.LocalTime;
import org.threeten.bp.Month;
import org.threeten.bp.OffsetTime;
import org.threeten.bp.Period;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.ZonedDateTime;
import org.threeten.bp.temporal.ChronoUnit;

import static org.junit.Assert.*;
import static org.threeten.bp.temporal.TemporalAdjusters.lastDayOfMonth;
import static org.threeten.bp.temporal.TemporalAdjusters.previousOrSame;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
//        Context appContext = InstrumentationRegistry.getTargetContext();
//
//        assertEquals("com.du.rxjavatest", appContext.getPackageName());
        AndroidThreeTen.init(Myapplication.myapplication);
        LocalDateTime now1 = LocalDateTime.now();
        System.out.println("-------------------------");
        System.out.println("Local" + now1);
        System.out.println("-------------------------");

        // 创建时间对象
        LocalDateTime timePoint = LocalDateTime.now(); // 当前时间
        System.out.println("--当前时间----");
        System.out.println(timePoint);
        System.out.println("");
        System.out.println("--自定义时间----");
        System.out.println(LocalDate.of(2012, Month.DECEMBER, 12)); // from
        // values
        System.out.println(LocalDate.ofEpochDay(150)); // middle of 1970
        System.out.println(LocalTime.of(17, 18)); // the train I took home today
        System.out.println(LocalTime.parse("10:15:30")); // From a String
        System.out.println("");
        System.out.println("--获取时间的各个部分----");
        System.out.println(timePoint.toLocalDate());
        System.out.println(timePoint.getMonth());
        System.out.println(timePoint.getDayOfMonth());
        System.out.println(timePoint.getSecond());
        System.out.println("");
        System.out.println("---设置并返回新的时间对象---");
        LocalDateTime thePast = timePoint.withDayOfMonth(10).withYear(2010);
        System.out.println(thePast);
        System.out.println("---再加3周---");
        LocalDateTime yetAnother = thePast.plusWeeks(3).plus(3,
                ChronoUnit.WEEKS);
        System.out.println(yetAnother);
        System.out.println("");
        System.out.println("---使用时间调整函数---");
        System.out.println(timePoint);
        System.out.println(timePoint.with(lastDayOfMonth()));
        System.out.println(timePoint.with(previousOrSame(DayOfWeek.WEDNESDAY)));
        System.out.println(timePoint.with(LocalTime.now()));
        System.out.println("");
        System.out.println("---截断时间精确位--");
        System.out.println(timePoint);
        LocalDateTime truncatedTimeToMinutes = timePoint
                .truncatedTo(ChronoUnit.MINUTES);
        System.out.println(truncatedTimeToMinutes);
        LocalDateTime truncatedTimeToSeconds = timePoint
                .truncatedTo(ChronoUnit.SECONDS);
        System.out.println(truncatedTimeToSeconds);
        System.out.println("");
        System.out.println("---使用时区---");
        ZonedDateTime zoned_now = ZonedDateTime.of(LocalDateTime.now(),
                ZoneId.of("UTC+08:00"));
        System.out
                .println(zoned_now.withZoneSameInstant(ZoneId.of("UTC+00:00")));
        System.out.println(zoned_now.getOffset());
        System.out.println("");
        System.out.println("---时间上使用时区偏移---");
        OffsetTime time = OffsetTime.now();
        ZoneOffset offset = ZoneOffset.of("+02:00");
        System.out.println(time);
        System.out.println(time.withOffsetSameInstant(offset));
        System.out.println("");
        System.out.println("---时间加减---");
        timePoint = LocalDateTime.now();
        System.out.println(timePoint);
        // 3 years, 2 months, 1 day
        Period period1 = Period.of(3, 2, 1);
        System.out.println(timePoint.plus(period1));
        Duration duration = Duration.ofSeconds(3, 5);
        System.out.println(timePoint.plus(duration));
        Duration sixHours = Duration.between(
                ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("UTC+08:00")),
                ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("UTC+02:00")));
        System.out.println(timePoint.plus(sixHours));
        System.out.println("");
    }
}


