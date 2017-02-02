package com.du.rxjavatest;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.du.rxjavatest.base.Myapplication;
import com.du.rxjavatest.bean.Recivefornews;
import com.du.rxjavatest.utils.OkGoUtils;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button whatfuck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        getRxjava();

        whatfuck = (Button) findViewById(R.id.whatfuck);
        whatfuck.setOnClickListener(this);
    }

    public void getRxjava() {
        Observable.just("1", "2", "3", "4")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.whatfuck:
                System.out.println("点击了");
                OkGoUtils.get();
                break;
        }
    }
}