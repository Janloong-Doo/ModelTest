package com.du.rxjavatest;

import android.content.Context;
import android.util.Log;

import com.du.rxjavatest.base.Myapplication;
import com.jakewharton.threetenabp.AndroidThreeTen;

import org.junit.Test;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZonedDateTime;
import org.threeten.bp.format.DateTimeFormatter;

import static com.du.rxjavatest.base.Myapplication.myapplication;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);

        AndroidThreeTen.init(myapplication);
        LocalDateTime now1 = LocalDateTime.now();

        System.out.println("Local");
        System.out.println("Local" + now1);

//        ZonedDateTime now = ZonedDateTime.now();

//        Log.e("LocalDateTime", String.valueOf(now1.toLocalTime()));
//        Log.e("ZonedDateTime", String.valueOf(now.toLocalDateTime()));

    }
}