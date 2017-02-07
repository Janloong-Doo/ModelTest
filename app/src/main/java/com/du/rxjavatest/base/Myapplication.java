package com.du.rxjavatest.base;

import android.app.Application;

import com.jakewharton.threetenabp.AndroidThreeTen;
import com.lzy.okgo.OkGo;

/**
 * Created by Administrator on 2017/2/2.
 */

public class Myapplication extends Application {
    public static Myapplication myapplication = null;

    @Override
    public void onCreate() {
        super.onCreate();
        AndroidThreeTen.init(this);
        if (myapplication == null) {
            myapplication = this;
        }
        initOkGo();
    }


    private void initOkGo() {
        OkGo.init(this);
    }
}
